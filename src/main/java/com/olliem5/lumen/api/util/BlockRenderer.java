package com.olliem5.lumen.api.util;

import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.custom.BlockRender;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

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

    private void draw(Setting<BlockRender> setting, BlockPos blockPos, Color colour) {
        GLHelper.prepareGL();
        GL11.glLineWidth(setting.getValue().getLineWidth());

        if (setting.getValue().getType() == Types.Box) {
            drawBox(blockPos, colour);
        }

        if (setting.getValue().getType() == Types.Outline) {
            drawOutline(blockPos, colour);
        }

        if (setting.getValue().getType() == Types.Full) {
            drawFull(blockPos, colour);
        }

        if (setting.getValue().getType() == Types.Claw) {
            drawClaw(blockPos, colour);
        }

        if (setting.getValue().getType() == Types.Glow) {
            drawGlow(blockPos, colour);
        }

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
