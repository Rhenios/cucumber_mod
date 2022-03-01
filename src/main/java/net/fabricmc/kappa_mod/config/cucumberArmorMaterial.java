package net.fabricmc.kappa_mod.config;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class cucumberArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {15, 15, 15, 15};
    private static final int[] PROTECTION_VALUES = new int[] {2, 4, 6, 2};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return 1024;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "cucumber_defensive_armament";
    }

    @Override
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}
