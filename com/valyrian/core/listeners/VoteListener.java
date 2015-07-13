package com.valyrian.core.listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.valyrian.core.lootchest.commands.AddKeyCommand;
import com.valyrian.core.utils.PlayerFileUtils;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteListener implements Listener {
	
	PlayerFileUtils pfu = new PlayerFileUtils();
	AddKeyCommand akc = new AddKeyCommand();
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEvent(VotifierEvent e) {
		
		String name = e.getVote().getUsername();
		
		File playerlist = pfu.getPlayerList();
		FileConfiguration plistconfig = pfu.getFileConfig(playerlist);
		
		if (plistconfig.getString(name + ".unique-id") == null) {
			
			return;
			
		}
		
		if (Bukkit.getPlayer(name) == null) {
			
			FileConfiguration playerconfig = pfu.getPlayerFileConfig(name);
			File playeryml = pfu.getPlayerFile(name);
			
			playerconfig.set("keys-owed", playerconfig.getInt("keys-owed") + 1);
			pfu.savePlayerFile(playerconfig, playeryml);
			
		}
		
		else {
			
			akc.addKeys(Bukkit.getPlayer(name), 1);
			
		}
		
	}

}
