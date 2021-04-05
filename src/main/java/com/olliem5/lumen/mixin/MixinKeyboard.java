package com.olliem5.lumen.mixin;

import com.olliem5.lumen.Lumen;
import com.olliem5.lumen.impl.events.KeyPressEvent;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_UNKNOWN;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * @author olliem5
 * @since 1.0
 */

@Mixin(value = Keyboard.class)
public final class MixinKeyboard {
    @Inject(method = "onKey", at = @At(value = "HEAD"))
    private void onKey(long window, int key, int scancode, int i, int j, CallbackInfo callbackInfo) {
        if (key != GLFW_KEY_UNKNOWN) {
            //if (minecraftClient.currentScreen instanceof ClickGUI)
            if (i != GLFW_RELEASE) {
                KeyPressEvent keyPressEvent = new KeyPressEvent(key);

                if (!keyPressEvent.isCancelled()) {
                    Lumen.EVENT_HANDLER.dispatchPaceEvent(keyPressEvent);
                }
            }
        }
    }
}
