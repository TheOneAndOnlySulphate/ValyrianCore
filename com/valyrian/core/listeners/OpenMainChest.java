package com.valyrian.core.listeners;

import java.util.Random;

import org.bukkit.Material;
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
			
			Player p = e.getPlayer();
			Inventory inv = p.getInventory();
			ItemStack item = p.getItemInHand();
			ItemMeta itemmeta = item.getItemMeta();
			Block clicked = e.getClickedBlock();
			
			if (itemmeta.getDisplayName().equalsIgnoreCase("§a§lLootChest Key") && clicked.getType().equals(Material.CHEST) && clicked.getX() == MainClass.get().getConfig().getInt("Chest.X") && clicked.getY() == MainClass.get().getConfig().getInt("Chest.Y") && clicked.getZ() == MainClass.get().getConfig().getInt("Chest.Z")) {
				
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
						p.sendMessage(prefix + "You got §d§kO§r§b§lLEGENDARY CHEST§d§kO§r§a! Congratulations!");
						return;
					}
					
					//Ultra Rare
					else if (chestnumber > 0 && chestnumber <= 10) {
						p.sendMessage(prefix + "You got §c§l§oUltra Rare Chest§a! Congratulations!");
						return;
					}
					
					//Super Rare
					else if (chestnumber > 10 && chestnumber <= 50) {
						p.sendMessage(prefix + "You got §6§lSuper Rare Chest§a! Well Done!");
						return;
					}
					
					//Rare
					else if (chestnumber > 50 && chestnumber <= 150) {
						p.sendMessage(prefix + "You got §eRare Chest§a! Nice!");
						return;
					}
					
					//Uncommon
					else if (chestnumber > 150 && chestnumber <= 400) {
						p.sendMessage(prefix + "You got §3Uncommon Chest§a!");
						return;
					}
					
					//Common
					else if (chestnumber > 400 && chestnumber <= 1000) {
						p.sendMessage(prefix + "You got §7Common Chest§a!");
						return;
					}
				}	
			}
		}
	}
}
