package com.olliem5.lumen.api.setting;

import com.lukflug.panelstudio.settings.EnumSetting;
import com.lukflug.panelstudio.settings.NumberSetting;
import com.lukflug.panelstudio.settings.Toggleable;
import com.olliem5.lumen.api.util.EnumUtil;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Setting<T> implements Toggleable, EnumSetting, NumberSetting {
    private final String name;
    private String description;
    private T value;
    private T min;
    private T max;

    public Setting(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Setting(String name, String description, T value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Setting(String name, T min, T value, T max) {
        this.name = name;
        this.min = min;
        this.value = value;
        this.max = max;
    }

    public Setting(String name, String description, T min, T value, T max) {
        this.name = name;
        this.description = description;
        this.min = min;
        this.value = value;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    @Override
    public void toggle() {
        if (this.getValue() instanceof Boolean) {
            boolean enabled = (Boolean) this.getValue();
            //this.setValue(!enabled);
        }
    }

    @Override
    public boolean isOn() {
        if (this.getValue() instanceof Boolean) {
            return (Boolean) this.getValue();
        }
        return false;
    }

    @Override
    public void increment() {
        if (this.getValue() instanceof Enum<?>) {
            EnumUtil.setEnumValue((Setting<Enum<?>>) this, EnumUtil.getNextEnumValue((Setting<Enum<?>>) this, false));
        }
    }

    @Override
    public String getValueName() {
        if (this.getValue() instanceof Enum<?>) {
            return this.getValue().toString();
        }
        return "";
    }

    @Override
    public double getNumber() {
        if (this.getValue() instanceof Integer || this.getValue() instanceof Double || this.getValue() instanceof Float) {
            if (this.getValue() instanceof Integer) {
                return (Integer) this.getValue();
            } else if (this.getValue() instanceof Double) {
                return (Double) this.getValue();
            } else {
                return (Float) this.getValue();
            }
        }
        return -1;
    }

    @Override
    public void setNumber(double value) {
        if (this.getValue() instanceof Integer || this.getValue() instanceof Double || this.getValue() instanceof Float) {
            if (this.getValue() instanceof Integer) {

            } else if (this.getValue() instanceof Double) {

            } else {

            }
        }
    }

    @Override
    public double getMaximumValue() {
        if (this.getValue() instanceof Integer || this.getValue() instanceof Double || this.getValue() instanceof Float) {
            if (this.getValue() instanceof Integer) {
                return (Integer) this.getMax();
            } else if (this.getValue() instanceof Double) {
                return (Double) this.getMax();
            } else {
                return (Float) this.getMax();
            }
        }
        return -1;
    }

    @Override
    public double getMinimumValue() {
        if (this.getValue() instanceof Integer || this.getValue() instanceof Double || this.getValue() instanceof Float) {
            if (this.getValue() instanceof Integer) {
                return (Integer) this.getMin();
            } else if (this.getValue() instanceof Double) {
                return (Double) this.getMin();
            } else {
                return (Float) this.getMin();
            }
        }
        return -1;
    }

    @Override
    public int getPrecision() {
        if (this.getValue() instanceof Integer || this.getValue() instanceof Double || this.getValue() instanceof Float) {
            if (this.getValue() instanceof Integer) {

            } else if (this.getValue() instanceof Double) {

            } else {

            }
        }
        return -1;
    }
}
