package com.olliem5.lumen.api.traits;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

/**
 * @author olliem5
 * @since 1.0
 */

public interface MinecraftTrait {
    MinecraftClient mc = MinecraftClient.getInstance();
    TextRenderer textRenderer = mc.textRenderer;
}
