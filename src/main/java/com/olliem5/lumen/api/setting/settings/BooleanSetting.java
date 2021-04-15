package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.Toggleable;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class BooleanSetting extends Setting implements Toggleable {
    private boolean value;

    public BooleanSetting(String name, Module parent, boolean value) {
        super(name, parent);
        this.value = value;
    }

    @Override
    public void toggle() {
        this.value = !this.value;
    }

    @Override
    public boolean isOn() {
        return this.value;
    }
}
