package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.EnumSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

import java.util.Arrays;
import java.util.List;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModeSetting extends Setting implements EnumSetting {
    private String value;
    private final String[] modes;

    public ModeSetting(String name, Module parent, String value, String... modes) {
        super(name, parent);
        this.value = value;
        this.modes = modes;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void increment() {
        List<String> stringList = Arrays.asList(modes);
        int modeIndex = stringList.indexOf(value);
        modeIndex = (modeIndex + 1) % stringList.size();
        value = stringList.get(modeIndex);
    }

    @Override
    public String getValueName() {
        return value;
    }
}
