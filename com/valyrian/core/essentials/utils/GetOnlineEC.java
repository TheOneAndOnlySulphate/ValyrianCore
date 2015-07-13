package com.valyrian.core.essentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GetOnlineEC {
	
	public Inventory getOnlineEnderChest(Player p) {
		
		Inventory chest = Bukkit.createInventory(null, 36, p.getName() + "'s Ender Chest");
		
		for (ItemStack i : p.getEnderChest()) {
			
			chest.addItem(i);
			
		}
		
		return chest;
		
	}

}
