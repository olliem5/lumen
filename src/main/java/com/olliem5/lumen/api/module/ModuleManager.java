package com.olliem5.lumen.api.module;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModuleManager {
    public static final ArrayList<Module> modules = new ArrayList<>();

    public static void initialize() {
        modules.addAll(Arrays.asList(
                //Add modules here
        ));

        modules.sort(ModuleManager::alphabetize);
    }

    private static int alphabetize(Module module1, Module module2) {
        return module1.getName().compareTo(module2.getName());
    }

    public static ArrayList<Module> getModules() {
        return modules;
    }

    //TODO: Class lookup
}
