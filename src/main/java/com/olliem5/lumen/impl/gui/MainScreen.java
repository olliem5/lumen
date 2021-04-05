package com.olliem5.lumen.impl.gui;

import com.olliem5.lumen.api.util.ShapeRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class MainScreen extends Screen {
    public MainScreen() {
        super(new LiteralText("Lumen GUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        ShapeRenderer.drawSolidRectangle(2, 2, 100, 100, new Color(100, 25, 25, 100));
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        return false;
    }
}
