package ganymedes01.manncraft;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.manncraft.items.ItemCrateKey;
import ganymedes01.manncraft.items.ItemKillstreakKit;
import ganymedes01.manncraft.items.ItemProfessionalKillstreakKit;
import ganymedes01.manncraft.items.ItemSpecialisedKillstreakKit;
import ganymedes01.manncraft.items.ItemStrangifier;
import net.minecraft.item.Item;

public class ModItems {

	public static final Item strangifier = new ItemStrangifier();
	public static final Item killstreak_kit = new ItemKillstreakKit();
	public static final Item specialised_killstreak_kit = new ItemSpecialisedKillstreakKit();
	public static final Item professional_killstreak_kit = new ItemProfessionalKillstreakKit();
	public static final Item crate_key = new ItemCrateKey();

	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static void registerItems() {
		try {
			for (Field f : ModItems.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Item)
					registerItem((Item) obj);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerItem(Item item) {
		String name = item.getUnlocalizedName();
		String[] strings = name.split("\\.");
		GameRegistry.registerItem(item, strings[strings.length - 1]);
		ITEMS.add(item);
	}
}