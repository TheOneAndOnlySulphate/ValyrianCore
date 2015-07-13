package com.valyrian.core.listeners;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.valyrian.core.lootchest.commands.AddKeyCommand;
import com.valyrian.core.utils.PlayerFileUtils;

public class OwedKeysAdder implements Listener {
	
	PlayerFileUtils pfu = new PlayerFileUtils();
	AddKeyCommand akc = new AddKeyCommand();
	
	@EventHandler(priority = EventPriority.LOW)
	public void onEvent(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		String name = p.getName();
		
		FileConfiguration playerconfig = pfu.getPlayerFileConfig(name);
		File playeryml = pfu.getPlayerFile(name);
		
		int keysowed = playerconfig.getInt("keys-owed");
		
		if (keysowed > 0) {
			
			boolean keysadded = akc.addKeys(p, keysowed);
			
			if (!keysadded) {
				
				return;
				
			}
			
			playerconfig.set("keys-owed", 0);
			pfu.savePlayerFile(playerconfig, playeryml);
			
		}
		
	}

}
