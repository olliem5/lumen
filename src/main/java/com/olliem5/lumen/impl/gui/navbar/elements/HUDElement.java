package com.olliem5.lumen.impl.gui.navbar.elements;

import com.olliem5.lumen.impl.gui.navbar.NavbarElement;
import com.olliem5.lumen.impl.gui.window.windows.HUDWindow;
import net.minecraft.util.Identifier;

/**
 * @author olliem5
 * @since 1.0
 */

public final class HUDElement extends NavbarElement {
    public HUDElement() {
        super("HUD", new Identifier("lumen", "images/navbar/hud.png"), new HUDWindow());
    }
}
