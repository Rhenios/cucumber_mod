package net.fabricmc.kappa_mod.feature;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class InwaterrepairProcedure {
    public static void executeProcedure(Map<String, Object> dependencies) {
        World world = (World) dependencies.get("world");
        Entity entity = (Entity) dependencies.get("entity");
        ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
        if (!world.isClient()) {
            if (entity.isInsideWaterOrBubbleColumn()) {
                {
                    ItemStack _ist = (itemstack);
                    if (_ist.damage(-1, new Random(), null)) {
                        _ist.decrement(1);
                        _ist.setDamage(0);
                    }
                }
                if (entity instanceof LivingEntity)
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 60, 1));
            }
        }
    }
}


