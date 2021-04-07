package com.olliem5.lumen.mixin;

import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.impl.events.WorldRenderEvent;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author olliem5
 * @since 1.0
 */

@Mixin(value = WorldRenderer.class)
public final class MixinWorldRenderer {
    @Inject(method = "render", at = @At(value = "RETURN"))
    private void render(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f matrix4f, CallbackInfo callbackInfo) {
        WorldRenderEvent worldRenderEvent = new WorldRenderEvent();
        Lumen.EVENT_HANDLER.dispatchPaceEvent(worldRenderEvent);
    }
}
