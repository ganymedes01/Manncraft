package ganymedes01.manncraft.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.eventHandlers.CommonEventHandler;
import ganymedes01.manncraft.recipes.AddQualityRecipe;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModItems.registerItems();
		GameRegistry.addRecipe(new AddQualityRecipe());
		MinecraftForge.EVENT_BUS.register(CommonEventHandler.INSTANCE);
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}