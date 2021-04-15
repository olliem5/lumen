package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.NumberSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

/**
 * @author olliem5
 */

public final class FloatSetting extends Setting implements NumberSetting {
    private final float min;
    private float value;
    private final float max;

    public FloatSetting(String name, Module parent, float min, float value, float max) {
        super(name, parent);
        this.min = min;
        this.value = value;
        this.max = max;
    }

    public float getValue() {
        return value;
    }
    
    @Override
    public double getNumber() {
        return this.value;
    }

    @Override
    public void setNumber(double value) {
        this.value = (float) value;
    }

    @Override
    public double getMaximumValue() {
        return this.max;
    }

    @Override
    public double getMinimumValue() {
        return this.min;
    }

    @Override
    public int getPrecision() {
        return 2;
    }
}
