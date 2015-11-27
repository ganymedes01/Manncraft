package ganymedes01.manncraft.recipes;

import ganymedes01.manncraft.api.IWeaponQuality;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AddQualityRecipe implements IRecipe {

	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		ItemStack mannItem = getMannItem(grid);
		ItemStack weapon = ItemStack.copyItemStack(getWeapon(grid));

		if (mannItem != null && weapon != null) {
			IWeaponQuality item = (IWeaponQuality) mannItem.getItem();
			if (!item.isQualityApplied(mannItem, weapon) && item.isCompatibleWeapon(mannItem, weapon))
				return item.addQualityToWeapon(mannItem, weapon);
		}

		return null;
	}

	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		ItemStack mannItem = getMannItem(grid);
		ItemStack weapon = ItemStack.copyItemStack(getWeapon(grid));

		if (mannItem != null && weapon != null) {
			IWeaponQuality item = (IWeaponQuality) mannItem.getItem();
			return !item.isQualityApplied(mannItem, weapon) && item.isCompatibleWeapon(mannItem, weapon);
		}

		return false;
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

	private ItemStack getWeapon(InventoryCrafting grid) {
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack stack = grid.getStackInSlot(i);
			if (stack != null && !(stack.getItem() instanceof IWeaponQuality))
				return stack;
		}
		return null;
	}

	private ItemStack getMannItem(InventoryCrafting grid) {
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack stack = grid.getStackInSlot(i);
			if (stack != null && stack.getItem() instanceof IWeaponQuality)
				return stack;
		}
		return null;
	}
}