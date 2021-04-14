package com.olliem5.lumen.impl.gui;

import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.hud.HUDClickGUI;
import com.lukflug.panelstudio.mc8fabric.GLInterface;
import com.lukflug.panelstudio.mc8fabric.MinecraftHUDGUI;
import com.lukflug.panelstudio.settings.Toggleable;
import com.lukflug.panelstudio.theme.FixedDescription;
import com.lukflug.panelstudio.theme.Theme;
import com.olliem5.lumen.api.traits.MinecraftTrait;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class LumenGUI extends MinecraftHUDGUI implements MinecraftTrait {
    private final int width = 100;
    private final int height = 20;

    private final GUIInterface guiInterface;
    private final HUDClickGUI hudClickGUI;
    private final Toggleable hudEditorToggleable;
    private Theme theme;

    public LumenGUI() {
        this.guiInterface = new GUIInterface(true) {
            @Override
            public void drawString(Point point, String string, Color colour) {
                GLInterface.end();
                MinecraftTrait.textRenderer.drawWithShadow(new MatrixStack(), string, point.x, point.y, colour.getRGB());
                GLInterface.begin();
            }

            @Override
            public int getFontWidth(String string) {
                return MinecraftTrait.textRenderer.getWidth(string);
            }

            @Override
            public int getFontHeight() {
                return MinecraftTrait.textRenderer.fontHeight;
            }

            @Override
            protected String getResourcePrefix() {
                return "lumen/";
            }
        };

        this.hudEditorToggleable = new Toggleable() {
            @Override
            public void toggle() {
                render();
            }

            @Override
            public boolean isOn() {
                return hudEditor;
            }
        };

        this.hudClickGUI = new HUDClickGUI(guiInterface, new FixedDescription(new Point(2, 2))) {
            @Override
            public void handleScroll (int diff) {
                super.handleScroll(diff);

                for (FixedComponent component : components) {
                    if (!hudComponents.contains(component)) {
                        Point point = component.getPosition(guiInterface);
                        point.translate(0, -diff);
                        component.setPosition(guiInterface, point);
                    }
                }
            }
        };

        //this.theme = new LumenTheme
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
        return 0;
    }
}
