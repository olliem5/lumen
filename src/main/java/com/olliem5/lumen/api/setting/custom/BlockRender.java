package com.olliem5.lumen.api.setting.custom;

import com.olliem5.lumen.api.util.BlockRenderer;

import java.awt.*;

/**
 * @author olliem5
 */

public final class BlockRender {
    private BlockRenderer.Types type;
    private float lineWidth;
    private Color boxColour;
    private Color outlineColour;

    public BlockRender(BlockRenderer.Types type, float lineWidth, Color boxColour, Color outlineColour) {
        this.type = type;
        this.lineWidth = lineWidth;
        this.boxColour = boxColour;
        this.outlineColour = outlineColour;
    }

    public BlockRenderer.Types getType() {
        return type;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public Color getBoxColour() {
        return boxColour;
    }

    public Color getOutlineColour() {
        return outlineColour;
    }

    public void setType(BlockRenderer.Types type) {
        this.type = type;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setBoxColour(Color boxColour) {
        this.boxColour = boxColour;
    }

    public void setOutlineColour(Color outlineColour) {
        this.outlineColour = outlineColour;
    }
}
