package ganymedes01.manncraft.items;

import java.util.List;

import ganymedes01.manncraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemChemistrySet extends ItemBlockManncraft {

	public static final String COLLECTORS_KEY = "Collectors";

	public ItemChemistrySet(Block block) {
		super(block);
	}

	@Override
	public void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setBoolean(COLLECTORS_KEY, true);
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.getBoolean(COLLECTORS_KEY);
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
	}

	@Override
	public String getNamePrefix(NBTTagCompound nbt) {
		return StatCollector.translateToLocal(Reference.MOD_ID + ".string.collectors");
	}

	@Override
	public EnumChatFormatting getTextColour() {
		return EnumChatFormatting.DARK_RED;
	}
}