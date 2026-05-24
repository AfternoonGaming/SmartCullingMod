package com.example.culling.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void injectSmartCulling(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir) {
        // 1. If the neighboring block is fully opaque (solid), don't render this side
        BlockState neighborState = world.getBlockState(otherPos);
        if (neighborState.isOpaqueFullCube(world, otherPos)) {
            cir.setReturnValue(false); // Cancel rendering (Cull)
            return;
        }

        // 2. Strict Check: If block is surrounded by solid blocks in all 6 directions
        boolean isPacked = true;
        for (Direction dir : Direction.values()) {
            if (!world.getBlockState(pos.offset(dir)).isOpaqueFullCube(world, pos.offset(dir))) {
                isPacked = false;
                break;
            }
        }
        
        if (isPacked) {
            cir.setReturnValue(false); // If completely enclosed, cull the entire block
        }
    }
}
