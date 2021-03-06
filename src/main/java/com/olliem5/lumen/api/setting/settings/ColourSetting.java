package com.olliem5.lumen.api.setting.settings;

import com.lukflug.panelstudio.settings.ColorSetting;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.setting.Setting;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ColourSetting extends Setting implements ColorSetting {
    private Color value;
    private boolean rainbow;

    public ColourSetting(String name, Module parent, Color value, boolean rainbow) {
        super(name, parent);
        this.value = value;
        this.rainbow = rainbow;
    }

    @Override
    public Color getValue() {
        return value;
    }

    @Override
    public void setValue(Color value) {
        this.value = value;
    }

    @Override
    public Color getColor() {
        return value;
    }

    @Override
    public boolean getRainbow() {
        return rainbow;
    }

    @Override
    public void setRainbow(boolean rainbow) {
        this.rainbow = rainbow;
    }
}
