package ganymedes01.manncraft.items;

import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.api.IWeaponQuality;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Constants;

public abstract class ItemBlockManncraft extends ItemBlock implements IWeaponQuality {

	public ItemBlockManncraft(Block block) {
		super(block);
		setMaxStackSize(1);
		setCreativeTab(Manncraft.tab);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String name = super.getItemStackDisplayName(stack);
		ItemStack weapon = null;

		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(TARGET_WEAPON_KEY, Constants.NBT.TAG_COMPOUND))
			weapon = ItemStack.loadItemStackFromNBT(stack.getTagCompound().getCompoundTag(TARGET_WEAPON_KEY));

		return weapon == null ? name : name + ": " + weapon.getDisplayName();
	}
}