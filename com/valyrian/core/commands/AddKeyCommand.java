package com.valyrian.core.commands;

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
			int amount = Integer.parseInt(args[0]);
			Inventory inv = s.getInventory();
			
			ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK, amount);
			ItemMeta keym = key.getItemMeta();
			keym.setDisplayName("§a§lLootChest Key");
			key.setItemMeta(keym);
			inv.addItem(key);
			
			s.sendMessage(prefix + "You added §c" + amount + " §akeys!");
			s.updateInventory();
			return true;
		}
		
		else {
			s.sendMessage(prefix + "§cIncorrect command! Usage: /addkey [amount]");
			return true;
		}
	}
}
