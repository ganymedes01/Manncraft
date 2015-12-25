package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemCrateKey extends ItemManncraft {

	public static enum UnusualEffect {
		TEMP;

		public String getLocalisedName() {
			return StatCollector.translateToLocal(Reference.MOD_ID + ".unusual.effect." + name().toLowerCase(Locale.ENGLISH));
		}

		private static final Random rand = new Random();

		public static UnusualEffect getRandom() {
			UnusualEffect[] effects = values();
			return effects[rand.nextInt(effects.length)];
		}
	}

	public static final String UNUSUAL_KEY = "Unusual";

	public ItemCrateKey() {
		super("crate_key");
		setMaxStackSize(64);
	}

	@Override
	public void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setInteger(UNUSUAL_KEY, UnusualEffect.getRandom().ordinal());
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(UNUSUAL_KEY, Constants.NBT.TAG_INT);
	}

	@Override
	public boolean isCompatibleWeapon(ItemStack stack, ItemStack weapon) {
		return false; // Prevent quality being added through recipes
	}

	@Override
	public void onKill(EntityPlayer killer, EntityLivingBase victim, NBTTagCompound nbt, ItemStack weapon) {
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		UnusualEffect effect = UnusualEffect.values()[nbt.getInteger(UNUSUAL_KEY)];
		tooltip.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal(Reference.MOD_ID + ".string.unusual.effect") + ": " + effect.getLocalisedName());
	}

	@Override
	public EnumChatFormatting getTextColour() {
		return EnumChatFormatting.DARK_PURPLE;
	}
}