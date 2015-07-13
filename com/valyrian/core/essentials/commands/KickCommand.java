package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.kick")) {
			
			p.sendMessage(prefix + "§You do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "§cPlease use /kick <targetPlayer>");
				
				return true;
				
			} else if (args.length == 1) {
				
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if (target != null) {
					
					if (!target.hasPermission("vc.kick.exempt")) {
						
						target.kickPlayer("Kicked from the server.");
						
						Bukkit.broadcastMessage(prefix + "§b" + target.getDisplayName() + " §ahas been kicked for: Kicked from the server.");
						
						return true;
						
					} else {
						
						p.sendMessage(prefix + "§cThis player can not be kicked.");
						
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
					
					if (!target.hasPermission("vc.kick.exempt")) {
						
						target.kickPlayer(message);
						
						Bukkit.broadcastMessage(prefix + "§b" + target.getDisplayName() + " §ahas been kicked for: " + message);
						
						return true;
						
					} else {
						
						p.sendMessage(prefix + "§cThis player can not be kicked.");
						
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
