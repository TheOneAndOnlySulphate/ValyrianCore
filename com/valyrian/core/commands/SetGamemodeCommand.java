package com.valyrian.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (args.length == 0) {
			return false;
		}
		if ((p.hasPermission("vc.gamemode") || p.isOp())) {
			/*
			 * \  /gm <gamemode> <player>
			 * \  /gm <gamemode>
			 * \  /gamemode <gamemode> <player>
			 * \  /gamemode <gamemode> 
			 */
			if (args.length == 2 && (p.hasPermission("vc.gamemode.others") || p.isOp())) {
				//If they have the permission or are op
				Player target = Bukkit.getPlayer(args[1]);
				
				if (args[0].equals("s") || args[0].equals("Survival") || args[0].equals("0")) {
					
					target.setGameMode(GameMode.SURVIVAL);
					target.sendMessage(ChatColor.GREEN + "Gamemode changed to Survival by " + p.getName() + "!");
					p.sendMessage(ChatColor.GREEN + target.getName() + "'s Gamemode was changed to Survival.");
					
					return true;
				}  else if (args[0].equals("c") || args[0].equals("Creative") || args[0].equals("1")) {
					
					target.setGameMode(GameMode.CREATIVE);
					target.sendMessage(ChatColor.GREEN + "Gamemode changed to Creative by " + p.getName() + "!");
					p.sendMessage(ChatColor.GREEN + target.getName() + "'s Gamemode was changed to Creative.");
					
					return true;
				} else if (args[0].equals("a") || args[0].equals("Adventure") || args[0].equals("2")) {
					
					target.setGameMode(GameMode.ADVENTURE);
					target.sendMessage(ChatColor.GREEN + "Gamemode changed to Adventure by " + p.getName() + "!");
					p.sendMessage(ChatColor.GREEN + target.getName() + "'s Gamemode was changed to Adventure.");
					
					return true;
				} else if (args[0].equals("sp") || args[0].equals("Spectator") || args[0].equals("3")) {
					
					try {
						
						target.setGameMode(GameMode.getByValue(3));
						target.sendMessage(ChatColor.GREEN + "Gamemode changed to Spectator by " + p.getName() + "!");
						p.sendMessage(ChatColor.GREEN + target.getName() + "'s Gamemode was changed to Spectator.");
						
						return true;
					} catch (Exception err) {
						
						p.sendMessage(ChatColor.RED + "Spectator mode is not currently supported.");
						return true;
					
					}
					
				} else {
					
					p.sendMessage(ChatColor.RED + "Correct usage: /gamemode <gamemode> <player>");
					return true;
				
				}
				
			} else {
				//If they have the permission or are op
				if (args[0].equals("s") || args[0].equals("Survival") || args[0].equals("0")) {
					
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColor.GREEN + "Gamemode changed to Survival!");
					
					return true;
				}  else if (args[0].equals("c") || args[0].equals("Creative") || args[0].equals("1")) {
					
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColor.GREEN + "Gamemode changed to Creative!");
					
					return true;
				} else if (args[0].equals("a") || args[0].equals("Adventure") || args[0].equals("2")) {
					
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(ChatColor.GREEN + "Gamemode changed to Adventure!");
					
					return true;
				} else if (args[0].equals("sp") || args[0].equals("Spectator") || args[0].equals("3")) {
					
					try {
					
						p.setGameMode(GameMode.getByValue(3));
						p.sendMessage(ChatColor.GREEN + "Gamemode changed to Spectator!");
						
						return true;
					
					} catch (Exception err) {
						
						p.sendMessage(ChatColor.RED + "Spectator mode is not currently supported.");
						return true;
					
					}
					
				} else {
					p.sendMessage(ChatColor.RED + "Correct usage: /gamemode <gamemode>");
					return true;
				}
				
				
			}
		}
		
	return false;
	}

}
