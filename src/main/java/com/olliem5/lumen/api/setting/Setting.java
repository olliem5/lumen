package com.olliem5.lumen.api.setting;

import com.olliem5.lumen.api.module.Module;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class Setting {
    public String name;
    public Module parent;

    public Setting(String name, Module parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Module getParent() {
        return parent;
    }
}
