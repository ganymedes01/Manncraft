package ganymedes01.manncraft.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.manncraft.ModBlocks;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.handler.events.CommonEventHandler;
import ganymedes01.manncraft.lib.Reference;
import ganymedes01.manncraft.recipes.AddQualityRecipe;
import ganymedes01.manncraft.tileentities.TileEntityChemistrySet;
import ganymedes01.manncraft.tileentities.TileEntityCrate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		GameRegistry.addRecipe(new AddQualityRecipe());
		RecipeSorter.register(Reference.MOD_ID + ".quality_recipe", AddQualityRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");
		MinecraftForge.EVENT_BUS.register(CommonEventHandler.INSTANCE);

		GameRegistry.registerTileEntity(TileEntityChemistrySet.class, Reference.MOD_ID + ".chemistry_set");
		GameRegistry.registerTileEntity(TileEntityCrate.class, Reference.MOD_ID + ".crate");
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}