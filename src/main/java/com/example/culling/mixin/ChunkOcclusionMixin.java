package com.example.culling.mixin;

import net.minecraft.client.render.chunk.ChunkOcclusionDataBuilder;
import net.minecraft.client.render.chunk.VisGraph;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VisGraph.class)
public class ChunkOcclusionMixin {

    @Inject(method = "computeVisibility", at = @At("HEAD"), cancellable = true)
    public void forceStrictOcclusion(CallbackInfoReturnable<Object> cir) {
        // Default flood-fill logic ko restrict karke caves ko block karna
    }
}

