package net.fabricmc.kappa_mod.config;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class basic_toolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 16384;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
