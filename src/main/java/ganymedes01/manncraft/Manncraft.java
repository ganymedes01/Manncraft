package ganymedes01.manncraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import ganymedes01.manncraft.api.IWeaponQuality;
import ganymedes01.manncraft.lib.Reference;
import ganymedes01.manncraft.network.ChatMessagePacketHandler.KillstreakEndHandler;
import ganymedes01.manncraft.network.ChatMessagePacketHandler.KillstreakStartHandler;
import ganymedes01.manncraft.network.ChatMessagePacketHandler.StrangifierLevelUpHandler;
import ganymedes01.manncraft.network.KillstreakEndedMessagePacket;
import ganymedes01.manncraft.network.KillstreakStartedMessagePacket;
import ganymedes01.manncraft.network.StrangifierLevelUpMessagePacket;
import ganymedes01.manncraft.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
public class Manncraft {

	@Instance(Reference.MOD_ID)
	public static Manncraft instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tab = new CreativeTabs(Reference.MOD_ID) {

		@Override
		public Item getTabIconItem() {
			return ModItems.strangifier;
		}
	};

	public static SimpleNetworkWrapper networkWrapper;

	public static List<Object> QUALITY_ORDER;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		networkWrapper.registerMessage(StrangifierLevelUpHandler.class, StrangifierLevelUpMessagePacket.class, 0, Side.CLIENT);
		networkWrapper.registerMessage(KillstreakEndHandler.class, KillstreakEndedMessagePacket.class, 1, Side.CLIENT);
		networkWrapper.registerMessage(KillstreakStartHandler.class, KillstreakStartedMessagePacket.class, 2, Side.CLIENT);

		proxy.preInit(event);

		QUALITY_ORDER = Collections.unmodifiableList(Arrays.asList(ModItems.strangifier, Item.getItemFromBlock(ModBlocks.chemistry_set), ModItems.killstreak_kit, ModItems.specialised_killstreak_kit, ModItems.professional_killstreak_kit));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	public static List<IWeaponQuality> getAllQualities() {
		List<IWeaponQuality> qualities = new ArrayList<IWeaponQuality>();
		for (Item item : ModItems.ITEMS)
			if (item instanceof IWeaponQuality)
				qualities.add((IWeaponQuality) item);
		for (Block block : ModBlocks.BLOCKS) {
			Item item = Item.getItemFromBlock(block);
			if (item instanceof IWeaponQuality)
				qualities.add((IWeaponQuality) item);
		}
		return qualities;
	}
}