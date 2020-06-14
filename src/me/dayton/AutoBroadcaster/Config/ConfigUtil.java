package me.dayton.AutoBroadcaster.Config;

import java.util.List;

import me.dayton.AutoBroadcaster.Main;
import me.dayton.AutoBroadcaster.Utils;

public class ConfigUtil {
	public static boolean getBroadcasterEnabled() {
		return Main.getConfiguration().getBoolean("liteBroadcaster-settings.enabled");
	}
	
	public static List<String> getBroadcasterMessages() {
		return Main.getConfiguration().getStringList("message-list");
	}
	
	public static long getBroadcasterInterval() {
		return Main.getConfiguration().getLong("liteBroadcaster-settings.interval");
	}
	
	public static String getBroadcasterPrefix() {
		return Utils.chat(Main.getConfiguration().getString("liteBroadcaster-settings.prefix"));
	}
	
	public static boolean getBroadcasterPrefixEnabled() {
		return Main.getConfiguration().getBoolean("liteBroadcaster-settings.prefix-enabled");
	}
}
