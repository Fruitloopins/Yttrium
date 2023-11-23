package com.fwloopins.yttrium.client.mixin.spectatorcrosshair;

import com.fwloopins.yttrium.client.YttriumClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "shouldRenderSpectatorCrosshair", at = @At("RETURN"), cancellable = true)
    private void renderSpectatorCrosshair(HitResult hitResult, CallbackInfoReturnable<Boolean> cir) {
        if (YttriumClient.getConfig().tweaks.spectatorCrosshair) {
            cir.setReturnValue(true);
        }
    }
}
