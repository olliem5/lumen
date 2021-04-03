package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_H;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "TestModule", description = "Module for testing", category = ModuleCategory.CLIENT, key = GLFW_KEY_H)
public final class TestModule extends Module {
    @Override
    public void onEnable() {
        if (mc.player == null || mc.world == null) return;
        mc.player.sendChatMessage("Toggled module!");
    }

    @Override
    public void onUpdate() {
        if (mc.player == null || mc.world == null) return;
        //Gets kicked for spamming, but it works
        //mc.player.sendChatMessage("Yay! Update event working....");
    }
}
