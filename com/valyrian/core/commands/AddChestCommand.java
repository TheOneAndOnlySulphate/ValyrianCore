package com.valyrian.core.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddChestCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String prefix = "§7[§bValyrian§7] §a";
		
		if (!(sender instanceof Player)) {		
			
			sender.sendMessage(prefix + "§cOnly a player can run this command!");
			return true;
			
		}
		
		Player s = (Player) sender;
		
		if (args.length < 1 || args.length > 1) {
			
			s.sendMessage(prefix + "§cWrong arguments!");
			s.sendMessage(prefix + "§cUsage: §a/addchest <type>");
			
			return true;
			
		}
		
		else if (args.length == 1) {
			
			List<String> chests = Arrays.asList("legendary", "ultrarare", "superrare", "rare", "uncommon", "common");
			
			if (!(chests.contains(args[0]))) {
				
				s.sendMessage(prefix + "§cInvalid chest!");
				return true;
				
			}
			
			if (args[0].equalsIgnoreCase("legendary")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§d§kO§r§b§lLEGENDARY CHEST§d§kO§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You added a §d§kO§r§b§lLEGENDARY CHEST§d§kO§r§a!");
				
				return true;
				
			}
			
			else if (args[0].equalsIgnoreCase("ultrarare")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§c§l§oUltra Rare Chest§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You added an §c§l§oUltra Rare Chest§r§a!");
				
				return true;
				
			}
			
			else if (args[0].equalsIgnoreCase("superrare")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§6§lSuper Rare Chest§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You add a §6§lSuper Rare Chest§r§a!");
				
				return true;
				
			}
			
			else if (args[0].equalsIgnoreCase("rare")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§eRare Chest§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You added a §eRare Chest§r§a!");
				
				return true;
				
			}
			
			else if (args[0].equalsIgnoreCase("uncommon")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§3Uncommon Chest§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You added an §3Uncommon Chest§r§a!");
				
				return true;
				
			}
			
			else if (args[0].equalsIgnoreCase("common")) {
				
				Inventory inv = s.getInventory();
				ItemStack chest = new ItemStack(Material.CHEST, 1);
				ItemMeta meta = chest.getItemMeta();
				meta.setDisplayName("§7Common Chest§r");
				List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
				meta.setLore(lore);
				chest.setItemMeta(meta);
				inv.addItem(chest);
				s.updateInventory();
				
				s.sendMessage(prefix + "You added a §7Common Chest§r§a!");
				
				return true;
				
			}
			
		}
		return true;
		
	}

}
