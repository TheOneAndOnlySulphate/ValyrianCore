package com.valyrian.core.essentials.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		World w = p.getWorld();
		
		if (!p.hasPermission("vc.weather")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "§cPlease use /weather <sun/storm/thunder>");
				
			} else if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("storm")) {
					
					w.setStorm(true);
					
					p.sendMessage(prefix + "Weather has been set to stormy.");
					
					return true;
					
				} else if (args[0].equalsIgnoreCase("thunder")) {
					
					w.setThundering(true);
					
					p.sendMessage(prefix + "Weather has been set to thunder.");
					
					return true;
					
				} else if (args[0].equalsIgnoreCase("sun")) {
					
					w.setStorm(false);
					w.setThundering(false);
					
					p.sendMessage(prefix + "Weather has been set to sunny.");
					
					return true;
					
				} else {
					
					p.sendMessage(prefix + "§cYou do not have permissions to do this!");
					
					return true;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
}
