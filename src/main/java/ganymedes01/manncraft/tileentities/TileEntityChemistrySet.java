package ganymedes01.manncraft.tileentities;

import ganymedes01.manncraft.ModBlocks;
import ganymedes01.manncraft.items.ItemChemistrySet;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityChemistrySet extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[1];
	private ItemStack match = null;
	private int depositedAmount = 0;

	@Override
	public void updateEntity() {
		if (worldObj.isRemote)
			return;

		for (int i = 0; i < inventory.length; i++)
			if (inventory[i] != null) {
				if (match == null)
					match = inventory[i].copy();

				setInventorySlotContents(i, null);
				if (++depositedAmount >= 200)
					createKit();
			}
	}

	public void setMatch(ItemStack match) {
		this.match = match;
	}

	protected void createKit() {
		ItemStack result = match.copy();
		NBTTagCompound nbt;

		if (!result.hasTagCompound()) {
			NBTTagCompound newNBT = new NBTTagCompound();
			newNBT.setTag(Reference.MOD_NAME, nbt = new NBTTagCompound());
			result.setTagCompound(newNBT);
		} else if (result.getTagCompound().hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			nbt = result.getTagCompound().getCompoundTag(Reference.MOD_NAME);
		else
			result.getTagCompound().setTag(Reference.MOD_NAME, nbt = new NBTTagCompound());

		nbt.setBoolean(ItemChemistrySet.COLLECTORS_KEY, true);

		EntityItem item = new EntityItem(worldObj);
		item.setPosition(xCoord + 0.5F, yCoord + 0.5F, zCoord + 0.5F);
		item.setEntityItemStack(result);
		worldObj.spawnEntityInWorld(item);

		worldObj.playAuxSFXAtEntity(null, 2001, xCoord, yCoord, zCoord, Block.getIdFromBlock(ModBlocks.chemistry_set));
		worldObj.setBlockToAir(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList tagList = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		inventory = new ItemStack[getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound nbt1 = tagList.getCompoundTagAt(i);
			int j = nbt1.getByte("Slot") & 255;
			if (j >= 0 && j < inventory.length)
				inventory[j] = ItemStack.loadItemStackFromNBT(nbt1);
		}

		match = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("Match"));

		depositedAmount = nbt.getInteger("DepositedAmount");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList tagList = new NBTTagList();
		for (int i = 0; i < inventory.length; i++)
			if (inventory[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				tagList.appendTag(inventory[i].writeToNBT(nbt1));
			}
		nbt.setTag("Items", tagList);

		if (match != null)
			nbt.setTag("Match", match.writeToNBT(new NBTTagCompound()));

		nbt.setInteger("DepositedAmount", depositedAmount);
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int size) {
		if (inventory[slot] != null) {
			ItemStack itemstack;

			if (inventory[slot].stackSize <= size) {
				itemstack = inventory[slot];
				inventory[slot] = null;
				markDirty();
				return itemstack;
			} else {
				itemstack = inventory[slot].splitStack(size);

				if (inventory[slot].stackSize == 0)
					inventory[slot] = null;

				markDirty();
				return itemstack;
			}
		} else
			return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inventory[slot] != null) {
			ItemStack itemstack = inventory[slot];
			inventory[slot] = null;
			return itemstack;
		} else
			return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit())
			stack.stackSize = getInventoryStackLimit();

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (stack == null)
			return false;
		if (match == null)
			return true;
		return match.getItem() == stack.getItem() && match.getItemDamage() == stack.getItemDamage() && ItemStack.areItemStackTagsEqual(match, stack);
	}
}