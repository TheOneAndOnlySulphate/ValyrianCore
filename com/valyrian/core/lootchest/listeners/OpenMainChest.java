package com.valyrian.core.lootchest.listeners;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.valyrian.core.main.MainClass;

public class OpenMainChest implements Listener {
	
	Random r = new Random();
	String prefix = "§7[§bValyrian§7] §a";
	
	private boolean isChest() {
		int i = r.nextInt(2);
		if (i == 0) {
			return false;
		}
		else if (i == 1) {
			return true;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEvent(PlayerInteractEvent e) {
		
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			if (!MainClass.getLCU().isEnabled()) {
				
				return;
				
			}
			
			Player p = e.getPlayer();
			Inventory inv = p.getInventory();
			ItemStack item = p.getItemInHand();
			ItemMeta itemmeta = item.getItemMeta();
			Block clicked = e.getClickedBlock();
			
			if (!itemmeta.getDisplayName().equalsIgnoreCase("§a§lLootChest Key") && MainClass.getLCU().isLootChest(clicked)) {
				
				p.sendMessage(prefix + "§cYou do not have a §a§lLootChest Key§c.");
				e.setCancelled(true);
				return;
				
			}
			
			if (itemmeta.getDisplayName().equalsIgnoreCase("§a§lLootChest Key") && MainClass.getLCU().isLootChest(clicked)) {

				e.setCancelled(true);
				
				ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
				inv.addItem(diamond);
				p.updateInventory();
				
				if (p.getItemInHand().getAmount() == 1) {
					inv.remove(item);
				}
				else {
					p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				}
				
				p.updateInventory();
				
				if (isChest()) {
					
					int chestnumber = r.nextInt(1000) + 1;
					
					//Legendary
					if (chestnumber == 1) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§d§kO§r§b§lLEGENDARY CHEST§d§kO§r");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §d§kO§r§b§lLEGENDARY CHEST§d§kO§r§a! Congratulations!");
						return;
					}
					
					//Ultra Rare
					else if (chestnumber > 0 && chestnumber <= 10) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§c§l§oUltra Rare Chest");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §c§l§oUltra Rare Chest§a! Congratulations!");
						return;
					}
					
					//Super Rare
					else if (chestnumber > 10 && chestnumber <= 50) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§6§lSuper Rare Chest§r");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §6§lSuper Rare Chest§a! Well Done!");
						return;
					}
					
					//Rare
					else if (chestnumber > 50 && chestnumber <= 150) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§eRare Chest§r");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §eRare Chest§a! Nice!");
						return;
					}
					
					//Uncommon
					else if (chestnumber > 150 && chestnumber <= 400) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§3Uncommon Chest§r");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §3Uncommon Chest§a!");
						return;
					}
					
					//Common
					else if (chestnumber > 400 && chestnumber <= 1000) {
						ItemStack chest = new ItemStack(Material.CHEST, 1);
						ItemMeta meta = chest.getItemMeta();
						meta.setDisplayName("§7Common Chest§r");
						List<String> lore = Arrays.asList("§cRight click to open, left click to", "§csee possible rewards!");
						meta.setLore(lore);
						chest.setItemMeta(meta);
						inv.addItem(chest);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						p.sendMessage(prefix + "You got §7Common Chest§a!");
						return;
					}
				}
				else {
					p.sendMessage(prefix + "Unlucky, no chest this time!");
					return;
				}
			}
		}
		else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			
			Player p = e.getPlayer();
			Block clicked = e.getClickedBlock();
			
			if (MainClass.getLCU().isLootChest(clicked)) {
				
				e.setCancelled(true);
				
				Inventory rewards = Bukkit.createInventory(p, 27, "Possible Rewards:");
				
				ItemStack diam = new ItemStack(Material.DIAMOND, 1);
				ItemStack legchest = new ItemStack(Material.CHEST, 1);
				ItemStack urchest = new ItemStack(Material.CHEST, 1);
				ItemStack srchest = new ItemStack(Material.CHEST, 1);
				ItemStack rchest = new ItemStack(Material.CHEST, 1);
				ItemStack ucchest = new ItemStack(Material.CHEST, 1);
				ItemStack cchest = new ItemStack(Material.CHEST, 1);
				
				ItemMeta dmeta = diam.getItemMeta();
				ItemMeta legmeta = legchest.getItemMeta();
				ItemMeta urmeta = urchest.getItemMeta();
				ItemMeta srmeta = srchest.getItemMeta();
				ItemMeta rmeta = rchest.getItemMeta();
				ItemMeta ucmeta = ucchest.getItemMeta();
				ItemMeta cmeta = cchest.getItemMeta();
				
				dmeta.setDisplayName("§b§lDiamond");
				legmeta.setDisplayName("§d§kO§r§b§lLEGENDARY CHEST§d§kO§r");
				urmeta.setDisplayName("§c§l§oUltra Rare Chest§r");
				srmeta.setDisplayName("§6§lSuper Rare Chest§r");
				rmeta.setDisplayName("§eRare Chest§r");
				ucmeta.setDisplayName("§3Uncommon Chest§r");
				cmeta.setDisplayName("§7Common Chest§r");
				
				List<String> diamlore = Arrays.asList("§c§l100% Chance");
				List<String> leglore = Arrays.asList("§c§l0.1% Chance");
				List<String> urlore = Arrays.asList("§c§l0.9% Chance");
				List<String> srlore = Arrays.asList("§c§l4% Chance");
				List<String> rlore = Arrays.asList("§c§l10% Chance");
				List<String> uclore = Arrays.asList("§c§l25% Chance");
				List<String> clore = Arrays.asList("§c§l60% Chance");
				
				dmeta.setLore(diamlore);
				legmeta.setLore(leglore);
				urmeta.setLore(urlore);
				srmeta.setLore(srlore);
				rmeta.setLore(rlore);
				ucmeta.setLore(uclore);
				cmeta.setLore(clore);
				
				diam.setItemMeta(dmeta);
				legchest.setItemMeta(legmeta);
				urchest.setItemMeta(urmeta);
				srchest.setItemMeta(srmeta);
				rchest.setItemMeta(rmeta);
				ucchest.setItemMeta(ucmeta);
				cchest.setItemMeta(cmeta);
				
				rewards.addItem(diam);
				rewards.addItem(legchest);
				rewards.addItem(urchest);
				rewards.addItem(srchest);
				rewards.addItem(rchest);
				rewards.addItem(ucchest);
				rewards.addItem(cchest);
				
				p.openInventory(rewards);
				
			}
			
		}
	}
}
