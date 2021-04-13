package com.olliem5.lumen.api.setting.custom;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Keybind {
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
}
