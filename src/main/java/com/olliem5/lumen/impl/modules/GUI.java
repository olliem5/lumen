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
    public final ModeSetting scroll = registerMode("Scroll", "Container", Arrays.asList("Screen", "Container"));
    public final IntegerSetting scrollSpeed = registerInteger("Scroll Speed", 1, 10, 20);
    public final IntegerSetting animationSpeed = registerInteger("Animation Speed", 0, 250, 1000);
    public final IntegerSetting opacity = registerInteger("Opacity", 50, 150, 255);

    public final ColourSetting outlineColour = registerColour("Outline", new Color(200, 20, 20, 250));
    public final ColourSetting enabledColour = registerColour("Enabled", new Color(120, 10, 10, 210));
    public final ColourSetting backgroundColour = registerColour("Background", new Color(20, 20, 20, 220));
    public final ColourSetting settingColour = registerColour("Setting", new Color(140, 15, 15, 200));
    public final ColourSetting fontColour = registerColour("Font", new Color(255, 255, 255, 255));

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
