package com.olliem5.lumen.mixin;

import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.impl.events.UpdateEvent;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author olliem5
 * @since 1.0
 */

@Mixin(value = ClientWorld.class)
public final class MixinClientWorld {
    @Inject(method = "tickEntities", at = @At(value = "HEAD"), cancellable = true)
    public void tickEntities(CallbackInfo callbackInfo) {
        UpdateEvent updateEvent = new UpdateEvent();
        Lumen.EVENT_HANDLER.dispatchPaceEvent(updateEvent);
        System.out.println("Tick event");
    }
}
