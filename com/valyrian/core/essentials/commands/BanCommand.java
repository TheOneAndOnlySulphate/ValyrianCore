package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.ban")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "§cPlease use /ban <player> [reason]");
				
				return true;
				
			} else if (args.length == 1) {
				
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if (target != null) {
					
					if (!target.hasPermission("vc.ban.exempt")) {
						
						target.setBanned(true);
						
						target.kickPlayer("§cYou have been banned by a staff member.");
						
						Bukkit.broadcastMessage(prefix + "§b" + target.getDisplayName() + " §ahas been banned for: §cYou have .");
						
						return true;
						
					} else {
						
						p.sendMessage(prefix + "§cThis player can not be banned.");
						
						return true;
						
					}
					
				} else {
					
					p.sendMessage(prefix + "§cThe player is not online or does not exist.");
					
					return true;
					
				}
				
			} else if (args.length >= 2) {
				
				String message = "";
				
				for (int i = 1; i < args.length; i++) {
					
					message += args[i] + " ";
					
				}
				
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if (target != null) {
					
					if (!target.hasPermission("vc.ban.exempt")) {
						
						target.setBanned(true);
						
						target.kickPlayer(message);
						
						Bukkit.broadcastMessage(prefix + "§b" + target.getDisplayName() + " §ahas been banned for: " + message);
						
						return true;
						
					} else {
						
						p.sendMessage(prefix + "§cThis player can not be banned.");
						
						return true;
						
					}
					
				} else {
					
					p.sendMessage(prefix + "§cThe player is not online or does not exist.");
					
					return true;
					
				}
				
			}
			
		}
		
		return true;
		
	}

}
