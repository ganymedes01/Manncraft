package ganymedes01.manncraft.items;

import java.util.List;

import ganymedes01.manncraft.handler.KillstreakHandler;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemKillstreakKit extends ItemManncraft {

	public static final String KILLSTREAK_KEY = "Killstreak";

	public static enum Killstreak {
		KILLING_SPREE,
		UNSTOPPABLE,
		RAMPAGE,
		GOD_LIKE,
		STILL_GOD_LIKE;

		public static Killstreak getKillstreak(int kills) {
			Killstreak[] killstreaks = values();
			for (int i = 0; i < killstreaks.length; i++) {
				Killstreak killstreak = killstreaks[i];
				if (i == killstreaks.length - 1)
					if (kills >= killstreak.ordinal() * 5)
						return killstreak;

				Killstreak next = killstreaks[i + 1];
				if (kills < next.ordinal() * 5 && kills >= killstreak.ordinal() * 5)
					return killstreak;
			}
			return null;
		}

		// TODO
		public String getAnnouncement(String playerName, int kills) {
			String str = EnumChatFormatting.RED + playerName;

			switch (this) {
				case GOD_LIKE:
					str += EnumChatFormatting.WHITE + "is " + EnumChatFormatting.GOLD + "God-Like";
				case KILLING_SPREE:
					str += EnumChatFormatting.WHITE + "is on a " + EnumChatFormatting.DARK_GREEN + "Killing Spree";
				case RAMPAGE:
					str += EnumChatFormatting.WHITE + "is on a " + EnumChatFormatting.DARK_PURPLE + "Rampage";
				case STILL_GOD_LIKE:
					str += EnumChatFormatting.WHITE + "is still " + EnumChatFormatting.GOLD + "God-Like";
				case UNSTOPPABLE:
					str += EnumChatFormatting.WHITE + "is " + EnumChatFormatting.RED + "Unstoppable";
			}

			return str + " " + kills;
		}
	}

	public ItemKillstreakKit() {
		super("killstreak_kit");
	}

	protected ItemKillstreakKit(String prefix) {
		super(prefix + "_killstreak_kit");
	}

	@Override
	protected final void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setBoolean(KILLSTREAK_KEY, true);
		addKillstreakData(stack, nbt);
	}

	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE);
	}

	@Override
	public void onKill(EntityPlayer killer, EntityLivingBase victim, NBTTagCompound nbt) {
		KillstreakHandler.INSTANCE.onPlayerKill(killer);
		if (victim instanceof EntityPlayer)
			KillstreakHandler.INSTANCE.onPlayerDeath((EntityPlayer) victim);

	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		if (nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE) && nbt.getBoolean(KILLSTREAK_KEY))
			tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(Reference.MOD_ID + ".string.killstreak"));
	}
}