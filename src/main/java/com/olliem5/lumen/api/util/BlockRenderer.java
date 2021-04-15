package com.olliem5.lumen.api.util;

import net.minecraft.util.math.BlockPos;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class BlockRenderer {
    private void drawBox(BlockPos blockPos, Color colour) {

    }

    private void drawOutline(BlockPos blockPos, Color colour) {

    }

    private void drawFull(BlockPos blockPos, Color colour) {
        drawBox(blockPos, colour);
        drawOutline(blockPos, colour);
    }

    private void drawClaw(BlockPos blockPos, Color colour) {

    }

    private void drawGlow(BlockPos blockPos, Color colour) {

    }

    private void draw(BlockPos blockPos, Color colour) {
        GLHelper.prepareGL();

        GLHelper.releaseGL();
    }

    public enum Types {
        Box,
        Outline,
        Full,
        Claw,
        Glow
    }
}
