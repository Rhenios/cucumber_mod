package net.fabricmc.kappa_mod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.Hand;

public class flyringItem extends Item{
    public flyringItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack item = user.getStackInHand(hand);
        if (!user.getAbilities().allowFlying){
            user.getAbilities().allowFlying = true;
            user.sendAbilitiesUpdate();
        }else{
            user.getAbilities().allowFlying = false;
            user.getAbilities().flying = false;
            user.sendAbilitiesUpdate();
        }
        return TypedActionResult.success(item);
    }

}
