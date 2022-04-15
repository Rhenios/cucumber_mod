package net.fabricmc.kappa_mod.config;

import net.fabricmc.kappa_mod.feature.InwaterrepairProcedure;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

import static net.fabricmc.kappa_mod.main.ITEM_GROUP;

public class pickaxeBase extends PickaxeItem {

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        {
            Map<String, Object> $_dependencies = new HashMap<>();
            $_dependencies.put("world", world);
            $_dependencies.put("entity", entity);
            $_dependencies.put("itemstack", stack);
            InwaterrepairProcedure.executeProcedure($_dependencies);
        }
    }
    public pickaxeBase(ToolMaterial material) {
        super(material, -1, -2.5F, new Item.Settings().group(ITEM_GROUP).maxCount(1));
    }
}
