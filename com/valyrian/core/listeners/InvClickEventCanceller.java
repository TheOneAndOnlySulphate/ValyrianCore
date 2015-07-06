package com.valyrian.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InvClickEventCanceller implements Listener {
	
	@EventHandler
	public void onEvent(InventoryClickEvent e) {
		
		Inventory inv = e.getInventory();
		
		if (inv.getTitle().equalsIgnoreCase("Possible Rewards:")) {
			
			e.setCancelled(true);
			
		}
		
	}

}
