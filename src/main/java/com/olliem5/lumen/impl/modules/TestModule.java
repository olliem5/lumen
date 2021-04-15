package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.api.setting.settings.*;
import org.lwjgl.glfw.GLFW;

import java.util.Arrays;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "TestModule", description = "Module for testing", category = ModuleCategory.CLIENT, key = GLFW.GLFW_KEY_H)
public final class TestModule extends Module {
    private final BooleanSetting booleanSetting = registerBoolean("Boolean", true);
    private final ModeSetting modeSetting = registerMode("Mode", "Mode1", Arrays.asList("Mode1", "Mode2"));
    private final IntegerSetting integerSetting = registerInteger("Integer", 0, 50, 100);
    private final DoubleSetting doubleSetting = registerDouble("Double", 0.0, 50.0, 100.0);
    private final FloatSetting floatSetting = registerFloat("Float", 0.0f, 50.0f, 100.0f);

    @Override
    public void onEnable() {
        if (isntNullSafe()) return;
        mc.player.sendChatMessage("Enabled module!");
    }

    @Override
    public void onDisable() {
        if (isntNullSafe()) return;
        mc.player.sendChatMessage("Disabled module!");
    }

    @Override
    public void onUpdate() {
        if (isntNullSafe()) return;
        //Gets kicked for spamming, but it works
        //mc.player.sendChatMessage("Yay! Update event working....");
    }

    private enum TestModes { //TODO: Strings for these
        MODEONE,
        MODETWO
    }
}
