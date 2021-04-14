package com.olliem5.lumen.api.setting.custom;

import com.lukflug.panelstudio.settings.KeybindSetting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Keybind implements KeybindSetting {
    private int key;

    public Keybind(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getKeyName() {
        return String.valueOf(key);
    }
}
