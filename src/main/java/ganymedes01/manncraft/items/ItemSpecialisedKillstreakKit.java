package ganymedes01.manncraft.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

public class ItemSpecialisedKillstreakKit extends ItemKillstreakKit {

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