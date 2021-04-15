package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.api.setting.settings.ColourSetting;
import com.olliem5.lumen.api.setting.settings.IntegerSetting;
import com.olliem5.lumen.api.setting.settings.ModeSetting;
import com.olliem5.lumen.impl.gui.LumenGUI;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.Arrays;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "GUI", description = "Opens Lumen's GUI", category = ModuleCategory.CLIENT, key = GLFW.GLFW_KEY_RIGHT_SHIFT)
public final class GUI extends Module {
    public final ModeSetting scrolling = registerMode("Scrolling", "Screen", Arrays.asList("Screen", "Container"));
    public final IntegerSetting scrollSpeed = registerInteger("Scroll Speed", 1, 10, 20);
    public final IntegerSetting animationSpeed = registerInteger("Animation Speed", 0, 200, 1000);
    public final IntegerSetting opacity = registerInteger("Opacity", 50, 150, 255);

    public final ColourSetting colourSetting1 = registerColour("Colour 1", Color.black);
    public final ColourSetting colourSetting2 = registerColour("Colour 2", Color.red);
    public final ColourSetting colourSetting3 = registerColour("Colour 3", Color.blue);
    public final ColourSetting colourSetting4 = registerColour("Colour 4", Color.green);
    public final ColourSetting colourSetting5 = registerColour("Colour 5", Color.green);

    @Override
    public void onEnable() {
        if (isntNullSafe()) return;
        LumenGUI lumenGUI = new LumenGUI();
        lumenGUI.enterGUI();
        mc.player.sendChatMessage("Enabled module!");
        this.toggle();
    }

    @Override
    public void onDisable() {
        if (isntNullSafe()) return;
        mc.player.sendChatMessage("Disabled module!");
    }
}
