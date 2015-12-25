package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.api.IWeaponQuality;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemSpecialisedKillstreakKit extends ItemKillstreakKit {

	public static enum Sheen {
		HOT_ROD(0xFFFFFF),
		MANNDARIN(0xFFFFFF),
		DEADLY_DAFFODIL(0xFFFFFF),
		MEAN_GREEN(0xFFFFFF),
		AGONIZING_EMERALD(0xFFFFFF),
		VILLAINOUS_VIOLET(0xFFFFFF);

		private final int colour;

		Sheen(int colour) {
			this.colour = colour;
		}

		public int getColour() {
			return colour;
		}

		public String getLocalisedName() {
			return StatCollector.translateToLocal(Reference.MOD_ID + ".killstreak.sheen." + name().toLowerCase(Locale.ENGLISH));
		}
	}

	public ItemSpecialisedKillstreakKit() {
		super("specialised");
	}

	protected ItemSpecialisedKillstreakKit(String prefix) {
		super(prefix);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isComplex) {
		Sheen sheen = Sheen.values()[0];
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(KILLSTREAK_SHEEN_KEY, Constants.NBT.TAG_INT))
				sheen = Sheen.values()[nbt.getInteger(KILLSTREAK_SHEEN_KEY)];
		}
		tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(Reference.MOD_ID + ".string.sheen") + ": " + sheen.getLocalisedName());
	}

	@Override
	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
		int sheen = getProperty(stack, KILLSTREAK_SHEEN_KEY);
		nbt.setInteger(KILLSTREAK_SHEEN_KEY, sheen);
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE) && nbt.hasKey(KILLSTREAK_SHEEN_KEY, Constants.NBT.TAG_INT) && !nbt.hasKey(KILLSTREAK_EYES_KEY, Constants.NBT.TAG_INT);
	}

	@Override
	public boolean isCompatibleWeapon(ItemStack stack, ItemStack weapon) {
		if (super.isCompatibleWeapon(stack, weapon)) {
			boolean isNormal = ((IWeaponQuality) ModItems.killstreak_kit).isQualityApplied(stack, weapon);
			boolean isProf = ((IWeaponQuality) ModItems.professional_killstreak_kit).isQualityApplied(stack, weapon);
			return !isNormal && !isProf;
		}
		return false;
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		super.onTooltipEvent(nbt, tooltip);
		if (nbt.hasKey(KILLSTREAK_SHEEN_KEY, Constants.NBT.TAG_INT)) {
			Sheen sheen = Sheen.values()[nbt.getInteger(KILLSTREAK_SHEEN_KEY)];
			tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(Reference.MOD_ID + ".string.sheen") + ": " + sheen.getLocalisedName());
		}
	}

	@Override
	public String getNamePrefix(NBTTagCompound nbt) {
		return StatCollector.translateToLocal(Reference.MOD_ID + ".string.specialised_killstreak");
	}

	protected int getProperty(ItemStack stack, String propName) {
		int prop = 0;
		if (stack.hasTagCompound()) {
			NBTTagCompound stackNBT = stack.getTagCompound();
			if (stackNBT.hasKey(propName, Constants.NBT.TAG_INT))
				prop = stackNBT.getInteger(propName);
		}
		return prop;
	}
}