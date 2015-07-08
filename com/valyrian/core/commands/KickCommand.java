package com.valyrian.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (!p.hasPermission("vc.kick"))
			return true;		
		if (args.length == 0)
			return false;
		// /kick <player> [reason]
		Player target = Bukkit.getPlayer(args[0]);
		//You can remove override if you don't want it, I just thought it would be a good idea
		if (target.hasPermission("vc.kick.ignore") && (!p.hasPermission("vc.kick.override"))) {
			p.sendMessage(ChatColor.DARK_RED + "You cannot kick this person.");
			return true;
		}
		String reason = (args.length >= 2) ? fixString(args) : "You were kicked from the server.";
		
		target.kickPlayer(reason);
		
		
		
		return true;
	}
	
	private String fixString(String[] args) {
		int count = 0;
		String fin = "";
		for (String s : args) {
			if (count == 0 || count == 1) {
				continue;
			} else {
				fin+= args[count] + " ";
			}
			count++;
		}
		
		
		return fin;
	}
	
}
