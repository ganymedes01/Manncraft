package ganymedes01.manncraft.handler;

import ganymedes01.manncraft.Manncraft;
import ganymedes01.manncraft.network.ChatMessagePacket;

public class AnnouncementsHandler {

	public static final AnnouncementsHandler INSTANCE = new AnnouncementsHandler();

	private AnnouncementsHandler() {
	}

	public void sendMessageToAll(ChatMessagePacket message) {
		Manncraft.networkWrapper.sendToAll(message);
	}
}