package ganymedes01.manncraft.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.client.renderer.items.KillstreakKitRenderer;
import ganymedes01.manncraft.eventHandlers.ClientEventHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);

		MinecraftForgeClient.registerItemRenderer(ModItems.killstreak_kit, new KillstreakKitRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.specialised_killstreak_kit, new KillstreakKitRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.professional_killstreak_kit, new KillstreakKitRenderer());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}