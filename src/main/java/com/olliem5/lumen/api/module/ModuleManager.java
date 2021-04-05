package com.olliem5.lumen.api.module;

import com.olliem5.lumen.impl.events.KeyPressEvent;
import com.olliem5.lumen.impl.events.UpdateEvent;
import com.olliem5.lumen.impl.events.WorldRenderEvent;
import com.olliem5.lumen.impl.modules.GUI;
import com.olliem5.lumen.impl.modules.TestModule;
import com.olliem5.pace.annotation.PaceHandler;

import java.util.ArrayList;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModuleManager {
    private static final ArrayList<Module> modules = new ArrayList<>();

    public static void initialize() {
        //modules.addAll(Arrays.asList(...));
        modules.add(new TestModule());
        modules.add(new GUI());
        modules.sort(ModuleManager::alphabetize);
    }

    private static int alphabetize(Module module1, Module module2) {
        return module1.getName().compareTo(module2.getName());
    }

    public static ArrayList<Module> getModules() {
        return modules;
    }

    //TODO: Class lookup

    @PaceHandler
    public void onUpdate(UpdateEvent event) {
        modules.forEach(Module::onUpdate);
    }

    @PaceHandler
    public void onWorldRender(WorldRenderEvent event) {
        modules.forEach(Module::onRender);
    }

    @PaceHandler
    public void onKeyPress(KeyPressEvent event) {
        for (Module module : modules) {
            if (module.getKey() == event.getKey()) {
                module.toggle();
            }
        }
    }
}
