package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.fly")) {
			
			p.sendMessage("§4You do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				if (p.getAllowFlight()) {
				
					p.setAllowFlight(!p.getAllowFlight());
					
					p.sendMessage(prefix + "Your flight mode has been disabled.");
					
					return true;
				
				} else {
					
					p.setAllowFlight(!p.getAllowFlight());
					
					p.sendMessage(prefix + "Your flight mode has been enabled.");
					
					return true;
					
				}
				
			} else if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("?")) {
					
					if (p.getAllowFlight()) {
					
						p.sendMessage(prefix + "Your flight mode is enabled.");
						
						return true;
					
					} else {
						
						p.sendMessage(prefix + "Your flight mode is disabled.");
						
						return true;
						
					}
					
				} else {
					
					if (!p.hasPermission("vc.fly.others")) {
						
						p.sendMessage("§4You do not have permissions to do this!");
						
						return true;
						
					} else {
					
						Player target = (Player) Bukkit.getPlayer(args[0]);
						
						if (target.getAllowFlight()) {
							
							target.setAllowFlight(!target.getAllowFlight());
							
							p.sendMessage(prefix + "You have disabled flight for §b" + target.getDisplayName() + "§a.");
							
							return true;
							
						} else {
							
							target.setAllowFlight(!target.getAllowFlight());
							
							p.sendMessage(prefix + "You have enabled flight for §b" + target.getDisplayName() + "§a.");
							
							return true;
							
						}
					
					}
					
				}
				
			} else if (args.length == 2) {
				
				if (!p.hasPermission("vc.fly.others")) {
					
					p.sendMessage("§4You do not have permissions to do this!");
					
					return true;
					
				} else {
				
					if (args[0].equalsIgnoreCase("?")) {
						
						Player target = (Player) Bukkit.getPlayer(args[1]);
						
						if (target.getAllowFlight()) {
						
							p.sendMessage(prefix + "§b" + target.getDisplayName() + "'s §aflight mode is enabled.");
							
							return true;
							
						} else {
							
							p.sendMessage(prefix + "§b" + target.getDisplayName() + "'s §aflight mode is disabled.");
							
							return true;
							
						}
						
					} else {
						
						p.sendMessage(prefix + "§Please use /fly ? <targetPlayer>");
						
						return true;
						
					}
				
				}
				
			}
			
		}

		return true;

	}

}
