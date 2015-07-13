package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.valyrian.core.essentials.utils.GetOfflineEC;
import com.valyrian.core.essentials.utils.GetOnlineEC;

public class EnderChestCommand implements CommandExecutor {
	
	GetOfflineEC g = new GetOfflineEC();
	GetOnlineEC g1 = new GetOnlineEC();
	
	@SuppressWarnings("deprecation")
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
						
						p.openInventory(g1.getOnlineEnderChest(p));
						
					} else {
						
						p.openInventory(g.getOfflineEnderChest(p.getName()));
						
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

