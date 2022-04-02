package net.fabricmc.kappa_mod.block;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.kappa_mod.main;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import static net.fabricmc.kappa_mod.main.ITEM_GROUP;

public class Blockinit {

    //block
    public static final Block cucumberore = registerOreBlockinOverworld("cucumberore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),ITEM_GROUP,8,15,64);
    public static final Block hardcucumberore = registerOreBlockinOverworld("hardcucumberore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),ITEM_GROUP,8,15,32);

    //customblock
    public static final Block cucumberblock = Registry.register(Registry.BLOCK,new Identifier(main.MODID, "cucumberblock"),new cucumberPlantBlock());
    public static final BlockItem cucumberblockitem = Registry.register(Registry.ITEM, new Identifier(main.MODID, "cucumberblock"),
            new BlockItem(cucumberblock, new Item.Settings().group(ITEM_GROUP)));

    //con_block
    public static final Block cucumber_lightblue_block = registerConBlock("cucumber_lightblue_block");
    public static final Block cucumber_lightblue_block_1 = registerConBlock("cucumber_lightblue_block_1");
    public static final Block cucumber_white_block = registerConBlock("cucumber_white_block");
    public static final Block cucumber_white_block_1 = registerConBlock("cucumber_white_block_1");
    public static final Block cucumber_green_block = registerConBlock("cucumber_green_block");
    public static final Block cucumber_green_block_1 = registerConBlock("cucumber_green_block_1");
    public static final Block cucumber_lightblue_slabblock = registerConSlabBlock("cucumber_lightblue_slabblock");
    public static final Block cucumber_lightblue_slabblock_1 = registerConSlabBlock("cucumber_lightblue_slabblock_1");
    public static final Block cucumber_white_slabblock = registerConSlabBlock("cucumber_white_slabblock");
    public static final Block cucumber_white_slabblock_1 = registerConSlabBlock("cucumber_white_slabblock_1");
    public static final Block cucumber_green_slabblock = registerConSlabBlock("cucumber_green_slabblock");
    public static final Block cucumber_green_slabblock_1 = registerConSlabBlock("cucumber_green_slabblock_1");
    public static final Block cucumber_lightblue_stairblock = registerConstairbBlock(Blockinit.cucumber_lightblue_block.getDefaultState(),"cucumber_lightblue_stairblock");
    public static final Block cucumber_lightblue_stairblock_1 = registerConstairbBlock(Blockinit.cucumber_lightblue_block_1.getDefaultState(),"cucumber_lightblue_stairblock_1");
    public static final Block cucumber_white_stairblock = registerConstairbBlock(Blockinit.cucumber_white_block.getDefaultState(),"cucumber_white_stairblock");
    public static final Block cucumber_white_stairblock_1 = registerConstairbBlock(Blockinit.cucumber_white_block_1.getDefaultState(),"cucumber_white_stairblock_1");
    public static final Block cucumber_green_stairblock = registerConstairbBlock(Blockinit.cucumber_green_block.getDefaultState(),"cucumber_green_stairblock");
    public static final Block cucumber_green_stairblock_1 = registerConstairbBlock(Blockinit.cucumber_green_block_1.getDefaultState(),"cucumber_green_stairblock_1");

    public static final Block cucumber_post_block = registerConModBlock("cucumber_post_block");

    //con_blocl_state
    public static Block registerConBlock(String name){
        return registerBlock(name,new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f)),ITEM_GROUP);
    }

    public static Block registerConSlabBlock(String name){
        return registerBlock(name,new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f)),ITEM_GROUP);
    }

    public static Block registerConstairbBlock(BlockState baseBlockState,String name){
        return registerBlock(name,new ModStairsBlock(baseBlockState,FabricBlockSettings.of(Material.METAL).strength(4.0f)),ITEM_GROUP);
    }

    public static Block registerConModBlock(String name){
        return registerBlock(name,new ModBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f)),ITEM_GROUP);
    }

    //block
    public static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registry.BLOCK,new Identifier("kappa_mod", name),block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM,new Identifier("kappa_mod", name),new BlockItem(block,new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering Mod Block for " + main.MODID);

    }

    //generate blocks
    private static Block registerOreBlockinOverworld(String name, Block block, ItemGroup group, int size, int amoutperchanck, int maxX){

        ConfiguredFeature<?,?> thing_CONFIGURED = ore_registerconfigured_feature(name,block,size);
        PlacedFeature thing_PLACED = ore_register_Placed_Feature(thing_CONFIGURED,amoutperchanck,maxX);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(main.MODID, name), thing_CONFIGURED);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(main.MODID, name),
                thing_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(main.MODID, name)));
        return registerBlock(name,block,group);
    }

    private static ConfiguredFeature<?,?> ore_registerconfigured_feature(String name,Block block,int size){
        return Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, block.getDefaultState(), size));
    }

    private static PlacedFeature ore_register_Placed_Feature(ConfiguredFeature<?,?> _value1, int _value2, int _value3){
        return _value1.withPlacement(CountPlacementModifier.of(_value2), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(_value3)));
    }

}