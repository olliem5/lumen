package com.olliem5.lumen.mixin;

import com.olliem5.lumen.Lumen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author olliem5
 * @since 1.0
 */

@Mixin(value = TitleScreen.class)
public final class MixinTitleScreen {
	@Inject(at = @At(value = "HEAD"), method = "init()V")
	private void init(CallbackInfo callbackInfo) {
		Lumen.log("Mixin moment");
	}
}
