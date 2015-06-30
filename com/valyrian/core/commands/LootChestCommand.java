package com.valyrian.core.commands;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.valyrian.core.main.MainClass;

public class LootChestCommand implements CommandExecutor {

	private MainClass plugin = MainClass.get();

	public boolean onCommand(CommandSender sender, Command cmd, String c, String[] args) {
		Player p = (Player) sender;

		String prefix = "§7[§bValyrian§7] §a";

		if (!(p.hasPermission("lootchest.admin"))) {
			
			p.sendMessage(prefix + "You do not have permission to modify LootChests!");
			
			return true;
			
		}
		
		else {

			if (args.length == 0) {

				p.sendMessage(prefix + "Type §c/chestloot help for a list of commands");
				
				return true;

			} else if (args.length == 1) {

				if (args[0].equalsIgnoreCase("help")) {

					p.sendMessage("/lootchest create - Sets a chest for loot");
					p.sendMessage("/lootchest delete - Removes a chest for loot");
					
					return true;

				} else if (args[0].equalsIgnoreCase("create")) {

					if (getSelectedBlock(p).getType().equals(Material.CHEST)) {

						plugin.getConfig().set("Chest.X", getSelectedBlock(p).getX());
						plugin.getConfig().set("Chest.Y", getSelectedBlock(p).getY());
						plugin.getConfig().set("Chest.Z", getSelectedBlock(p).getZ());

						plugin.saveConfig();

						p.sendMessage(prefix + "LootChest created.");
						
						return true;

					} else {

						p.sendMessage(prefix + "§cThe target block is not a chest");
						
						return true;

					}

				} else if (args[0].equalsIgnoreCase("delete")) {
								
						plugin.getConfig().set("Chest.X", null);
						plugin.getConfig().set("Chest.Y", null);
						plugin.getConfig().set("Chest.Z", null);
								
						plugin.saveConfig();
								
						p.sendMessage(prefix + "LootChest deleted.");
							
						return true;

				}

			}

		}

	return false;

}

	@SuppressWarnings("deprecation")
	public Block getSelectedBlock(Player p) {

		Block b = p.getTargetBlock((HashSet<Byte>) null, 100);

		return b;

	}

}