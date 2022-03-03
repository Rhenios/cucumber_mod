package net.fabricmc.kappa_mod.config;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class hardcucumbertool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 4096;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0F;
    }

    @Override
    public float getAttackDamage() {
        return 4.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
