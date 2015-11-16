package ganymedes01.manncraft.eventHandlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.items.ItemManncraft;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class CommonEventHandler {

	public static final CommonEventHandler INSTANCE = new CommonEventHandler();

	private CommonEventHandler() {
	}

	@SubscribeEvent
	public void onDeathEvent(LivingDeathEvent event) {
		ItemStack weapon = getWeapon(event.source);
		if (weapon == null)
			return;

		if (!weapon.hasTagCompound())
			return;

		NBTTagCompound nbt = weapon.getTagCompound();
		if (nbt.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND))
			nbt = nbt.getCompoundTag(Reference.MOD_NAME);
		else
			return;

		for (Item item : ModItems.ITEMS)
			if (item instanceof ItemManncraft) {
				ItemManncraft mannItem = (ItemManncraft) item;
				if (mannItem.isQualityPresent(nbt))
					mannItem.onDeathEvent(nbt);
			}
	}

	private ItemStack getWeapon(DamageSource source) {
		if (source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity instanceof EntityPlayer)
				return ((EntityPlayer) entity).getCurrentEquippedItem();
		}
		return null;
	}
}