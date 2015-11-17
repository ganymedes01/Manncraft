package ganymedes01.manncraft.handler;

import java.util.Map;
import java.util.WeakHashMap;

import ganymedes01.manncraft.items.ItemKillstreakKit;
import ganymedes01.manncraft.network.KillstreakEndedMessagePacket;
import ganymedes01.manncraft.network.KillstreakStartedMessagePacket;
import net.minecraft.entity.player.EntityPlayer;

public class KillstreakHandler {

	public static final KillstreakHandler INSTANCE = new KillstreakHandler();

	private Map<EntityPlayer, Integer> map = new WeakHashMap<EntityPlayer, Integer>();

	private KillstreakHandler() {
	}

	public void onPlayerDeath(EntityPlayer player) {
		if (map.containsKey(player)) {
			Integer killstreak = map.remove(player);
			if (killstreak != null && killstreak >= ItemKillstreakKit.KILLSTREAK_STEP)
				AnnouncementsHandler.INSTANCE.sendMessageToAll(new KillstreakEndedMessagePacket(player.getCommandSenderName(), killstreak));
		}
	}

	public void onPlayerKill(EntityPlayer player) {
		Integer killstreak = map.get(player);
		if (killstreak != null) {
			killstreak++;
			map.put(player, killstreak);

			ItemKillstreakKit.Killstreak newKS = ItemKillstreakKit.Killstreak.getKillstreak(killstreak);
			if (killstreak > 0 && killstreak % ItemKillstreakKit.KILLSTREAK_STEP == 0)
				AnnouncementsHandler.INSTANCE.sendMessageToAll(new KillstreakStartedMessagePacket(player.getCommandSenderName(), newKS, killstreak));
		} else
			map.put(player, 1);
	}
}