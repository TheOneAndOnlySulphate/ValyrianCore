package com.valyrian.core.essentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import com.valyrian.core.utils.PlayerFileUtils;

public class GetOfflineEC {
	
	PlayerFileUtils pfu = new PlayerFileUtils();
	
	public Inventory getOfflineEnderChest(String playername) {
		
		FileConfiguration playerconfig = pfu.getPlayerFileConfig(playername);
		
		int invsize = playerconfig.getConfigurationSection("enderchest.items").getKeys(false).size();
		
		Inventory chest = Bukkit.createInventory(null, invsize);
		
		for (int i = 0; i < invsize; i++) {
			
			chest.addItem(playerconfig.getItemStack("enderchest.items." + i));
			
		}
		
		return chest;
		
	}

}
