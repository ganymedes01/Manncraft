package ganymedes01.manncraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.util.EnumChatFormatting;

public abstract class ChatMessagePacket implements IMessage {

	public ChatMessagePacket() {
	}

	public abstract String getMessage();

	protected String formatText(EnumChatFormatting format, Object txt) {
		return format + txt.toString() + EnumChatFormatting.RESET;
	}
}