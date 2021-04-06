package com.olliem5.lumen.api.setting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Setting<T> {
    private final String name;
    private String description;
    private T value;
    private T min;
    private T max;
    private int roundingScale;

    public Setting(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Setting(String name, String description, T value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Setting(String name, T min, T value, T max, int roundingScale) {
        this.name = name;
        this.min = min;
        this.value = value;
        this.max = max;
        this.roundingScale = roundingScale;
    }

    public Setting(String name, String description, T min, T value, T max, int roundingScale) {
        this.name = name;
        this.description = description;
        this.min = min;
        this.value = value;
        this.max = max;
        this.roundingScale = roundingScale;
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

    public int getRoundingScale() {
        return roundingScale;
    }
}
