package com.valyrian.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (p.hasPermission("vc.fly") || p.isOp()) {
			//opxe = Other Prefix Enabled
			final String opxe = ChatColor.GREEN + "Fly mode enabled "; 
			final String opxd = ChatColor.RED + "Fly mode disabled "; 
			// /fly vc.fly
			// /fly <player>  vc.fly.others
			// /fly ?    (Can I fly) vc.fly 
			// /fly ? <player> (Can they fly) vc.fly.others
			// /fly enable vc.fly
			// /fly disable vc.fly
			// /fly enable <player> vc.fly.others
			// /fly disable <player> vc.fly.others
			if((p.hasPermission("vc.fly.others") || p.isOp()) && args.length == 2) {
				
				if (args[0].equals("enable")) {
					
					Player target = (Player) Bukkit.getPlayer(args[1]);
					target.setAllowFlight(true);
					target.setFlying(true);
					target.sendMessage(opxe + "by " + p.getName());
					p.sendMessage(opxe + "for " + target.getName());
					
					return true;
					
				} else if (args[0].equals("disable")) {
					
					Player target = (Player) Bukkit.getPlayer(args[1]);
					target.setAllowFlight(false);
					target.setFlying(false);
					target.sendMessage(opxd + "by " + p.getName());
					p.sendMessage(opxd + "for " + target.getName());
					
					return true;
					
				} else if (args[0].equals("?")) {
					
					Player target = (Player) Bukkit.getPlayer(args[1]);
					
					if (target.getAllowFlight() == true) {
						p.sendMessage(ChatColor.GRAY + target.getName() + " can fly.");
						return true;
					} else {
						p.sendMessage(ChatColor.GRAY + target.getName() + " can't fly.");
						return true;
					}
				
				} else {
					return false;
				}
			} else if (args.length == 1) {
				
				if (args[0].equals("enable")) {
					
					p.sendMessage(opxe);
					p.setAllowFlight(true);
					p.setFlying(true);
					return true;
					
				} else if (args[0].equals("disable")) {
					
					p.sendMessage(opxd);
					p.setAllowFlight(false);
					p.setFlying(false);
					return true;
					
				} else if(args[0].equals("?")) { 
					
					if (p.getAllowFlight() == true) {
						p.sendMessage(ChatColor.GRAY + "You can fly.");
					} else {
						p.sendMessage(ChatColor.GRAY + "You can't fly.");
					}
					
					return true;
					
				} else {
					
					return false;
					
				}
				
				
			} else if (args.length == 0) {
				if (p.getAllowFlight() == false) {
					p.setAllowFlight(true);
					p.sendMessage(opxe);
					p.setFlying(true);
					return true;
				} else {
					p.setAllowFlight(false);
					p.sendMessage(opxd);
					p.setFlying(false);
					return true;
				}
			} else {
				return false;
			}

		}

		
		
		return false;
	}

	
	
}
