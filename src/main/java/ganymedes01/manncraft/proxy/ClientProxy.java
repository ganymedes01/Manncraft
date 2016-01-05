package ganymedes01.manncraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ganymedes01.manncraft.ModBlocks;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.client.renderer.items.ItemChemistrySetRenderer;
import ganymedes01.manncraft.client.renderer.items.ItemCrateRenderer;
import ganymedes01.manncraft.client.renderer.items.ItemKillstreakKitRenderer;
import ganymedes01.manncraft.client.renderer.items.ItemStrangifierRenderer;
import ganymedes01.manncraft.client.renderer.tileentities.TileEntityChemistrySetRenderer;
import ganymedes01.manncraft.client.renderer.tileentities.TileEntityCrateRenderer;
import ganymedes01.manncraft.handler.events.ClientEventHandler;
import ganymedes01.manncraft.tileentities.TileEntityChemistrySet;
import ganymedes01.manncraft.tileentities.TileEntityCrate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);

		registerItemRenderer(ModItems.killstreak_kit, new ItemKillstreakKitRenderer());
		registerItemRenderer(ModItems.specialised_killstreak_kit, new ItemKillstreakKitRenderer());
		registerItemRenderer(ModItems.professional_killstreak_kit, new ItemKillstreakKitRenderer());
		registerItemRenderer(ModItems.strangifier, new ItemStrangifierRenderer());
		registerItemRenderer(ModBlocks.chemistry_set, new ItemChemistrySetRenderer());
		registerItemRenderer(ModBlocks.crate, new ItemCrateRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChemistrySet.class, new TileEntityChemistrySetRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrate.class, new TileEntityCrateRenderer());
	}

	private void registerItemRenderer(Item item, IItemRenderer renderer) {
		MinecraftForgeClient.registerItemRenderer(item, renderer);
	}

	private void registerItemRenderer(Block block, IItemRenderer renderer) {
		registerItemRenderer(Item.getItemFromBlock(block), renderer);
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