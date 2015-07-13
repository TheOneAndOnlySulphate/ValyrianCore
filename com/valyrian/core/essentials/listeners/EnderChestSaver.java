package com.valyrian.core.essentials.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import com.valyrian.core.utils.PlayerFileUtils;

public class EnderChestSaver implements Listener {
	
	PlayerFileUtils pfu = new PlayerFileUtils();
	
	@EventHandler
	public void onEvent(InventoryCloseEvent e) {
		
		if (e.getInventory().getTitle().equalsIgnoreCase(e.getPlayer().getName() + "'s Ender Chest")) {
			
			FileConfiguration config = pfu.getPlayerFileConfig(e.getPlayer().getName());
			
			Inventory inv = e.getInventory();
			
			for (int i = 0; i < inv.getSize(); i++) {
				
				config.set("enderchest.items." + i, inv.getContents()[i]);
				pfu.savePlayerFile(config, pfu.getPlayerFile(e.getPlayer().getName()));
				
			}
			
		}
		
	}

}
