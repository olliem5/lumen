package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.custom.BlockRender;
import com.olliem5.lumen.api.setting.custom.Keybind;
import com.olliem5.lumen.api.setting.custom.Switch;
import com.olliem5.lumen.api.util.BlockRenderer;

import java.awt.*;

import static org.lwjgl.glfw.GLFW.*;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "test-module", description = "Module for testing", category = ModuleCategory.CLIENT, key = GLFW_KEY_H)
public final class TestModule extends Module {
    public static final Setting<Boolean> booleanSetting = new Setting<>("Boolean Setting", "This is a boolean setting", true);
    public static final Setting<String> stringSetting = new Setting<>("String Setting", "This is a string setting", "StringValue");
    public static final Setting<TestModes> modeSetting = new Setting<>("Mode Setting", "This is a mode setting", TestModes.MODEONE);
    public static final Setting<Color> colourSetting = new Setting<>("Colour Setting", "This is a colour setting", new Color(100, 100, 100, 100));
    public static final Setting<Integer> integerSetting = new Setting<>("Integer Setting", "This is an integer setting", 0, 1, 2, 1);
    public static final Setting<Double> doubleSetting = new Setting<>("Double Setting", "This is a double setting", 0.0, 1.0, 2.0, 1);
    public static final Setting<Float> floatSetting = new Setting<>("Float Setting", "This is a float setting", 0.0f, 1.0f, 2.0f, 1);
    public static final Setting<BlockRender> blockRenderSetting = new Setting<>("Block Render Setting", "This is a block render setting", new BlockRender(BlockRenderer.Types.Full, 2.50f, new Color(255, 255, 255, 255), new Color(100, 100, 100, 100)));
    public static final Setting<Keybind> keybindSetting = new Setting<>("Keybind Setting", "This is a keybind setting", new Keybind(GLFW_KEY_A));
    public static final Setting<Switch> switchSetting = new Setting<>("Switch Setting", "This is a switch setting", new Switch(Switch.Types.Standard, 10.0));

    public TestModule() {
        this.addSettings(
                booleanSetting,
                stringSetting,
                modeSetting,
                colourSetting,
                integerSetting,
                doubleSetting,
                floatSetting
        );
    }

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

    private enum TestModes {
        MODEONE,
        MODETWO
    }
}
