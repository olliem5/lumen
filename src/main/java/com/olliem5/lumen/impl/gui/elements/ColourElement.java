package com.olliem5.lumen.impl.gui.elements;

import com.lukflug.panelstudio.Animation;
import com.lukflug.panelstudio.settings.ColorComponent;
import com.lukflug.panelstudio.settings.Toggleable;
import com.lukflug.panelstudio.theme.Theme;
import com.olliem5.lumen.api.setting.settings.ColourSetting;
import net.minecraft.util.Formatting;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ColourElement extends ColorComponent {
    public ColourElement(Theme theme, ColourSetting colourSetting, Toggleable colourToggle, Animation animation) {
        super(Formatting.BOLD + colourSetting.getName(), "", theme.getContainerRenderer(), animation, theme.getComponentRenderer(), colourSetting, true, true, colourToggle);
    }
}
