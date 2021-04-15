package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.EnumSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

import java.util.List;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModeSetting extends Setting implements EnumSetting {
    private String value;
    private final List<String> modes;

    public ModeSetting(String name, Module parent, String value, List<String> modes) {
        super(name, parent);
        this.value = value;
        this.modes = modes;
    }

    @Override
    public void increment() {
        int modeIndex = modes.indexOf(value);
        modeIndex = (modeIndex + 1) % modes.size();
        value = modes.get(modeIndex);
    }

    @Override
    public String getValueName() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
