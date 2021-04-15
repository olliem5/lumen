package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.NumberSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class IntegerSetting extends Setting implements NumberSetting {
    private final int min;
    private int value;
    private final int max;

    public IntegerSetting(String name, Module parent, int min, int value, int max) {
        super(name, parent);
        this.min = min;
        this.value = value;
        this.max = max;
    }

    @Override
    public double getNumber() {
        return this.value;
    }

    @Override
    public void setNumber(double value) {
        this.value = (int) Math.round(value);
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
        return 0;
    }

    public int getMin() {
        return min;
    }

    public int getValue() {
        return value;
    }

    public int getMax() {
        return max;
    }
}
