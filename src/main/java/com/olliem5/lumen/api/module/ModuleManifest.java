package com.olliem5.lumen.api.module;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author olliem5
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleManifest {
    String name();
    String description() default "No description provided!";
    ModuleCategory category();
}
