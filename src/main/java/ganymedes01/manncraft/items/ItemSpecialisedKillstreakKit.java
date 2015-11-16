package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;

import ganymedes01.manncraft.lib.Reference;
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

	public static final String KILLSTREAK_SHEEN_KEY = "Sheen";

	public ItemSpecialisedKillstreakKit() {
		super("specialised");
	}

	protected ItemSpecialisedKillstreakKit(String prefix) {
		super(prefix);
	}

	@Override
	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
		int sheen = getProperty(stack, KILLSTREAK_SHEEN_KEY);
		nbt.setInteger(KILLSTREAK_SHEEN_KEY, sheen);
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		if (nbt.hasKey(KILLSTREAK_SHEEN_KEY, Constants.NBT.TAG_INT)) {
			Sheen sheen = Sheen.values()[nbt.getInteger(KILLSTREAK_SHEEN_KEY)];
			tooltip.add(EnumChatFormatting.AQUA + "Sheen: " + sheen.getLocalisedName());
		}
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