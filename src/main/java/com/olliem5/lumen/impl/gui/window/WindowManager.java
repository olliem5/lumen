package com.olliem5.lumen.impl.gui.window;

import com.olliem5.lumen.impl.gui.window.windows.ConsoleWindow;
import com.olliem5.lumen.impl.gui.window.windows.HUDWindow;
import com.olliem5.lumen.impl.gui.window.windows.ModuleWindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author olliem5
 * @since 1.0
 */

public final class WindowManager {
    private static final ArrayList<Window> windows = new ArrayList<>();

    public static void initialize() {
        windows.addAll(Arrays.asList(
           new ModuleWindow(),
           new HUDWindow(),
           new ConsoleWindow()
        ));
    }

    public static ArrayList<Window> getWindows() {
        return windows;
    }
}
