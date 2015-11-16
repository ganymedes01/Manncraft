package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;

import ganymedes01.manncraft.handler.AnnouncementsHandler;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.Constants;

public class ItemStrangifier extends ItemManncraft {

	public static enum Rank {
		STRANGE(0),
		UNREMARKABLE(10),
		SCARCELY_LETHAL(25),
		MILDLY_MENACING(45),
		SOMEWHAT_THREATENING(70),
		UNCHARITABLE(100),
		NOTABLY_DANGEROUS(135),
		SUFFICIENTLY_LETHAL(175),
		TRULY_FEARED(225),
		SPECTACULARLY_LETHAL(275),
		GORE_SPATTERED(350),
		WICKED_NASTY(500),
		POSITIVELY_INHUMANE(750),
		TOTALLY_ORDINARY(999),
		FACE_MELTING(1000),
		RAGE_INDUCING(1500),
		EPIC(2500),
		LEGENDARY(5000),
		SWEDISH(7616),
		NOTCHS_OWN(8500);

		private final int kills;

		Rank(int kills) {
			this.kills = kills;
		}

		public String getLocalisedName() {
			return StatCollector.translateToLocal(Reference.MOD_ID + ".strange.rank." + name().toLowerCase(Locale.ENGLISH));
		}

		public static Rank getRank(int kills) {
			Rank[] ranks = values();
			for (int i = 0; i < ranks.length; i++) {
				Rank rank = ranks[i];
				if (i == ranks.length - 1)
					if (kills >= rank.kills)
						return rank;
				Rank next = ranks[i + 1];
				if (kills < next.kills && kills >= rank.kills)
					return rank;
			}
			return STRANGE;
		}
	}

	public static final String STRANGE_KEY = "Strange";

	public ItemStrangifier() {
		super("strangifier");
	}

	@Override
	protected void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setInteger(STRANGE_KEY, 0);
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(STRANGE_KEY, Constants.NBT.TAG_INT);
	}

	@Override
	public void onKill(EntityPlayer killer, EntityLivingBase victim, NBTTagCompound nbt) {
		int current = nbt.getInteger(STRANGE_KEY);
		nbt.setInteger(STRANGE_KEY, current + 1);

		Rank newRank = Rank.getRank(current + 1);
		if (Rank.getRank(current) != Rank.getRank(current + 1))
			// TODO
			AnnouncementsHandler.INSTANCE.sendMessageToAll("Weapon leveled up: " + newRank.getLocalisedName());
	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		int kills = nbt.getInteger(STRANGE_KEY);
		Rank rank = Rank.getRank(kills);
		tooltip.add(EnumChatFormatting.GOLD + rank.getLocalisedName());
		tooltip.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal(Reference.MOD_ID + ".string.kills") + ": " + kills);
	}
}