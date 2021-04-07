package com.olliem5.lumen.impl.gui.window;

import com.olliem5.lumen.api.traits.MinecraftTrait;
import net.minecraft.client.util.math.MatrixStack;

/**
 * @author olliem5
 * @since 1.0
 */

public abstract class Window implements MinecraftTrait {
    private final String title;
    private boolean visible;
    private int width;
    private int height;
    private int x;
    private int y;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        //TODO: Make these in the middle
        this.x = 100;
        this.y = 100;
    }

    public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);
    public abstract void mouseClicked(double mouseX, double mouseY, int button);
    public abstract void mouseReleased(double mouseX, double mouseY, int button);

    public String getTitle() {
        return title;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
