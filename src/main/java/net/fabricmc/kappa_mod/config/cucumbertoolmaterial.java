package net.fabricmc.kappa_mod.config;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;


public class cucumbertoolmaterial implements ToolMaterial {

    public static final cucumbertoolmaterial INSTANCE = new cucumbertoolmaterial();



    @Override
    public int getDurability() {
        return 1024;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
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

