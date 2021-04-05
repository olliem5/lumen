package com.olliem5.lumen.impl.gui.navbar;

import com.mojang.blaze3d.platform.GlStateManager;
import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.api.traits.MinecraftTrait;
import com.olliem5.lumen.impl.gui.navbar.elements.ModulesElement;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Navbar implements MinecraftTrait {
    private final ArrayList<NavbarElement> navbarElements = new ArrayList<>();

    public Navbar(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        navbarElements.add(new ModulesElement());
        render(matrices, mouseX, mouseY, delta);
    }

    private int xOffset;

    @SuppressWarnings("deprecation")
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int height = mc.getWindow().getHeight() / 20;

        DrawableHelper.fill(matrices, 0, 0, mc.getWindow().getWidth(), height, new Color(70, 70, 70, 150).getRGB());

        GlStateManager.pushMatrix();
        GlStateManager.scalef(2.0f, 2.0f, 1.0f);
        textRenderer.drawWithShadow(matrices, Lumen.NAME, textRenderer.getWidth(Lumen.NAME_VERSION) / 2, (height / 4) - (textRenderer.fontHeight / 2), -1);
        GlStateManager.popMatrix();

        xOffset = 0;

        navbarElements.forEach(navbarElement -> {
            navbarElement.render(matrices, mouseX, mouseY, delta, 2, 2, height -2);
            xOffset++;
        });
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {

    }
}
