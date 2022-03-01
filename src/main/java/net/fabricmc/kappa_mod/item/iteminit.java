package net.fabricmc.kappa_mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.kappa_mod.main;
import net.fabricmc.kappa_mod.config.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.fabricmc.kappa_mod.main.ITEM_GROUP;

public class iteminit {

    //item
    public static final Item cucumber = registerItem("cucumber", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item cucumber_fly_ring = registerItem("cucumber_fly_ring", new flyringItem(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item cucumberalloy = registerItem("cucumberalloy", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item cucumberalloyingot = registerItem("cucumberalloyingot", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item cucumberingot = registerItem("cucumberingot", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item cucumberraw = registerItem("cucumberraw", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item hardcucumberingot = registerItem("hardcucumberingot", new Item(new FabricItemSettings().group(ITEM_GROUP)));
    public static final Item hardcucumberraw = registerItem("hardcucumberraw", new Item(new FabricItemSettings().group(ITEM_GROUP)));



    //armor
    public static final ArmorMaterial hardcucumberArmorMaterial = new hardcucumberArmorMaterial();
    public static final Item hardcucumberarmor_helmet = registerItem("hardcucumberarmor_helmet", new armorbase(hardcucumberArmorMaterial,EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP)));
    public static final Item hardcucumberarmor_chestplate = registerItem("hardcucumberarmor_chestplate", new armorbase(hardcucumberArmorMaterial,EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP)));
    public static final Item hardcucumberarmor_leggings = registerItem("hardcucumberarmor_leggings", new armorbase(hardcucumberArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP)));
    public static final Item hardcucumberarmor_boots = registerItem("hardcucumberarmor_boots", new armorbase(hardcucumberArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP)));

    public static final ArmorMaterial excucumberArmorMaterial = new excucumberArmorMaterial();
    public static final Item excucumberarmor_helmet = registerItem("excucumberarmor_helmet", new armorbase(excucumberArmorMaterial,EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP)));
    public static final Item excucumberarmor_chestplate = registerItem("excucumberarmor_chestplate", new armorbase(excucumberArmorMaterial,EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP)));
    public static final Item excucumberarmor_leggings = registerItem("excucumberarmor_leggings", new armorbase(excucumberArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP)));
    public static final Item excucumberarmor_boots = registerItem("excucumberarmor_boots", new armorbase(excucumberArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP)));

    public static final ArmorMaterial hardcucumberMaterial = new hardcucumberArmorMaterial();
    public static final Item cucumberarmer_helmet = registerItem("cucumberarmer_helmet", new armorbase(hardcucumberMaterial,EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP)));
    public static final Item cucumberarmer_chestplate = registerItem("cucumberarmer_chestplate", new armorbase(hardcucumberMaterial,EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP)));
    public static final Item cucumberarmer_leggings = registerItem("cucumberarmer_leggings", new armorbase(hardcucumberMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP)));
    public static final Item cucumberarmer_boots = registerItem("cucumberarmer_boots", new armorbase(hardcucumberMaterial, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP)));

    //food
    public static final Item lard = registerItem("lard", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.0F).build()).group(ITEM_GROUP)));
    public static final Item mayo = registerItem("mayo", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.0F).build()).group(ITEM_GROUP)));
    public static final Item potatosalada = registerItem("potatosalada", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(16).saturationModifier(16.0F).build()).group(ITEM_GROUP)));

    //tool
    public static final Item hardcucumberpickaxe = registerItem("hardcucumberpickaxe", new pickaxeBase(new hardcucumbertool()));
    public static final Item hardcucumberaxe = registerItem("hardcucumberaxe", new axebase(new hardcucumbertool()));
    public static final Item hardcucumbershovel = registerItem("hardcucumbershovel", new shovelBase(new hardcucumbertool()));

    public static final Item cucumberpickaxe = registerItem("cucumberpickaxe", new pickaxeBase(new cucumbertoolmaterial()));
    public static final Item cucumberaxe = registerItem("cucumberaxe", new axebase(new cucumbertoolmaterial()));
    public static final Item cucumbershovel = registerItem("cucumbershovel", new shovelBase(new cucumbertoolmaterial()));

    private static Item registerItem(String name ,Item item ){
        return Registry.register(Registry.ITEM,new Identifier(main.MODID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registering Mod Items for " + main.MODID);

    }

}
