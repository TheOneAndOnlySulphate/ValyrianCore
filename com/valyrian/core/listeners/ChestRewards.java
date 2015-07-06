package com.valyrian.core.listeners;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChestRewards implements Listener {
	
	Random r = new Random();
	String prefix = "§7[§bValyrian§7] §a";
	
	@EventHandler
	public void onEvent(PlayerInteractEvent e) {
		
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			Player p = e.getPlayer();
			Inventory inv = p.getInventory();
			ItemStack item = p.getItemInHand();
			ItemMeta itemmeta = item.getItemMeta();
			
			if (item.getType().equals(Material.CHEST)) {
				
				if (itemmeta.getDisplayName().equalsIgnoreCase("§d§kO§r§b§lLEGENDARY CHEST§d§kO§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openLegendaryChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§c§l§oUltra Rare Chest§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openUltraRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§6§lSuper Rare Chest§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openSuperRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§eRare Chest§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§3Uncommon Chest§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openUncommonChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§7Common Chest§r")) {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					}
					else {
						inv.remove(item);
					}
					openCommonChest(inv, p);
					return;
				}
			}
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void openLegendaryChest(Inventory i, Player p) {
		
		int item = r.nextInt(1000) + 1;
		
		if (item <= 10) { //Diamond Helmet
			
			ItemStack dhelm = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta dhmeta = dhelm.getItemMeta();
			dhmeta.setDisplayName("§d§kO§r§b§lLEGENDARY HELMET§d§kO§r");
			List<String> dhlore = Arrays.asList("§cThis helmet was forged by the Gods", "§cthemselves. Only the chosen can", "§cever hope to wear it");
			dhmeta.setLore(dhlore);
			dhelm.setItemMeta(dhmeta);
			dhelm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			dhelm.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			dhelm.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			dhelm.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
			dhelm.addEnchantment(Enchantment.WATER_WORKER, 2);
			
			i.addItem(dhelm);
			p.updateInventory();
			
			p.sendMessage(prefix + "You recieved a §d§kO§r§b§lLEGENDARY HELMET§d§kO§r§a! Congratulations!");
			
			return;
			
		}
		
		else if (item <= 20) { //Diamond Chestplate
			
			ItemStack dchest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta dcmeta = dchest.getItemMeta();
			dcmeta.setDisplayName("§d§kO§r§b§lLEGENDARY CHESTPLATE§d§kO§r");
			List<String> dclore = Arrays.asList("§cThis chestplate was forged by the Gods", "§cthemselves. Only the chosen can", "§cever hope to wear it.");
			dcmeta.setLore(dclore);
			dchest.setItemMeta(dcmeta);
			dchest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			dchest.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			dchest.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			dchest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
			dchest.addEnchantment(Enchantment.THORNS, 2);
			
			i.addItem(dchest);
			p.updateInventory();
			
			p.sendMessage(prefix + "You recieved a §d§kO§r§b§lLEGENDARY CHESTPLATE§d§kO§r§a! Congratulations!");
			
			return;
			
		}
		
		else if (item <= 30) { //Diamond Leggings
			
			String itemname = "§d§kO§b§lLEGENDARY LEGGINGS§d§kO§r";
			ItemStack dlegs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			ItemMeta dlmeta = dlegs.getItemMeta();
			dlmeta.setDisplayName(itemname);
			List<String> dllore = Arrays.asList("§cThese leggings were forged by the Gods", "§cthemselves. Only the chosen can ever", "§chope to wear them.");
			dlmeta.setLore(dllore);
			dlegs.setItemMeta(dlmeta);
			dlegs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			dlegs.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			dlegs.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			dlegs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
			dlegs.addEnchantment(Enchantment.THORNS, 2);
			
			i.addItem(dlegs);
			p.updateInventory();
			
			p.sendMessage(prefix + "You recieved " + itemname + "§a! Congratulations!");
			
			return;
			
		}
		
	}
	
	public void openUltraRareChest(Inventory i, Player p) {
		
	}
	
	public void openSuperRareChest(Inventory i, Player p) {
		
	}
	
	public void openRareChest(Inventory i, Player p) {
		
	}
	
	public void openUncommonChest(Inventory i, Player p) {
		
	}
	
	public void openCommonChest(Inventory i, Player p) {
		
	}

}
