package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;
import com.olliem5.lumen.api.setting.settings.ModeSetting;

import java.util.Arrays;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "Colours", description = "Controls client colours", category = ModuleCategory.CLIENT)
public final class Colours extends Module {
    public final ModeSetting colourModel = registerMode("Colour Model", "RGB", Arrays.asList("RGB", "HSB"));
}
