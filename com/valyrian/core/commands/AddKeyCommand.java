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

public class AddKeyCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String prefix = "§7[§bValyrian§7] §a";
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(prefix + "§cOnly a player can run that command!");
			return true;
		}
		
		Player s = (Player) sender;
		
		if (!(s.hasPermission("vc.lootchest.addkey"))) {
			s.sendMessage(prefix + "§cYou do not have permission to add a key!");
			return true;
		}
		
		if (args.length == 0) {
			Inventory inv = s.getInventory();
			
			ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK, 1);
			ItemMeta keymeta = key.getItemMeta();
			keymeta.setDisplayName("§a§lLootChest Key");
			key.setItemMeta(keymeta);
			
			inv.addItem(key);
			
			s.sendMessage(prefix + "You successfully added a key!");
			return true;
		}
		
		else if (args.length == 1) {
			List<String> numbers = Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
			if (!(numbers.contains(args[0]))) {
				s.sendMessage(prefix + "§cYou can add a maximum of 20 keys. It has to be a number, not a letter or word.");
				return true;
			}
			Inventory inv = s.getInventory();
			
			ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK);
			ItemMeta keym = key.getItemMeta();
			keym.setDisplayName("§a§lLootChest Key");
			key.setItemMeta(keym);
			for (int i = 0; i < Integer.parseInt(args[0]); i++) {
				inv.addItem(key);
			}
			s.updateInventory();
			return true;
		}
		
		else {
			s.sendMessage(prefix + "§cIncorrect command! Usage: /addkey [amount]");
			return true;
		}
	}
}
