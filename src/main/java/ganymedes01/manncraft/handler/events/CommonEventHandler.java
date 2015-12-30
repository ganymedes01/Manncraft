package ganymedes01.manncraft.handler.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.api.IWeaponQuality;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class CommonEventHandler {

	public static final CommonEventHandler INSTANCE = new CommonEventHandler();

	private CommonEventHandler() {
	}

	@SubscribeEvent
	public void onDeathEvent(LivingDeathEvent event) {
		EntityPlayer killer = getKiller(event.source);
		if (killer != null) {
			ItemStack weapon = killer.getCurrentEquippedItem();
			if (weapon != null && weapon.hasTagCompound()) {
				NBTTagCompound nbt = weapon.getTagCompound();
				if (nbt.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND)) {
					nbt = nbt.getCompoundTag(Reference.MOD_NAME);
					for (IWeaponQuality weaponQuality : Manncraft.getAllQualities())
						if (weaponQuality.isQualityPresent(nbt))
							weaponQuality.onKill(killer, event.entityLiving, nbt, weapon.copy());
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		ItemStack helmet = entity.getEquipmentInSlot(4);
		if (helmet != null && helmet.hasTagCompound()) {
			NBTTagCompound nbt = helmet.getTagCompound();
			if (nbt.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND)) {
				nbt = nbt.getCompoundTag(Reference.MOD_NAME);
				for (IWeaponQuality weaponQuality : Manncraft.getAllQualities())
					if (weaponQuality.isQualityPresent(nbt))
						weaponQuality.onUpdate(nbt, entity);
			}
		}
	}

	private EntityPlayer getKiller(DamageSource source) {
		if (source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity instanceof EntityPlayer)
				return (EntityPlayer) entity;
		}
		return null;
	}
}