package net.fabricmc.kappa_mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.kappa_mod.block.Blockinit;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.kappa_mod.item.OtherItemoinit;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.fabricmc.kappa_mod.item.iteminit.registerModItems;

public class main implements ModInitializer {

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("main", "cucumber"),
			() -> new ItemStack(Blocks.COBBLESTONE));
	public static final String MODID = "kappa_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger("kappa_mod");



	@Override
	public void onInitialize() {
		//item
		registerModItems();
		//block and ore
		Blockinit.registerModBlocks();
		OtherItemoinit.registerModItems();

	}
}
