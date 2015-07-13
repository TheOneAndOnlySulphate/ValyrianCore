package com.valyrian.core.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.valyrian.core.main.MainClass;

public class PlayerFileUtils {
	
	public void savePlayerFile(FileConfiguration config, File file) {
		
		try {
			
			config.save(file);
			
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public FileConfiguration getPlayerFileConfig(String playername) {
		
		File playerlist = new File(MainClass.get().getDataFolder() + "players", "playerlist.yml");
		FileConfiguration plistconfig = getFileConfig(playerlist);
		
		if (plistconfig.getString(playername + ".unique-id") == null) {
			
			return null;
			
		}
		
		else {
			
			File playeryml = new File(MainClass.get().getDataFolder() + "/players/", plistconfig.getString(playername + ".unique-id") + ".yml");
			FileConfiguration playerconfig = YamlConfiguration.loadConfiguration(playeryml);
			
			return playerconfig;
			
		}
		
	}
	
	public File getPlayerFile(String playername) {
		
		File plist = getPlayerList();
		
		FileConfiguration plistconfig = getFileConfig(plist);
		
		if (plistconfig.getString(playername + ".unique-id") == null) {
			
			return null;
			
		}
		
		else {
			
			File playeryml = new File(MainClass.get().getDataFolder() + "/players/", plistconfig.getString(playername + ".unique-id") + ".yml");
			
			return playeryml;
		
		}
		
	}
	
	public File getPlayerList() {
		
		File playerlist = new File(MainClass.get().getDataFolder() + "/players/playerlist/", "players.yml");
		
		if (!playerlist.exists()) {
			
			return null;
			
		}
		
		return playerlist;
		
	}
	
	public FileConfiguration getFileConfig(File file) {
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config;
		
	}

}
