package ganymedes01.manncraft.items;

import java.util.List;
import java.util.Locale;

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
	public static final String KILLSTREAK_SHEEN_KEY = "Sheen";
	public static final String KILLSTREAK_EYES_KEY = "EyeEffect";

	public static final int KILLSTREAK_STEP = 5;

	public static enum Killstreak {
		KILLING_SPREE,
		UNSTOPPABLE,
		RAMPAGE,
		GOD_LIKE,
		STILL_GOD_LIKE;

		public static Killstreak getKillstreak(int kills) {
			if (kills >= 25)
				return STILL_GOD_LIKE;
			else if (kills >= 20)
				return GOD_LIKE;
			else if (kills >= 15)
				return RAMPAGE;
			else if (kills >= 10)
				return UNSTOPPABLE;
			else if (kills >= 5)
				return KILLING_SPREE;
			else
				return null;
		}

		public String getLocalisedName() {
			return StatCollector.translateToLocal(Reference.MOD_ID + ".killstreak.name." + name().toLowerCase(Locale.ENGLISH));
		}
	}

	public ItemKillstreakKit() {
		super("killstreak_kit");
	}

	protected ItemKillstreakKit(String prefix) {
		super(prefix + "_killstreak_kit");
	}

	@Override
	public final void addDataToWeaponNBT(ItemStack stack, NBTTagCompound nbt) {
		nbt.setBoolean(KILLSTREAK_KEY, true);
		addKillstreakData(stack, nbt);
	}

	protected void addKillstreakData(ItemStack stack, NBTTagCompound nbt) {
	}

	@Override
	public boolean isQualityPresent(NBTTagCompound nbt) {
		return nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE) && !nbt.hasKey(KILLSTREAK_SHEEN_KEY, Constants.NBT.TAG_INT) && !nbt.hasKey(KILLSTREAK_EYES_KEY, Constants.NBT.TAG_INT);
	}

	@Override
	public void onKill(EntityPlayer killer, EntityLivingBase victim, NBTTagCompound nbt, ItemStack weapon) {
		KillstreakHandler.INSTANCE.onPlayerKill(killer);
		if (victim instanceof EntityPlayer)
			KillstreakHandler.INSTANCE.onPlayerDeath((EntityPlayer) victim);

	}

	@Override
	public void onTooltipEvent(NBTTagCompound nbt, List<String> tooltip) {
		if (nbt.hasKey(KILLSTREAK_KEY, Constants.NBT.TAG_BYTE) && nbt.getBoolean(KILLSTREAK_KEY))
			tooltip.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal(Reference.MOD_ID + ".string.killstreak"));
	}

	@Override
	public String getNamePrefix(NBTTagCompound nbt) {
		return StatCollector.translateToLocal(Reference.MOD_ID + ".string.killstreak");
	}
}