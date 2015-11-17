package ganymedes01.manncraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ChatMessagePacketHandler<T extends ChatMessagePacket> implements IMessageHandler<T, IMessage> {

	@Override
	public IMessage onMessage(T message, MessageContext ctx) {
		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message.getMessage()));
		return null;
	}

	public static class StrangifierLevelUpHandler extends ChatMessagePacketHandler<StrangifierLevelUpMessagePacket> {
	}

	public static class KillstreakEndHandler extends ChatMessagePacketHandler<KillstreakEndedMessagePacket> {
	}

	public static class KillstreakStartHandler extends ChatMessagePacketHandler<KillstreakStartedMessagePacket> {
	}
}