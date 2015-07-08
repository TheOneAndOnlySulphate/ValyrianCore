package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGamemodeCommand implements CommandExecutor {

	String prefix = "§7[§bValyrian§7] §a";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (!p.hasPermission("vc.gamemode")) {
			
			p.sendMessage(prefix + "§cYou do not have permissions to do this!");
			
			return true;
			
		} else {
			
			if (args.length == 0) {
				
				p.sendMessage(prefix + "Please use §b/gamemode <s/c/a/sp> (<targetPlayer>)");
				
				return true;
				
			} else if (args.length == 1) {
				
				if (args[0].equals("s") || args[0].equals("survival") || args[0].equals("0")) {
					
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(prefix + "Gamemode changed to survival!");
					
					return true;
					
				}  else if (args[0].equals("c") || args[0].equals("creative") || args[0].equals("1")) {
					
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(prefix + "Gamemode changed to creative!");
					
					return true;
					
				} else if (args[0].equals("a") || args[0].equals("adventure") || args[0].equals("2")) {
					
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(prefix + "Gamemode changed to adventure!");
					
					return true;
					
				} else if (args[0].equals("sp") || args[0].equals("spectator") || args[0].equals("3")) {
					
					try {
					
						p.setGameMode(GameMode.getByValue(3));
						p.sendMessage(prefix+ "Gamemode changed to spectator!");
						
						return true;
					
					} catch (Exception err) {
						
						p.sendMessage(prefix + "§cSpectator mode is not currently supported.");
						
						return true;
					
					}
					
				} else {
					
					p.sendMessage(prefix + "§cPlease use /gamemode <s/c/a/sp>");
					
					return true;
					
				}
				
			} else if (args.length == 2) {
				
				if (!p.hasPermission("vc.gamemode.others")) {
					
					p.sendMessage(prefix + "§You do not have permission to do this!");
					
					return true;
					
				} else {
					
					Player target = Bukkit.getPlayer(args[1]);
					
					if (args[0].equals("s") || args[0].equals("survival") || args[0].equals("0")) {
						
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(prefix + "Gamemode changed to survival by " + p.getName() + "!");
						p.sendMessage(prefix + target.getName() + "'s Gamemode was changed to survival.");
						
						return true;
					}  else if (args[0].equals("c") || args[0].equals("creative") || args[0].equals("1")) {
						
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(prefix + "Gamemode changed to creative by " + p.getName() + "!");
						p.sendMessage(prefix + target.getName() + "'s Gamemode was changed to creative.");
						
						return true;
					} else if (args[0].equals("a") || args[0].equals("adventure") || args[0].equals("2")) {
						
						target.setGameMode(GameMode.ADVENTURE);
						target.sendMessage(prefix + "Gamemode changed to adventure by " + p.getName() + "!");
						p.sendMessage(prefix + target.getName() + "'s Gamemode was changed to adventure.");
						
						return true;
					} else if (args[0].equals("sp") || args[0].equals("spectator") || args[0].equals("3")) {
						
						try {
							
							target.setGameMode(GameMode.getByValue(3));
							target.sendMessage(prefix + "Gamemode changed to spectator by " + p.getName() + "!");
							p.sendMessage(prefix + target.getName() + "'s Gamemode was changed to spectator.");
							
							return true;
						} catch (Exception err) {
							
							p.sendMessage(prefix + "§cSpectator mode is not currently supported.");
							return true;
						
						}
						
					} else {
						
						p.sendMessage(prefix + "§cPlease use /gamemode <s/c/a/sp> <targetPlayer>");
						return true;
					
					}
					
				}
				
			}
			
		}
		
	return true;
	
	}

}
