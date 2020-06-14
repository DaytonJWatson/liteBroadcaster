package me.dayton.AutoBroadcaster.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import me.dayton.AutoBroadcaster.Main;
import me.dayton.AutoBroadcaster.Utils;

public class BroadcasterCMD implements CommandExecutor {
	public static PluginDescriptionFile pdfFile = Main.getInstance().getDescription();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("broadcaster")) {
			if(args.length == 0) {
				p.sendMessage(Utils.chat("&8+&7================== &6liteBroadcaster &7==================&8+"));
				p.sendMessage("");
				p.sendMessage(Utils.chat("     &7Name&8: &6" + pdfFile.getName()));
				p.sendMessage(Utils.chat("     &7Author&8: &6" + pdfFile.getAuthors()));
				p.sendMessage(Utils.chat("     &7Version&8: &6" + pdfFile.getVersion()));
				p.sendMessage(Utils.chat("     &7Description&8: &6" + pdfFile.getDescription()));
				p.sendMessage("");
				p.sendMessage(Utils.chat("&8+&7===================================================&8+"));
			}
		}
		return false;
	}
}