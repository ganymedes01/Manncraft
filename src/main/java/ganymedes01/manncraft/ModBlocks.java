package ganymedes01.manncraft;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.manncraft.blocks.BlockChemistrySet;
import ganymedes01.manncraft.blocks.BlockCrate;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks {

	public static final Block chemistry_set = new BlockChemistrySet();
	public static final Block crate = new BlockCrate();

	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static void registerBlocks() {
		try {
			for (Field f : ModBlocks.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						if (block != null)
							registerBlock(block);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerBlock(Block block) {
		String name = block.getUnlocalizedName();
		String[] strings = name.split("\\.");
		if (block instanceof IHasCustomItemBlock)
			GameRegistry.registerBlock(block, ((IHasCustomItemBlock) block).getItemBlockClass(), strings[strings.length - 1]);
		else
			GameRegistry.registerBlock(block, strings[strings.length - 1]);
		BLOCKS.add(block);
	}

	public static interface IHasCustomItemBlock {

		Class<? extends ItemBlock> getItemBlockClass();
	}
}