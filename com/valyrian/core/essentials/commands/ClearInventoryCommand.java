package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventoryCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.clearinventory")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.getInventory().clear();
				
				p.sendMessage(prefix + "You have cleared your inventory");
				
				return true;
				
			} else if (args.length == 1) {
				
				Player target = (Player) Bukkit.getPlayer(args[0]);
				
				if (target != null) {
					
					target.getInventory().clear();
					
					target.sendMessage(prefix + "Your inventory has been cleared by " + "§b" + p.getDisplayName());
					
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
