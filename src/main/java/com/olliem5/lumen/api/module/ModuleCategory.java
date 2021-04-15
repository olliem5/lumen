package com.olliem5.lumen.api.module;

/**
 * @author olliem5
 * @since 1.0
 */

public enum ModuleCategory {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    EXPLOIT("Exploit"),
    MISCELLANEOUS("Miscellaneous"),
    LUMEN("Lumen");

    private final String name;

    ModuleCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
