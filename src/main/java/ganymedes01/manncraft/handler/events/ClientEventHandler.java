package ganymedes01.manncraft.handler.events;

import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.items.ItemManncraft;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ClientEventHandler {

	public static final ClientEventHandler INSTANCE = new ClientEventHandler();

	private ClientEventHandler() {
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onTooltipEvent(ItemTooltipEvent event) {
		ItemStack stack = event.itemStack;
		List<String> tooltip = event.toolTip;

		if (stack != null && stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND)) {
				nbt = nbt.getCompoundTag(Reference.MOD_NAME);

				for (Item item : ModItems.ITEMS)
					if (item instanceof ItemManncraft) {
						ItemManncraft mannItem = (ItemManncraft) item;
						if (mannItem.isQualityPresent(nbt))
							mannItem.onTooltipEvent(nbt, tooltip);
					}
			}
		}
	}
}