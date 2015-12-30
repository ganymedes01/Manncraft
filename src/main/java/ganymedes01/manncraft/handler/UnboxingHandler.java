package ganymedes01.manncraft.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.items.ItemCrateKey;
import ganymedes01.manncraft.items.ItemCrateKey.UnusualEffect;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class UnboxingHandler {

	private static final float UNUSUAL_CHANCE = 1.0F; // TODO think-up a good chance

	private static List<Item> loot = new ArrayList<Item>();

	static {
		loot.add(Items.leather_helmet);
		loot.add(Items.iron_helmet);
		loot.add(Items.chainmail_helmet);
		loot.add(Items.golden_helmet);
		loot.add(Items.diamond_helmet);
		// TODO allow other mods to add their own helmets
		// TODO add IUnusualHat interface
	}

	public static ItemStack getRandomHat(ItemStack key) {
		Random rand = new Random();
		Item item = loot.get(rand.nextInt(loot.size()));
		ItemStack stack = new ItemStack(item);

		NBTTagCompound nbt = new NBTTagCompound();
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setTag(Reference.MOD_NAME, nbt);
		if (rand.nextFloat() <= UNUSUAL_CHANCE)
			((ItemCrateKey) ModItems.crate_key).addDataToWeaponNBT(key, nbt);

		return stack;
	}

	public static boolean isHatUnusual(ItemStack hat) {
		if (hat != null && hat.hasTagCompound() && loot.contains(hat.getItem())) {
			NBTTagCompound nbt = hat.getTagCompound().getCompoundTag(Reference.MOD_NAME);
			return nbt != null && ((ItemCrateKey) ModItems.crate_key).isQualityPresent(nbt);
		}
		return false;
	}

	public static UnusualEffect getEffect(ItemStack hat) {
		NBTTagCompound nbt = hat.getTagCompound().getCompoundTag(Reference.MOD_NAME);
		return UnusualEffect.getEffect(nbt.getString(ItemCrateKey.UNUSUAL_KEY));
	}
}