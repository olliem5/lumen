package com.olliem5.lumen.api.module;

import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.api.traits.MinecraftTrait;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class Module implements MinecraftTrait {
    private ModuleManifest getAnnotation() {
        if (getClass().isAnnotationPresent(ModuleManifest.class)) {
            return getClass().getAnnotation(ModuleManifest.class);
        }
        throw new IllegalStateException("Annotation 'ModuleManifest' not found!");
    }

    private final String name = getAnnotation().name();
    private final String description = getAnnotation().description();
    private final ModuleCategory category = getAnnotation().category();

    private boolean enabled = false;

    public void toggle() {
        enabled = !enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        Lumen.EVENT_HANDLER.register(this);
    }

    public void onDisable() {
        Lumen.EVENT_HANDLER.unregister(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void onUpdate() {}

    public void onRender() {}
}
