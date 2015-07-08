package com.valyrian.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {
	
	/*
	 * UNFINISHED
	 */
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("vc.enderchest") || p.isOp()) {
			
			if (args.length == 1) {
				if (p.hasPermission("vc.enderchest.others") || p.isOp()) {
					Player target = Bukkit.getPlayer(args[0]);
					if (!(target == null)) {
						p.openInventory(target.getEnderChest());
					} else {
						//If they are offline
					}
					return true;
				}
			} else {
				p.openInventory(p.getEnderChest());
			}
			
			
		}
		
		
		return true;
	}
	
}

