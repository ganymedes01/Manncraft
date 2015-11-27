package ganymedes01.manncraft.blocks;

import ganymedes01.manncraft.ModBlocks.IHasCustomItemBlock;
import ganymedes01.manncraft.items.ItemChemistrySet;
import ganymedes01.manncraft.tileentities.TileEntityChemistrySet;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class BlockChemistrySet extends BlockManncraft implements IHasCustomItemBlock {

	public BlockChemistrySet() {
		super(Material.wood, "chemistry_set", TileEntityChemistrySet.class);
		setHardness(1.0F);
		setBlockBounds(0, 0, 0, 1, 14F / 16F, 1);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("Match", Constants.NBT.TAG_COMPOUND))
			return;

		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityChemistrySet) {
			TileEntityChemistrySet chemistrySet = (TileEntityChemistrySet) tile;
			NBTTagCompound nbt = stack.getTagCompound().getCompoundTag("Match");
			chemistrySet.setMatch(ItemStack.loadItemStackFromNBT(nbt));
		}
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemChemistrySet.class;
	}
}