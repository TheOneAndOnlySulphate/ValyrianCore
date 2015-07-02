package com.valyrian.core.listeners;

import java.util.Random;

import org.bukkit.Material;
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
	
	@EventHandler
	public void onEvent(PlayerInteractEvent e) {
		
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			Player p = e.getPlayer();
			Inventory inv = p.getInventory();
			ItemStack item = p.getItemInHand();
			ItemMeta itemmeta = item.getItemMeta();
			
			if (item.getType().equals(Material.CHEST)) {
				
				if (itemmeta.getDisplayName().equalsIgnoreCase("§d§kO§r§b§lLEGENDARY CHEST§d§kO§r")) {
					openLegendaryChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§c§l§oUltra Rare Chest§r")) {
					openUltraRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§6§lSuper Rare Chest§r")) {
					openSuperRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§eRare Chest§r")) {
					openRareChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§3Uncommon Chest§r")) {
					openUncommonChest(inv, p);
					return;
				}
				
				else if (itemmeta.getDisplayName().equalsIgnoreCase("§7Common Chest§r")) {
					openCommonChest(inv, p);
					return;
				}
			}
		}	
	}
	
	public void openLegendaryChest(Inventory i, Player p) {
		
		int item = r.nextInt(1000) + 1;
		
		if (item <= 10) {
			
			ItemStack dhelm = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta dhmeta = dhelm.getItemMeta();
			dhmeta.setDisplayName("§d§kO§r§b§lLEGENDARY HELMET§d§kO§r");
			List<String> dhlore = Arrays.asList("§cThis is the helmet of the Gods. Only", "a few have ever worn it.");
			dhmeta.setLore(dhlore);
			dhelm.setItemMeta(dhmeta);
			dhelm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			dhelm.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			dhelm.addEnchantment(Enchantment.PROTECION_EXPLOSIONS, 3);
			dhelm.addEnchantment(Enchantment.PROTECTION_PROJECTILES, 3);
			dhelm.addEnchantment(Enchantment.THORNS, 2);
			dhelm.addEnchantment(Enchantment.WATER_WORKER, 2);
			
			i.addItem(dhelm);
			p.updateInventory();
			
			p.sendMessage("PREFIX + You recieved a §d§kO§r§b§lLEGENDARY HELMET§d§kO§r§a! Congratulations!")
			
			return;
			
		}
		
		else if (item <= 20) {
			
			ItemStack dchest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta dcmeta = dchest.getItemMeta();
			dcmeta.setDisplayName("§d§kO§r§b§lLEGENDARY CHESTPLATE§d§kO§r");
			List<String> dclore = Arrays.asList("§This chestplate was forged by the Gods", "§cthemselves. Only the chosen can", "§cever hope to wear it.");
			dcmeta.setLore(dclore);
			dchest.setItemMeta(dcmeta);
			//TODO: Add Enchants
			
			i.addItem(dchest);
			p.updateInventory();
			
			p.sendMessage("PREFIX + You recieved a §d§kO§r§b§lLEGENDARY CHESTPLATE§d§kO§r§a! Congratulations!");
			
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
