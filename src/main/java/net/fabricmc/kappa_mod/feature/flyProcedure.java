package net.fabricmc.kappa_mod.feature;

import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;

public class flyProcedure {
    public static void executeProcedure(PlayerEntity user){
        if (!user.getAbilities().allowFlying){
            user.getAbilities().allowFlying = true;
            user.sendAbilitiesUpdate();
        }else{
            user.getAbilities().allowFlying = false;
            user.getAbilities().flying = false;
            user.sendAbilitiesUpdate();
        }
    }
}
