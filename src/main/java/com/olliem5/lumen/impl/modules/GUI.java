package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.impl.gui.MainScreen;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "GUI", description = "Opens Lumen's GUI", category = ModuleCategory.CLIENT, key = GLFW_KEY_RIGHT_SHIFT)
public final class GUI extends Module {
    @Override
    public void onEnable() {
        if (isntNullSafe()) return;
        mc.openScreen(new MainScreen());
        mc.player.sendChatMessage("Opened GUI!");
    }

    @Override
    public void onDisable() {
        if (isntNullSafe()) return;
        mc.player.sendChatMessage("Closed GUI!");
    }
}
