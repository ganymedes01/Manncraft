package ganymedes01.manncraft.network;

import java.util.Locale;

import cpw.mods.fml.common.network.ByteBufUtils;
import ganymedes01.manncraft.items.ItemKillstreakKit;
import ganymedes01.manncraft.lib.Reference;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class KillstreakStartedMessagePacket extends ChatMessagePacket {

	private String playerName;
	private ItemKillstreakKit.Killstreak killstreak;
	private int kills;

	public KillstreakStartedMessagePacket() {
	}

	public KillstreakStartedMessagePacket(String playerName, ItemKillstreakKit.Killstreak killstreak, int kills) {
		this.playerName = playerName;
		this.killstreak = killstreak;
		this.kills = kills;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, playerName);
		buf.writeInt(killstreak.ordinal());
		buf.writeInt(kills);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		playerName = ByteBufUtils.readUTF8String(buf);
		killstreak = ItemKillstreakKit.Killstreak.values()[buf.readInt()];
		kills = buf.readInt();
	}

	@Override
	public String getMessage() {
		String playerName = formatText(EnumChatFormatting.GREEN, this.playerName);
		String killstreak = formatText(EnumChatFormatting.GREEN, this.killstreak.getLocalisedName());
		String kills = formatText(EnumChatFormatting.GREEN, this.kills);

		return StatCollector.translateToLocalFormatted(Reference.MOD_ID + ".message.killstreak_started." + this.killstreak.name().toLowerCase(Locale.ENGLISH), playerName, killstreak, kills);
	}
}