package ganymedes01.manncraft.handler;

import java.util.Map;
import java.util.WeakHashMap;

import ganymedes01.manncraft.items.ItemKillstreakKit;
import net.minecraft.entity.player.EntityPlayer;

public class KillstreakHandler {

	public static final KillstreakHandler INSTANCE = new KillstreakHandler();

	private Map<EntityPlayer, Integer> map = new WeakHashMap<EntityPlayer, Integer>();

	private KillstreakHandler() {
	}

	public void onPlayerDeath(EntityPlayer player) {
		if (map.containsKey(player)) {
			Integer killstreak = map.remove(player);
			// TODO
			ItemKillstreakKit.Killstreak ks = ItemKillstreakKit.Killstreak.getKillstreak(killstreak);
			if (ks != null)
				AnnouncementsHandler.INSTANCE.sendMessageToAll(player.getCommandSenderName() + "'s killstreak ended");
		}
	}

	public void onPlayerKill(EntityPlayer player) {
		Integer killstreak = map.get(player);
		if (killstreak != null) {
			map.put(player, killstreak + 1);

			ItemKillstreakKit.Killstreak currentKS = ItemKillstreakKit.Killstreak.getKillstreak(killstreak);
			ItemKillstreakKit.Killstreak newKS = ItemKillstreakKit.Killstreak.getKillstreak(killstreak + 1);
			if (currentKS == null && newKS != null || currentKS != null && newKS != null && currentKS != newKS)
				AnnouncementsHandler.INSTANCE.sendMessageToAll(newKS.getAnnouncement(player.getCommandSenderName(), killstreak + 1));
		} else
			map.put(player, 1);
	}
}