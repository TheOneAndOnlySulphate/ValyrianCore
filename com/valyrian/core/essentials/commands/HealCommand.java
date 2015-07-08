package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;


public class HealCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.heal")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.setHealth(p.getMaxHealth());
				
				p.sendMessage(prefix + "You have been healed.");
				
				return true;
				
			} else if (args.length == 1) {
				
				if (!p.hasPermission("vc.heal.others")) {

					p.sendMessage(prefix + "You do not have permissions to do this!");

					return true;

				} else {
						
					if (args[0].equalsIgnoreCase("all")) {
						
						for (Player player : Bukkit.getOnlinePlayers()) {
							
							player.setHealth(player.getMaxHealth());
							
							player.sendMessage(prefix + "You have been healed by §b" + p.getDisplayName() + "§a.");
							
						}
						
						p.sendMessage(prefix + "You have healed everyone on the server.");
						
					} else {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (target != null) {
							
							target.setHealth(target.getMaxHealth());
							
							target.sendMessage(prefix + "You have been healed by §b" + p.getDisplayName() + "§a.");
						
							p.sendMessage(prefix + "You have healed §b" + target.getDisplayName() + "§a.");
						
						}
						
					}
					
				}
			
			}
		
		}
		
		return true;
	}
}
