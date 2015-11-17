package ganymedes01.manncraft.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import ganymedes01.manncraft.items.ItemStrangifier;
import ganymedes01.manncraft.lib.Reference;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class StrangifierLevelUpMessagePacket extends ChatMessagePacket {

	private String playerName;
	private ItemStack weapon;
	private ItemStrangifier.Rank rank;

	public StrangifierLevelUpMessagePacket() {
	}

	public StrangifierLevelUpMessagePacket(String playerName, ItemStack weapon, ItemStrangifier.Rank rank) {
		this.playerName = playerName;
		this.weapon = weapon;
		this.rank = rank;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, playerName);
		ByteBufUtils.writeItemStack(buf, weapon);
		buf.writeInt(rank.ordinal());
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		playerName = ByteBufUtils.readUTF8String(buf);
		weapon = ByteBufUtils.readItemStack(buf);
		rank = ItemStrangifier.Rank.values()[buf.readInt()];
	}

	@Override
	public String getMessage() {
		return StatCollector.translateToLocalFormatted(Reference.MOD_ID + ".message.strange_level_up", formatText(EnumChatFormatting.GREEN, playerName), formatText(EnumChatFormatting.RED, weapon.getDisplayName()), formatText(EnumChatFormatting.GOLD, rank.getLocalisedName()));
	}
}