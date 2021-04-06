package com.olliem5.lumen.impl.gui.navbar;

import com.mojang.blaze3d.platform.GlStateManager;
import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.api.traits.MinecraftTrait;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Navbar implements MinecraftTrait {
    @SuppressWarnings("deprecation")
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int height = mc.getWindow().getHeight() / 20;

        DrawableHelper.fill(matrices, 0, 0, mc.getWindow().getWidth(), height, new Color(70, 70, 70, 150).getRGB());

        GlStateManager.pushMatrix();
        GlStateManager.scalef(2.0f, 2.0f, 1.0f);
        textRenderer.drawWithShadow(matrices, Lumen.NAME, textRenderer.getWidth(Lumen.NAME_VERSION) / 2, (height / 4) - (textRenderer.fontHeight / 2), -1);
        GlStateManager.popMatrix();

        int xOffset = 0;

        for (NavbarElement navbarElement : NavbarElementManager.getNavbarElements()) {
            navbarElement.render(matrices, mouseX, mouseY, delta, height * xOffset, 0, height);
            xOffset++;
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {

    }
}
