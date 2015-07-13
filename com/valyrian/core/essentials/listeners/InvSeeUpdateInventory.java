package com.valyrian.core.essentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InvSeeUpdateInventory implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEvent(InventoryCloseEvent e) {
		
		Inventory inv = e.getInventory();
		
		Player p = (Player) inv.getHolder();
		
		for (int i = 0; i < 36; i++) {
			
			p.getInventory().setItem(i, inv.getItem(i));
			
		}
		
		p.updateInventory();
		
	}

}
