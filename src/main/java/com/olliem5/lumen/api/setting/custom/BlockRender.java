package com.olliem5.lumen.api.setting.custom;

import com.olliem5.lumen.api.util.BlockRenderer;

import java.awt.*;

/**
 * @author olliem5
 * @since 1.0
 */

public final class BlockRender {
    private BlockRenderer.Types type;
    private float lineWidth;
    private Color colour;

    public BlockRender(BlockRenderer.Types type, float lineWidth, Color colour) {
        this.type = type;
        this.lineWidth = lineWidth;
        this.colour = colour;
    }

    public BlockRenderer.Types getType() {
        return type;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public Color getColour() {
        return colour;
    }

    public void setType(BlockRenderer.Types type) {
        this.type = type;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }
}
