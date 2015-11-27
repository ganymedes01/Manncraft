package ganymedes01.manncraft.blocks;

import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockManncraft extends BlockContainer {

	private final Class<? extends TileEntity> tileClass;

	public BlockManncraft(Material material, String name, Class<? extends TileEntity> tileClass) {
		super(material);
		this.tileClass = tileClass;
		setCreativeTab(Manncraft.tab);
		setBlockName(Reference.MOD_ID + "." + name);
		setBlockTextureName(Reference.MOD_ID + ":" + name);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		try {
			return tileClass.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}