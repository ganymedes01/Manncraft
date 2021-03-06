package ganymedes01.manncraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.api.IWeaponQuality;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Constants;

public abstract class ItemManncraft extends Item implements IWeaponQuality {

	public ItemManncraft(String name) {
		setMaxStackSize(1);
		setCreativeTab(Manncraft.tab);
		setTextureName(Reference.MOD_ID + ":" + name);
		setUnlocalizedName(Reference.MOD_ID + "." + name);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String name = super.getItemStackDisplayName(stack);
		ItemStack weapon = null;

		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(TARGET_WEAPON_KEY, Constants.NBT.TAG_COMPOUND))
			weapon = ItemStack.loadItemStackFromNBT(stack.getTagCompound().getCompoundTag(TARGET_WEAPON_KEY));

		return weapon == null ? name : name + ": " + weapon.getDisplayName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
	}
}