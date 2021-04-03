package com.olliem5.lumen.impl.modules;

import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleCategory;
import com.olliem5.lumen.api.module.ModuleManifest;

/**
 * @author olliem5
 * @since 1.0
 */

@ModuleManifest(name = "TestModule", description = "Module for testing", category = ModuleCategory.CLIENT)
public final class TestModule extends Module {
    public TestModule() {
        this.setEnabled(true);
    }

    @Override
    public void onUpdate() {
        if (mc.player == null) return;
        mc.player.sendChatMessage("Yay! Update event working....");
    }
}
