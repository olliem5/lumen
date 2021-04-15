package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.NumberSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class DoubleSetting extends Setting implements NumberSetting {
    private final double min;
    private double value;
    private final double max;

    public DoubleSetting(String name, Module parent, double min, double value, double max) {
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
        this.value = value;
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

    public double getMin() {
        return min;
    }

    public double getValue() {
        return value;
    }

    public double getMax() {
        return max;
    }
}
