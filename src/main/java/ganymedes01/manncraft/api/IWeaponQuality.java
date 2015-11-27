package ganymedes01.manncraft.api;

import java.util.List;

import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

public interface IWeaponQuality {

	public static final String TARGET_WEAPON_KEY = "Weapon";

	public default ItemStack addQualityToWeapon(ItemStack stack, ItemStack weapon) {
		if (!weapon.hasTagCompound())
			weapon.setTagCompound(new NBTTagCompound());
		NBTTagCompound weaponNBT = weapon.getTagCompound();
		if (!weaponNBT.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			weaponNBT.setTag(Reference.MOD_NAME, new NBTTagCompound());
		addDataToWeaponNBT(stack, weaponNBT.getCompoundTag(Reference.MOD_NAME));
		return weapon;
	}

	public default boolean isQualityApplied(ItemStack stack, ItemStack weapon) {
		if (!weapon.hasTagCompound())
			return false;
		NBTTagCompound weaponNBT = weapon.getTagCompound();
		if (!weaponNBT.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			return false;
		return isQualityPresent(weaponNBT.getCompoundTag(Reference.MOD_NAME));
	}

	public default boolean isCompatibleWeapon(ItemStack stack, ItemStack weapon) {
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey(TARGET_WEAPON_KEY, Constants.NBT.TAG_COMPOUND))
			return true;
		NBTTagCompound nbt = stack.getTagCompound().getCompoundTag(TARGET_WEAPON_KEY);
		ItemStack target = ItemStack.loadItemStackFromNBT(nbt);
		return target != null && target.getItem() == weapon.getItem();
	}

	void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt);

	boolean isQualityPresent(NBTTagCompound nbt);

	/**
	 * Called when an entity is killed with a weapon
	 */
	void onKill(EntityPlayer killer, EntityLivingBase victim, NBTTagCompound nbt, ItemStack weapon);

	void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip);
}