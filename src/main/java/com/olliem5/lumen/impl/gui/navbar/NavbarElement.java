package com.olliem5.lumen.impl.gui.navbar;

import com.olliem5.lumen.api.traits.MinecraftTrait;
import com.olliem5.lumen.impl.gui.window.Window;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class NavbarElement extends DrawableHelper implements MinecraftTrait {
    private final String name;
    private final Identifier identifier;
    private final Window window;

    public NavbarElement(String name, Identifier identifier, Window window) {
        this.name = name;
        this.identifier = identifier;
        this.window = window;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, int x, int y, int size) {
        fill(matrices, x, y, size, size, new Color(70, 70, 70, 180).getRGB());
        mc.getTextureManager().bindTexture(identifier);
        drawTexture(matrices, x, y, 0, 0, size, size);
    }

    public String getName() {
        return name;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Window getWindow() {
        return window;
    }
}
