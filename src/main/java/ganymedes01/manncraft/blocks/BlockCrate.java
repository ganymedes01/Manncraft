package ganymedes01.manncraft.blocks;

import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.handler.UnboxingHandler;
import ganymedes01.manncraft.tileentities.TileEntityCrate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCrate extends BlockManncraft {

	public BlockCrate() {
		super(Material.wood, "crate", TileEntityCrate.class);
		setHardness(1.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getCurrentEquippedItem();
		if (stack != null && stack.getItem() == ModItems.crate_key) {
			if (!world.isRemote) {
				openCrate(world, x, y, z, stack);
				if (--stack.stackSize <= 0)
					player.setCurrentItemOrArmor(0, null);
			}
			return true;
		}
		return false;
	}

	private void openCrate(World world, int x, int y, int z, ItemStack key) {
		EntityItem item = new EntityItem(world);
		item.setPosition(x + 0.5F, y + 0.5F, z + 0.5F);
		item.setEntityItemStack(UnboxingHandler.getRandomHat(key));
		world.spawnEntityInWorld(item);

		world.playAuxSFXAtEntity(null, 2001, x, y, z, Block.getIdFromBlock(this));
		world.setBlockToAir(x, y, z);
	}
}