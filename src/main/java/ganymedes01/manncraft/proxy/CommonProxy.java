package ganymedes01.manncraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ganymedes01.manncraft.eventHandlers.MiscEventHandler;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(MiscEventHandler.INSTANCE);
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}