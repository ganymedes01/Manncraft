package ganymedes01.manncraft.handler.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.api.IWeaponQuality;
import ganymedes01.manncraft.handler.UnboxingHandler;
import ganymedes01.manncraft.items.ItemCrateKey.UnusualEffect;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ClientEventHandler {

	public static final ClientEventHandler INSTANCE = new ClientEventHandler();

	private ClientEventHandler() {
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onTooltipEvent(ItemTooltipEvent event) {

		ItemStack stack = event.itemStack;
		List<String> tooltip = new ArrayList<String>();

		if (stack != null && stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(Reference.MOD_NAME, Constants.NBT.TAG_COMPOUND)) {
				nbt = nbt.getCompoundTag(Reference.MOD_NAME);

				List<IWeaponQuality> qualities = Manncraft.getAllQualities();

				// Sort qualities so their prefixes are added in the correct order
				Collections.sort(qualities);

				// Select the colour of the left-most prefix as that will be the colour of the whole text
				EnumChatFormatting colour = EnumChatFormatting.WHITE;
				for (IWeaponQuality weaponQuality : qualities)
					if (weaponQuality.isQualityPresent(nbt)) {
						EnumChatFormatting qualityColour = weaponQuality.getTextColour();
						if (qualityColour != EnumChatFormatting.WHITE)
							colour = qualityColour;
					}

				// Reverse order of the list and then add the text prefixes
				Collections.reverse(qualities);
				for (IWeaponQuality weaponQuality : qualities)
					if (weaponQuality.isQualityPresent(nbt)) {
						String prefix = weaponQuality.getNamePrefix(nbt);
						if (!StringUtils.isNullOrEmpty(prefix))
							modifyName(event.toolTip, prefix + " ");
						weaponQuality.onTooltipEvent(nbt, tooltip);
					}

				// Now finally add the colour
				modifyName(event.toolTip, colour);
			}
		}

		if (!tooltip.isEmpty()) {
			event.toolTip.add("");
			event.toolTip.addAll(tooltip);
		}
	}

	private void modifyName(List<String> tooltip, Object prefix) {
		String name = tooltip.get(0);
		tooltip.remove(0);
		tooltip.add(0, prefix + name);
	}

	@SubscribeEvent
	public void renderHelmetEvent(RenderPlayerEvent.Specials.Post event) {
		if (event.entityPlayer != null) {
			ModelBiped model = event.renderer.modelBipedMain;

			ItemStack helmet = event.entityPlayer.inventory.armorItemInSlot(3);
			if (UnboxingHandler.isHatUnusual(helmet)) {
				model.bipedHead.postRender(0.0625F);

				GL11.glPushMatrix();
				GL11.glColor3f(1.0F, 1.0F, 1.0F);
				GL11.glScalef(1.0F, -1.0F, -1.0F);

				UnusualEffect effect = UnboxingHandler.getEffect(helmet);
				if (effect != null)
					effect.getRenderer().render(helmet, event.partialRenderTick);

				GL11.glPopMatrix();
			}
		}
	}
}