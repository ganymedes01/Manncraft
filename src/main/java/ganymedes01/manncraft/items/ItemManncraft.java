package ganymedes01.manncraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

public abstract class ItemManncraft extends Item {

	public static final String TARGET_WEAPON_KEY = "Weapon";

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

	public ItemStack addQualityToWeapon(ItemStack stack, ItemStack weapon) {
		if (!weapon.hasTagCompound())
			weapon.setTagCompound(new NBTTagCompound());
		NBTTagCompound weaponNBT = weapon.getTagCompound();
		if (!weaponNBT.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			weaponNBT.setTag(Reference.MOD_NAME, new NBTTagCompound());
		addDataToWeaponNBT(stack, weaponNBT.getCompoundTag(Reference.MOD_NAME));
		return weapon;
	}

	public boolean isQualityApplied(ItemStack stack, ItemStack weapon) {
		if (!weapon.hasTagCompound())
			return false;
		NBTTagCompound weaponNBT = weapon.getTagCompound();
		if (!weaponNBT.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			return false;
		return isQualityPresent(weaponNBT.getCompoundTag(Reference.MOD_NAME));
	}

	public boolean isCompatibleWeapon(ItemStack stack, ItemStack weapon) {
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey(TARGET_WEAPON_KEY, Constants.NBT.TAG_COMPOUND))
			return true;
		NBTTagCompound nbt = stack.getTagCompound().getCompoundTag(TARGET_WEAPON_KEY);
		ItemStack target = ItemStack.loadItemStackFromNBT(nbt);
		return target != null && target.getItem() == weapon.getItem();
	}

	protected abstract void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt);

	public abstract boolean isQualityPresent(NBTTagCompound nbt);

	public abstract void onDeathEvent(NBTTagCompound nbt);

	public abstract void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip);
}