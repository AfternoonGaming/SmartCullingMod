package com.example.culling.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockState.class)
public class BlockMixin {

    @Inject(method = "isOpaqueFullCube", at = @At("HEAD"), cancellable = true)
    private void smartCullingLogic(BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = (BlockState) (Object) this;
        
        // Check if block is replaceable or has no collision
        if (state.getMaterial().isReplaceable() || !state.getMaterial().isSolid()) {
            cir.setReturnValue(false);
            return;
        }

        // Check if completely surrounded by solid blocks (full occlusion)
        if (world != null && pos != null) {
            boolean isFullyEnclosed = true;
            for (Direction dir : Direction.values()) {
                BlockState neighbor = world.getBlockState(pos.offset(dir));
                if (!neighbor.isOpaqueFullCube(world, pos.offset(dir))) {
                    isFullyEnclosed = false;
                    break;
                }
            }
            
            if (isFullyEnclosed) {
                cir.setReturnValue(false); // Cull completely enclosed blocks
            }
        }
    }
}
