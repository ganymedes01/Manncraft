package ganymedes01.manncraft.items;

import java.util.List;

import ganymedes01.manncraft.lib.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemKillstreakKit extends ItemManncraft {

	public static final String KILLSTREAK_KEY = "Killstreak";

	public ItemKillstreakKit() {
		super("killstreak_kit");
	}

	protected ItemKillstreakKit(String prefix) {
		super(prefix + "_killstreak_kit");
	}

	@Override
	protected final void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setBoolean(KILLSTREAK_KEY, true);
		addKillstreakData(stack, nbt);
	}

	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE);
	}

	@Override
	public void onDeathEvent(NBTTagCompound nbt) {
		// TODO
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		if (nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE) && nbt.getBoolean(KILLSTREAK_KEY))
			tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(Reference.MOD_ID + ".string.killstreak"));
	}
}