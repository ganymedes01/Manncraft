package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;

import ganymedes01.manncraft.lib.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemProfessionalKillstreakKit extends ItemSpecialisedKillstreakKit {

	// TODO temporary
	public static enum EyeEffect {
		CEREBRAL_DISCHARGE,
		FIRE_HORNS,
		FLAMES,
		HYPNO_BEAM,
		INCINERATOR,
		SINGULARITY,
		TORNADO;

		public String getLocalisedName() {
			return StatCollector.translateToLocal(Reference.MOD_ID + ".killstreak.eye_effect." + name().toLowerCase(Locale.ENGLISH));
		}
	}

	public static final String KILLSTREAK_EYES_KEY = "EyeEffect";

	public ItemProfessionalKillstreakKit() {
		super("professional");
	}

	@Override
	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
		super.addKillstreakData(stack, nbt);
		int eyeEffect = getProperty(stack, KILLSTREAK_EYES_KEY);
		nbt.setInteger(KILLSTREAK_EYES_KEY, eyeEffect);
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		if (nbt.hasKey(KILLSTREAK_EYES_KEY, Constants.NBT.TAG_INT)) {
			EyeEffect eyeEffect = EyeEffect.values()[nbt.getInteger(KILLSTREAK_EYES_KEY)];
			tooltip.add(EnumChatFormatting.AQUA + "Killstreaker: " + eyeEffect.getLocalisedName());
		}
	}
}