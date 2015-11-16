package ganymedes01.manncraft.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemProfessionalKillstreakKit extends ItemSpecialisedKillstreakKit {

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
}