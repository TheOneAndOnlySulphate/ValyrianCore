package com.valyrian.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;


public class HealCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String msg = ChatColor.GOLD + "You have been healed.";
		String smsg = ChatColor.GOLD + "Healed.";
		String allheal = ChatColor.GREEN + "All heal!";
		if (!p.hasPermission("vc.heal"))
			return false;
		
		if(args.length == 0) {
			p.setHealth(p.getMaxHealth());
			p.sendMessage(msg);
		} else if (args.length == 1) {
			if (p.hasPermission("vc.heal.others")) {
				if (args[0].equals("all")) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setHealth(player.getMaxHealth());
						player.sendMessage(allheal + " " + msg);
					}
				} else {
					Player target = Bukkit.getPlayer(args[0]);
					target.setHealth(target.getMaxHealth());
					target.sendMessage(msg);
					p.sendMessage(smsg);
				}
			}
		}
		
		
		return true;
	}

}
