package com.olliem5.lumen.impl.gui;

import com.olliem5.lumen.impl.gui.navbar.Navbar;
import com.olliem5.lumen.impl.gui.window.Window;
import com.olliem5.lumen.impl.gui.window.WindowManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

import java.util.List;

/**
 * @author olliem5
 * @since 1.0
 */

public final class MainScreen extends Screen {
    private final Navbar navbar;
    private final List<Window> windows;

    public MainScreen() {
        super(new LiteralText("Lumen GUI"));
        navbar = new Navbar();
        windows = WindowManager.getWindows();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        navbar.render(matrices, mouseX, mouseY, delta);

        windows.forEach(window -> {
            if (window.isVisible()) {
                window.render(matrices, mouseX, mouseY, delta);
            }
        });
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        navbar.mouseClicked(mouseX, mouseY, button);

        windows.forEach(window -> {
            if (window.isVisible()) {
                window.mouseClicked(mouseX, mouseY, button);
            }
        });

        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        navbar.mouseClicked(mouseX, mouseY, button);

        windows.forEach(window -> {
            if (window.isVisible()) {
                window.mouseReleased(mouseX, mouseY, button);
            }
        });

        return false;
    }
}
