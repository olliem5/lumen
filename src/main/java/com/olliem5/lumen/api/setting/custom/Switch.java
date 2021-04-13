package com.olliem5.lumen.api.setting.custom;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Switch {
    private Types type;
    private double switchDelay;

    public Switch(Types type, double switchDelay) {
        this.type = type;
        this.switchDelay = switchDelay;
    }

    public Types getType() {
        return type;
    }

    public double getSwitchDelay() {
        return switchDelay;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void setSwitchDelay(double switchDelay) {
        this.switchDelay = switchDelay;
    }

    public enum Types {
        None,
        Standard,
        Packet,
        Ghost
    }
}
