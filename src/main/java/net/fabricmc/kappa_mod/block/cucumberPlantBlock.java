package net.fabricmc.kappa_mod.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.kappa_mod.feature.growthsugercaneblock;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import java.util.*;

public class cucumberPlantBlock extends SugarCaneBlock {
    public cucumberPlantBlock() {
        super(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.CROP).strength(0F, 0F).luminance(0).noCollision()
                .nonOpaque().breakInstantly().ticksRandomly());

        FlammableBlockRegistry.getDefaultInstance().add(this, 20, 60);
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return Block.OffsetType.NONE;
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(Blockinit.cucumberblockitem);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(Blockinit.cucumberblockitem, 1));
    }

    @Override
    public boolean canPlaceAt(BlockState blockstate, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState groundState = worldIn.getBlockState(blockpos);
        Block ground = groundState.getBlock();
        return ground == this || (Blocks.GRASS.canPlaceAt(blockstate,worldIn,pos));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        growthsugercaneblock.executeProcedure(x,y,z,world);
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        } else if (world.isAir(pos.up())) {
            int i = 1;
            for (; world.getBlockState(pos.down(i)).getBlock() == this; ++i);
            if (i < 5) {
                int j = state.get(AGE);
                if (j == 15) {
                    world.setBlockState(pos.up(), this.getDefaultState());
                    world.setBlockState(pos, state.with(AGE, 0), 4);
                } else {
                    world.setBlockState(pos, state.with(AGE, j + 1), 4);
                }
            }
        }
    }


}
