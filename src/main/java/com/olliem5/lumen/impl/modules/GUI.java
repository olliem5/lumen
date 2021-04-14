package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.impl.gui.LumenGUI;
import org.lwjgl.glfw.GLFW;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "GUI", description = "Opens Lumen's GUI", category = ModuleCategory.CLIENT, key = GLFW.GLFW_KEY_RIGHT_SHIFT)
public final class GUI extends Module {
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
