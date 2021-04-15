package com.olliem5.lumen.impl.gui;

import com.lukflug.panelstudio.CollapsibleContainer;
import com.lukflug.panelstudio.DraggableContainer;
import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.SettingsAnimation;
import com.lukflug.panelstudio.hud.HUDClickGUI;
import com.lukflug.panelstudio.mc16.GLInterface;
import com.lukflug.panelstudio.mc16.MinecraftHUDGUI;
import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.*;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManager;
import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.settings.*;
import com.olliem5.lumen.impl.gui.elements.ColourElement;
import com.olliem5.lumen.impl.modules.Colours;
import com.olliem5.lumen.impl.modules.GUI;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

/**
 * @author olliem5
 * @author lukflug
 * @since 1.0
 */

public final class LumenGUI extends MinecraftHUDGUI {
    private final int sizeWidth = 112;
    private final int sizeHeight = 14;
    private final Toggleable colourToggle;
    private final GUIInterface guiInterface;
    private final HUDClickGUI hudClickGUI;
    private final GUI gui = ModuleManager.getModule(GUI.class);
    private final Colours colours = ModuleManager.getModule(Colours.class);
    private final ColorScheme colourScheme = new SettingsColorScheme(gui.outlineColour, gui.enabledColour, gui.backgroundColour, gui.settingColour, gui.fontColour, gui.opacity);
    private final Theme theme;
    private final Theme lumenTheme = new LumenTheme(colourScheme, sizeHeight, 2, 5);
    private final Theme gameSenseTheme = new GameSenseTheme(colourScheme, sizeHeight, 2, 5);
    private final Theme clearTheme = new ClearTheme(colourScheme, false, sizeHeight, 1);
    private final Theme clearGradientTheme = new ClearTheme(colourScheme, true, sizeHeight, 1);

    public LumenGUI() {
        theme = new ThemeMultiplexer() {
            @Override
            protected Theme getTheme() {
                switch (gui.theme.getValue()) {
                    case "GameSense":
                        return gameSenseTheme;
                    case "Clear":
                        return clearTheme;
                    case "ClearGradient":
                        return clearGradientTheme;
                }
                return lumenTheme;
            }
        };

        colourToggle = new Toggleable() {
            @Override
            public void toggle() {
                colours.colourModel.increment();
            }

            @Override
            public boolean isOn() {
                return colours.colourModel.getValue().equals("HSB");
            }
        };

        guiInterface = new GUIInterface(true) {
            @Override
            public void drawString(Point point, String string, Color colour) {
                GLInterface.end();
                int x = point.x + 2;
                int y = point.y + 2;
                textRenderer.drawWithShadow(new MatrixStack(), string, x, y, colour.getRGB());
                GLInterface.begin();
            }

            @Override
            public int getFontWidth(String string) {
                return textRenderer.getWidth(string);
            }

            @Override
            public int getFontHeight() {
                return textRenderer.fontHeight;
            }

            @Override
            public String getResourcePrefix() {
                return "lumen/";
            }
        };

        hudClickGUI = new HUDClickGUI(guiInterface, null) {
            @Override
            public void handleScroll(int difference) {
                super.handleScroll(difference);

                if (gui.scroll.getValue().equals("Screen")) {
                    for (FixedComponent component : components) {
                        if (!hudComponents.contains(component)) {
                            Point point = component.getPosition(guiInterface);
                            point.translate(0, - difference);
                            component.setPosition(guiInterface, point);
                        }
                    }
                }
            }
        };

        int offset = 10;
        Point pos = new Point(offset, offset);

        for (ModuleCategory category : ModuleCategory.values()) {
            DraggableContainer panel = new DraggableContainer(category.getName(), null, theme.getPanelRenderer(), new SimpleToggleable(false), new SettingsAnimation(gui.animationSpeed), null, new Point(pos), sizeWidth) {
                @Override
                protected int getScrollHeight(int childHeight) {
                    if (gui.scroll.getValue().equals("Screen")) {
                        return childHeight;
                    }
                    return Math.min(childHeight, Math.max(sizeHeight * 4, LumenGUI.this.height - getPosition(guiInterface).y - renderer.getHeight(open.getValue() != 0) - sizeHeight));
                }
            };

            hudClickGUI.addComponent(panel);
            pos.translate(sizeWidth + offset, 0);

            for (Module module : ModuleManager.getModulesInCategory(category)) {
                addModule(panel, module);
            }
        }
    }

    private void addModule(CollapsibleContainer collapsibleContainer, Module module) {
        CollapsibleContainer container = new CollapsibleContainer(module.getName(), null, theme.getContainerRenderer(), new SimpleToggleable(false), new SettingsAnimation(gui.animationSpeed), module);
        collapsibleContainer.addComponent(container);

        for (Setting setting : module.getSettings()) {
            if (setting instanceof BooleanSetting) {
                container.addComponent(new BooleanComponent(setting.getName(), null, theme.getComponentRenderer(), (BooleanSetting) setting));
            } else if (setting instanceof IntegerSetting) {
                container.addComponent(new NumberComponent(setting.getName(), null, theme.getComponentRenderer(), (IntegerSetting) setting, ((IntegerSetting) setting).getMinimumValue(), ((IntegerSetting) setting).getMaximumValue()));
            } else if (setting instanceof DoubleSetting) {
                container.addComponent(new NumberComponent(setting.getName(), null, theme.getComponentRenderer(), (DoubleSetting) setting, ((DoubleSetting) setting).getMinimumValue(), ((DoubleSetting) setting).getMaximumValue()));
            } else if (setting instanceof FloatSetting) {
                container.addComponent(new NumberComponent(setting.getName(), null, theme.getComponentRenderer(), (FloatSetting) setting, ((FloatSetting) setting).getMinimumValue(), ((FloatSetting) setting).getMaximumValue()));
            } else if (setting instanceof ModeSetting) {
                container.addComponent(new EnumComponent(setting.getName(), null, theme.getComponentRenderer(), (ModeSetting) setting));
            } else if (setting instanceof ColourSetting) {
                container.addComponent(new ColourElement(theme, (ColourSetting) setting, colourToggle, new SettingsAnimation(gui.animationSpeed)));
            }
        }
    }

    @Override
    protected HUDClickGUI getHUDGUI() {
        return hudClickGUI;
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
