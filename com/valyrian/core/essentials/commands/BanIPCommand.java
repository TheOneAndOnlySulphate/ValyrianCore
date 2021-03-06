package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanIPCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.banip")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "§cPlease use /banip <targetPlayer>");
				
				return true;
				
			} else if (args.length == 1) {
				
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if (target != null) {
					
					Bukkit.getServer().banIP(target.getAddress().toString());
					
					target.setBanned(true);
					
					target.kickPlayer("§cYou have been IP banned.");
					
					Bukkit.broadcastMessage(prefix + "§b" + target.getDisplayName() + "§a has been IP banned.");
					
					return true;
					
				} else {
					
					p.sendMessage(prefix + "§cThe player is not online or does not exist.");
					
					return true;
					
				}
				
			}
			
		}
		
		return true;
		
	}

}
