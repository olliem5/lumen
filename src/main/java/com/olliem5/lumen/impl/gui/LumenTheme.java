package com.olliem5.lumen.impl.gui;

import com.lukflug.panelstudio.Context;
import com.lukflug.panelstudio.theme.ColorScheme;
import com.lukflug.panelstudio.theme.Renderer;
import com.lukflug.panelstudio.theme.RendererBase;
import com.lukflug.panelstudio.theme.Theme;

import java.awt.*;

public final class LumenTheme implements Theme {
    private final ColorScheme colourScheme;
    private final Renderer componentRenderer;
    private final Renderer containerRenderer;
    private final Renderer panelRenderer;

    public LumenTheme(ColorScheme colourScheme, int height, int border, int scroll) {
        this.colourScheme = colourScheme;
        this.panelRenderer = new ComponentRenderer(0, height, border, scroll);
        this.containerRenderer = new ComponentRenderer(1, height, border, scroll);
        this.componentRenderer = new ComponentRenderer(2, height, border, scroll);
    }

    @Override
    public Renderer getPanelRenderer() {
        return panelRenderer;
    }

    @Override
    public Renderer getContainerRenderer() {
        return containerRenderer;
    }

    @Override
    public Renderer getComponentRenderer() {
        return componentRenderer;
    }


    private class ComponentRenderer extends RendererBase {
        private final int level;
        private final int border;

        public ComponentRenderer(int level, int height, int border, int scroll) {
            super(height + 2 * border, 0, 0, 0, scroll);
            this.level = level;
            this.border = border;
        }

        @Override
        public void renderRect(Context context, String text, boolean focus, boolean active, Rectangle rectangle, boolean overlay) {
            Color color=getMainColor(focus, active);
            context.getInterface().fillRect(rectangle, color, color, color, color);
            if (overlay) {
                Color overlayColor;
                if (context.isHovered()) {
                    overlayColor = new Color(255, 255, 255, 64);
                } else {
                    overlayColor = new Color(255, 255, 255, 0);
                }
                context.getInterface().fillRect(context.getRect(), overlayColor, overlayColor, overlayColor, overlayColor);
            }
            Point stringPos = new Point(rectangle.getLocation());
            stringPos.translate(0, border);
            context.getInterface().drawString(stringPos, text, getFontColor(focus));
        }

        @Override
        public void renderBackground(Context context, boolean focus) {
        }

        @Override
        public void renderBorder(Context context, boolean focus, boolean active, boolean open) {
            Color color=getDefaultColorScheme().getOutlineColor();
            if (level == 0) {
                context.getInterface().fillRect(new Rectangle(context.getPos(), new Dimension(context.getSize().width, 1)), color, color, color, color);
                context.getInterface().fillRect(new Rectangle(context.getPos(), new Dimension(1, context.getSize().height)), color, color, color, color);
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x + context.getSize().width -1, context.getPos().y), new Dimension(1, context.getSize().height)), color, color, color, color);
            }
            if (level == 0 || open) {
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x, context.getPos().y + context.getSize().height -1), new Dimension(context.getSize().width, 1)), color, color, color, color);
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x, context.getPos().y + getHeight(open) -1), new Dimension(context.getSize().width, 1)), color, color, color, color);
            }
        }

        @Override
        public int renderScrollBar(Context context, boolean focus, boolean active, boolean scroll, int childHeight, int scrollPosition) {
            if (scroll) {
                int containerHeight = context.getSize().height - getHeight(true);
                int a = (int) (scrollPosition / (double) childHeight * containerHeight);
                int b = (int) ((scrollPosition + containerHeight) / (double) childHeight * containerHeight);
                Color background = getMainColor(focus, false);
                Color slider = getMainColor(focus, true);
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x + context.getSize().width - getRightBorder(true), context.getPos().y + getHeight(true)), new Dimension(getRightBorder(true), a)), background, background, background, background);
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x + context.getSize().width - getRightBorder(true), context.getPos().y + getHeight(true) + a), new Dimension(getRightBorder(true), b - a)), slider, slider, slider, slider);
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x + context.getSize().width - getRightBorder(true), context.getPos().y + getHeight(true) + b), new Dimension(getRightBorder(true), context.getSize().height - getHeight(true) - b)), background, background, background, background);
                Color color=getDefaultColorScheme().getOutlineColor();
                context.getInterface().fillRect(new Rectangle(new Point(context.getPos().x + context.getSize().width - getRightBorder(true) -1, context.getPos().y + getHeight(true)), new Dimension(1, context.getSize().height - getHeight(true))), color, color, color, color);
                if (context.isClicked() && context.getInterface().getMouse().x >= context.getPos().x + context.getSize().width - getRightBorder(true)) {
                    return (int) ((context.getInterface().getMouse().y - context.getPos().y - getHeight(true)) * childHeight / (double) containerHeight-containerHeight / 2.0);
                }
            }
            return scrollPosition;
        }

        @Override
        public Color getMainColor(boolean focus, boolean active) {
            Color color;
            if (active) color = getColorScheme().getActiveColor();
            else color = getColorScheme().getBackgroundColor();
            if (!active && level < 2) color = getColorScheme().getInactiveColor();
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), getColorScheme().getOpacity());
            return color;
        }

        @Override
        public Color getBackgroundColor (boolean focus) {
            return new Color(0, 0, 0, 0);
        }

        @Override
        public ColorScheme getDefaultColorScheme() {
            return LumenTheme.this.colourScheme;
        }
    }
}
