package com.olliem5.lumen.api.util;

import java.awt.*;

import static com.mojang.blaze3d.platform.GlStateManager.blendFunc;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ShapeRenderer {
    public static void drawSolidRectangle(float x, float y, float width, float height, Color color) {
        glEnable(GL_BLEND);
        blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glBegin(GL_QUADS);
        glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        glVertex2f(x, y);
        glVertex2f(x, y + height);
        glVertex2f(x + width, y + height);
        glVertex2f(x + width, y);
        glColor4f(1, 1, 1, 1);
        glEnd();
    }
}
