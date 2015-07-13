package com.valyrian.core.essentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.valyrian.core.main.MainClass;

public class EsInvClickEventCanceller implements Listener {
	
	@EventHandler
	public void onEvent(InventoryClickEvent e) {
		
		Inventory inv = e.getInventory();
		
		Player p = (Player) e.getWhoClicked();
		
		Player holder = (Player) inv.getHolder();
		
		if (!(p.getName().equals(holder.getName()))) {
			
			if (!p.hasPermission("vc.invsee.edit")) {
				
				p.sendMessage(MainClass.getPrefix() + "§cYou do not have permission to edit a player's inventory.");
				e.setCancelled(true);
				
			}
			
		}
		
	}

}
