package com.olliem5.lumen.api.module;

import com.olliem5.lumen.api.traits.MinecraftTrait;
import org.jetbrains.annotations.Nullable;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class Module implements MinecraftTrait {
    private final String name;
    private final String description;
    private final ModuleCategory moduleCategory;
    private int key;

    private boolean enabled = false;

    protected Module(String name, @Nullable String description, ModuleCategory moduleCategory, int key) {
        this.name = name;
        this.description = description;
        this.moduleCategory = moduleCategory;
        this.key = key;
    }

    public void toggle() {
        enabled = !enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        //register from event bus
    }

    public void onDisable() {
        //unregister from event bus
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ModuleCategory getModuleCategory() {
        return moduleCategory;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
