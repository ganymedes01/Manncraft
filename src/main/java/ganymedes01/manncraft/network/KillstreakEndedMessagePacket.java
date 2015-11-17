package ganymedes01.manncraft.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import ganymedes01.manncraft.lib.Reference;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class KillstreakEndedMessagePacket extends ChatMessagePacket {

	private String playerName;
	private int kills;

	public KillstreakEndedMessagePacket() {
	}

	public KillstreakEndedMessagePacket(String playerName, int kills) {
		this.playerName = playerName;
		this.kills = kills;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, playerName);
		buf.writeInt(kills);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		playerName = ByteBufUtils.readUTF8String(buf);
		kills = buf.readInt();
	}

	@Override
	public String getMessage() {
		return StatCollector.translateToLocalFormatted(Reference.MOD_ID + ".message.killstreak_ended", formatText(EnumChatFormatting.GREEN, playerName), formatText(EnumChatFormatting.GREEN, kills));
	}
}