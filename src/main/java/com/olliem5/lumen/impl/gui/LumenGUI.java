package com.olliem5.lumen.impl.gui;

import com.lukflug.panelstudio.CollapsibleContainer;
import com.lukflug.panelstudio.DraggableContainer;
import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.SettingsAnimation;
import com.lukflug.panelstudio.hud.HUDClickGUI;
import com.lukflug.panelstudio.mc16.GLInterface;
import com.lukflug.panelstudio.mc16.MinecraftHUDGUI;
import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.ColorScheme;
import com.lukflug.panelstudio.theme.SettingsColorScheme;
import com.lukflug.panelstudio.theme.Theme;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManager;
import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.settings.*;
import com.olliem5.lumen.api.traits.MinecraftTrait;
import com.olliem5.lumen.impl.modules.GUI;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public final class LumenGUI extends MinecraftHUDGUI {
    public static final int WIDTH = 100, HEIGHT = 12, DISTANCE = 10, HUD_BORDER = 2;
    private final Toggleable colorToggle;
    public final GUIInterface guiInterface;
    public final HUDClickGUI gui;
    private final Theme theme;

    public LumenGUI() {
        GUI clickGuiModule = ModuleManager.getModule(GUI.class);
        //ColorMain colorMain = ModuleManager.getModule(ColorMain.class);
        ColorScheme scheme = new SettingsColorScheme(clickGuiModule.colourSetting1, clickGuiModule.colourSetting2, clickGuiModule.colourSetting3, clickGuiModule.colourSetting4, clickGuiModule.colourSetting5, clickGuiModule.opacity);
        theme = new LumenTheme(scheme, HEIGHT, 2, 5);

        colorToggle = new Toggleable() {
            @Override
            public void toggle() {
                //colorMain.colorModel.increment();
            }

            @Override
            public boolean isOn() {
                //return colorMain.colorModel.getValue().equals("HSB");
                return false;
            }
        };
        guiInterface = new GUIInterface(true) {
            @Override
            public void drawString(Point pos, String s, Color c) {
                GLInterface.end();
                int x = pos.x + 2, y = pos.y + 1;
//                if (!colorMain.customFont.getValue()) {
//                    x += 1;
//                    y += 1;
//                }

                textRenderer.drawWithShadow(new MatrixStack(), s, x, y, c.getRGB());
                GLInterface.begin();
            }

            @Override
            public int getFontWidth(String s) {
                return Math.round(textRenderer.getWidth(s)) + 4;
            }

            @Override
            public int getFontHeight() {
                return Math.round(textRenderer.fontHeight) + 2;
            }

            @Override
            public String getResourcePrefix() {
                return "gamesense:gui/";
            }
        };
        gui = new HUDClickGUI(guiInterface, null) {
            @Override
            public void handleScroll(int diff) {
                super.handleScroll(diff);
                if (clickGuiModule.scrolling.getValue().equals("Screen")) {
                    for (FixedComponent component : components) {
                        if (!hudComponents.contains(component)) {
                            Point p = component.getPosition(guiInterface);
                            p.translate(0, -diff);
                            component.setPosition(guiInterface, p);
                        }
                    }
                }
            }
        };
        Toggleable hudToggle = new Toggleable() {
            @Override
            public void toggle() {
            }

            @Override
            public boolean isOn() {
//                return gui.isOn() && clickGuiModule.showHUD.isOn() || hudEditor;
                return false;
            }
        };

//        for (Module module : ModuleManager.getModules()) {
//            if (module instanceof HUDModule) {
//                ((HUDModule) module).populate(theme);
//                gui.addHUDComponent(new HUDPanel(((HUDModule) module).getComponent(), theme.getPanelRenderer(), module, new SettingsAnimation(clickGuiModule.animationSpeed), hudToggle, HUD_BORDER));
//            }
//        }
        Point pos = new Point(DISTANCE, DISTANCE);
        for (ModuleCategory category : ModuleCategory.values()) {
            DraggableContainer panel = new DraggableContainer(category.name(), null, theme.getPanelRenderer(), new SimpleToggleable(false), new SettingsAnimation(clickGuiModule.animationSpeed), null, new Point(pos), WIDTH) {

                @Override
                protected int getScrollHeight(int childHeight) {
                    if (clickGuiModule.scrolling.getValue().equals("Screen")) {
                        return childHeight;
                    }
                    return Math.min(childHeight, Math.max(HEIGHT * 4, LumenGUI.this.height - getPosition(guiInterface).y - renderer.getHeight(open.getValue() != 0) - HEIGHT));
                }
            };
            gui.addComponent(panel);
            pos.translate(WIDTH + DISTANCE, 0);
            for (Module module : ModuleManager.getModulesInCategory(category)) {
                addModule(panel, module);
            }
        }
    }

    private void addModule(CollapsibleContainer panel, Module module) {
        GUI clickGuiModule = ModuleManager.getModule(GUI.class);
        CollapsibleContainer container = new CollapsibleContainer(module.getName(), null, theme.getContainerRenderer(), new SimpleToggleable(false), new SettingsAnimation(clickGuiModule.animationSpeed), module);
        panel.addComponent(container);
        for (Setting property : module.getSettings()) {
            if (property instanceof BooleanSetting) {
                container.addComponent(new BooleanComponent(property.getName(), null, theme.getComponentRenderer(), (BooleanSetting) property));
            } else if (property instanceof IntegerSetting) {
                container.addComponent(new NumberComponent(property.getName(), null, theme.getComponentRenderer(), (IntegerSetting) property, ((IntegerSetting) property).getMin(), ((IntegerSetting) property).getMax()));
            } else if (property instanceof DoubleSetting) {
                container.addComponent(new NumberComponent(property.getName(), null, theme.getComponentRenderer(), (DoubleSetting) property, ((DoubleSetting) property).getMin(), ((DoubleSetting) property).getMax()));
            } else if (property instanceof ModeSetting) {
                container.addComponent(new EnumComponent(property.getName(), null, theme.getComponentRenderer(), (ModeSetting) property));
            } else if (property instanceof FloatSetting) {
                container.addComponent(new NumberComponent(property.getName(), null, theme.getComponentRenderer(), (FloatSetting) property, ((FloatSetting) property).getMin(), ((FloatSetting) property).getMax()));
            }
        }

    }

    @Override
    protected HUDClickGUI getHUDGUI() {
        return gui;
    }

    @Override
    protected GUIInterface getInterface() {
        return guiInterface;
    }

    @Override
    protected int getScrollSpeed() {
        return ModuleManager.getModule(GUI.class).scrollSpeed.getValue();
    }
}
