package net.fabricmc.kappa_mod.feature;

import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

import static net.fabricmc.kappa_mod.block.Blockinit.cucumberblock;

public class growthsugercaneblock {

    public static void executeProcedure(int x, int y, int z, ServerWorld world)   {

        if (!world.isClient()) {
            if (cucumberblock.getDefaultState() == (world.getBlockState(new BlockPos(x, y, z)))) {
                if (Blocks.AIR.getDefaultState()  == (world.getBlockState(new BlockPos(x, y, z)))) {
                    world.setBlockState(new BlockPos(x, y, z), cucumberblock.getDefaultState(), 3);
                }
            }
        }
    }


}
