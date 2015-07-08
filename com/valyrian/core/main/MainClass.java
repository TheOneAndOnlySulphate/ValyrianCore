package com.valyrian.core.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.valyrian.core.essentials.commands.BanCommand;
import com.valyrian.core.essentials.commands.FlyCommand;
import com.valyrian.core.essentials.commands.KickCommand;
import com.valyrian.core.essentials.commands.SetGamemodeCommand;
import com.valyrian.core.lootchest.commands.AddChestCommand;
import com.valyrian.core.lootchest.commands.AddKeyCommand;
import com.valyrian.core.lootchest.commands.LootChestCommand;
import com.valyrian.core.lootchest.listeners.ChestRewards;
import com.valyrian.core.lootchest.listeners.InvClickEventCanceller;
import com.valyrian.core.lootchest.listeners.OpenMainChest;
import com.valyrian.core.lootchest.utils.LootChestUtils;
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
		
		// LootChest Commands
		getCommand("lootchest").setExecutor(new LootChestCommand());
		getCommand("addkey").setExecutor(new AddKeyCommand());
		getCommand("addchest").setExecutor(new AddChestCommand());
		
		// Essentials Commands
		getCommand("gamemode").setExecutor(new SetGamemodeCommand());
		getCommand("gm").setExecutor(new SetGamemodeCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCOmmand("heal").setExecutor(new HealCommand());
		
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
