package com.valyrian.core.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.valyrian.core.commands.AddChestCommand;
import com.valyrian.core.commands.AddKeyCommand;
import com.valyrian.core.commands.LootChestCommand;
import com.valyrian.core.listeners.ChestRewards;
import com.valyrian.core.listeners.InvClickEventCanceller;
import com.valyrian.core.listeners.OpenMainChest;
import com.valyrian.core.utils.LootChestUtils;
import com.valyrian.core.utils.SendConsoleMessage;

public class MainClass extends JavaPlugin {
	
	SendConsoleMessage c = new SendConsoleMessage();
	private static MainClass plugin;
	private static LootChestUtils l = new LootChestUtils();
	private String prefix = "§7[§bValyrian§7] §a";
	
	public void onEnable() {
		c.sendMessage(prefix + "ValyrianCore has been enabled!");
		c.sendMessage(prefix + "The current version is: §bv1.3.3§a!");
		plugin = this;
	
		if (getConfig().getBoolean("Chest.Enabled")) {
			
			l.createChestHologram();
			
		}
		
		Bukkit.getPluginManager().registerEvents(new OpenMainChest(), this);
		Bukkit.getPluginManager().registerEvents(new ChestRewards(), this);
		Bukkit.getPluginManager().registerEvents(new InvClickEventCanceller(), this);
		getCommand("lootchest").setExecutor(new LootChestCommand());
		getCommand("addkey").setExecutor(new AddKeyCommand());
		getCommand("addchest").setExecutor(new AddChestCommand());
		getCommand("gamemode").setExecutor(new SetGamemodeCommand());
		getCommand("gm").setExecutor(new SetGamemodeCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("kick").setExecutor(new KickCommand());
		
	}
	
	public void onDisable() {
		plugin = null;
		c.sendMessage(prefix + "ValyrianCore has been disabled!");
		
		if (l.getChestHologram() != null && l.getChestHologram() instanceof Hologram) {
			
			l.getChestHologram().delete();
			
		}
		
	}
	
	public static MainClass get() {
		return plugin;
	}
	
	public static LootChestUtils getLCU() {
		return l;
	}

}
