package com.olliem5.lumen.api.module;

import com.lukflug.panelstudio.settings.Toggleable;
import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.settings.*;
import com.olliem5.lumen.api.traits.MinecraftTrait;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class Module implements MinecraftTrait, Toggleable {
    private ModuleManifest getAnnotation() {
        if (getClass().isAnnotationPresent(ModuleManifest.class)) {
            return getClass().getAnnotation(ModuleManifest.class);
        }
        throw new IllegalStateException("Annotation 'ModuleManifest' not found!");
    }

    private final String name = getAnnotation().name();
//    private final String title = Arrays.stream(getAnnotation().name().split("-")).map(StringUtils::capitalize).collect(Collectors.joining(" "));
    private final String description = getAnnotation().description();
    private final ModuleCategory category = getAnnotation().category();
    private int key = getAnnotation().key();

    private final List<Setting> settings = new ArrayList<>();

    private boolean enabled = false;

    public void toggle() {
        enabled = !enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public BooleanSetting registerBoolean(String name, boolean value) {
        BooleanSetting booleanSetting = new BooleanSetting(name, this, value);
        settings.add(booleanSetting);
        return booleanSetting;
    }

    public ModeSetting registerMode(String name, String value, String... modes) {
        ModeSetting modeSetting = new ModeSetting(name, this, value, modes);
        settings.add(modeSetting);
        return modeSetting;
    }

    public ColourSetting registerColour(String name, Color value) {
        ColourSetting colourSetting = new ColourSetting(name, this, value, false);
        settings.add(colourSetting);
        return colourSetting;
    }

    public IntegerSetting registerInteger(String name, int min, int value, int max) {
        IntegerSetting integerSetting = new IntegerSetting(name, this, min, value, max);
        settings.add(integerSetting);
        return integerSetting;
    }

    public DoubleSetting registerDouble(String name, double min, double value, double max) {
        DoubleSetting doubleSetting = new DoubleSetting(name, this, min, value, max);
        settings.add(doubleSetting);
        return doubleSetting;
    }

    public FloatSetting registerFloat(String name, float min, float value, float max) {
        FloatSetting floatSetting = new FloatSetting(name, this, min, value, max);
        settings.add(floatSetting);
        return floatSetting;
    }

    public boolean isntNullSafe() {
        return mc.player == null || mc.world == null;
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void addSettings(Setting... settings) {
        this.settings.addAll(Arrays.asList(settings));
    }

    public void onUpdate() {}

    public void onRender() {}

    public boolean isOn() {
        return this.enabled;
    }
}
