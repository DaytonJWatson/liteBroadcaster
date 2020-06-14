package me.dayton.AutoBroadcaster;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.dayton.AutoBroadcaster.Config.ConfigUtil;

public class Broadcaster {
	Plugin plugin = Main.getInstance();
	
	public void broadcast() {
		if(ConfigUtil.getBroadcasterEnabled() == true) {
			new BukkitRunnable() {
				List<String> messages = ConfigUtil.getBroadcasterMessages();
				String prefix = ConfigUtil.getBroadcasterPrefix();
				int progress = 0;

				@Override
				public void run() {
					if (progress == messages.size()) {
						progress = 0;
					}
					if (progress < (messages.size() + 1)) {
						if(ConfigUtil.getBroadcasterPrefixEnabled() == true) {
							Bukkit.broadcastMessage(Utils.chat(prefix + messages.get(progress)));
							progress++;
						} else {
							Bukkit.broadcastMessage(Utils.chat(messages.get(progress)));
							progress++;	
						}
					} else {
						progress = 0;
					}
				}
			}.runTaskTimer(plugin,  0, ConfigUtil.getBroadcasterInterval());
		}
	}
}