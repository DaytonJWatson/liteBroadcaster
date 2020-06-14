package me.dayton.AutoBroadcaster;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.dayton.AutoBroadcaster.Commands.BroadcasterCMD;
import me.dayton.AutoBroadcaster.Config.Config;
import me.dayton.AutoBroadcaster.Events.CheckPlayerList;

public class Main extends JavaPlugin {
	private static Main instance;
	
	public void onEnable() {
		instance = this;
		
		Config c = new Config(this);
		c.createConfig();
		
		loadCommands();
		loadEvents();
		broadcaster();
	}
	
	public void onDisable() {
		
	}
	
	public void loadCommands() {
		getCommand("broadcaster").setExecutor(new BroadcasterCMD());
	}
	
	public void loadEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new CheckPlayerList(), this);
	}
	
	public void broadcaster() {
		Broadcaster broadcaster = new Broadcaster();
		broadcaster.broadcast();
	}
	
	public static FileConfiguration getConfiguration() {
		return getInstance().getConfig();
	}
	
	public static Main getInstance() {
		return instance;
	}
}