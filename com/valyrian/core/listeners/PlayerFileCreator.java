package com.valyrian.core.listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.valyrian.core.main.MainClass;
import com.valyrian.core.utils.PlayerFileUtils;

public class PlayerFileCreator implements Listener {
	
	PlayerFileUtils pfu = new PlayerFileUtils();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEvent(PlayerJoinEvent e) {
		
		//UUID & Player Name
		String uuid = e.getPlayer().getUniqueId().toString();
		String name = e.getPlayer().getName();
		
		//Player List File & Folders
		
		File playerlistfolder = new File(MainClass.get().getDataFolder() + "/players/playerlist/");
		
		if (!playerlistfolder.exists()) {
			
			playerlistfolder.mkdirs();
			
		}
		
		File plist = new File(MainClass.get().getDataFolder() + "/players/playerlist/", "players.yml");
		
		if (!plist.exists()) {
			
			try {
				
				plist.createNewFile();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				System.out.println("Internal IO Error occurred while creating 'players.yml'");
				
			}
			
		}
		
		FileConfiguration plistconfig = YamlConfiguration.loadConfiguration(plist);
		
		
		//Player List Update
		plistconfig.set(name + ".unique-id", uuid);
		pfu.savePlayerFile(plistconfig, plist);
		
		//Player Yaml File Creation
		File playeryml = new File(MainClass.get().getDataFolder() + "/players/", uuid + ".yml");
		
		if (!playeryml.exists()) {
			
			try {
				
				playeryml.createNewFile();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				System.out.println("Internal IO Error occurred while creating '" + uuid + ".yml");
				
			}
			
		}
		
		FileConfiguration ymlconfig = YamlConfiguration.loadConfiguration(playeryml);
		ymlconfig.set("player-name", name);
		pfu.savePlayerFile(ymlconfig, playeryml);
		
	}

}
