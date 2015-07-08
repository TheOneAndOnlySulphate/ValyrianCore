package com.valyrian.core.essentials.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {
	
	String prefix = "§7[§bValyrian§7] §a";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		World w = p.getWorld();
		
		if (!p.hasPermission("vc.time")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "§cPlease use /time <set/day/night> <setAmount>");
				
				return true;
				
			} else if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("set")) {
					
					p.sendMessage(prefix + "§cPlease use /time <set/day/night> <setAmount>");
					
					return true;
					
				} else if (args[0].equalsIgnoreCase("day")) {
					
					w.setTime(0);
					
					p.sendMessage(prefix + "Time has been set to day.");
					
					return true;
					
				} else if (args[0].equalsIgnoreCase("night")) {
					
					w.setTime(13000);
					
					p.sendMessage(prefix + "Time has been set to night.");
					
					return true;
					
				} else {
					
					p.sendMessage(prefix + "§cPlease use /time <set/day/night> <setAmount>");
					
					return true;
					
				}
				
			} else if (args.length == 2) {
				
				if (args[0].equalsIgnoreCase("set")) {
					
					int ticks = Integer.parseInt(args[1]);
					
					w.setTime(ticks);
					
					p.sendMessage(prefix + "Time has been set to §b" + ticks + " ticks.");
					
					return true;
					
				} else {
					
					p.sendMessage(prefix + "§cPlease use /time <set/day/night> <setAmount>");
					
					return true;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
}
