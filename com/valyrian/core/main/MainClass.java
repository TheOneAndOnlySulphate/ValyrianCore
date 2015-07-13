package com.valyrian.core.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.valyrian.core.essentials.commands.*;
import com.valyrian.core.essentials.listeners.*;
import com.valyrian.core.listeners.*;
import com.valyrian.core.lootchest.commands.*;
import com.valyrian.core.lootchest.listeners.*;
import com.valyrian.core.lootchest.utils.*;
import com.valyrian.core.utils.*;


public class MainClass extends JavaPlugin {
	
	SendConsoleMessage c = new SendConsoleMessage();
	private static MainClass plugin;
	private static LootChestUtils l = new LootChestUtils();
	private static String prefix = "§7[§bValyrian§7] §a";
	
	public void onEnable() {
		c.sendMessage(prefix + "ValyrianCore has been enabled!");
		c.sendMessage(prefix + "The current version is: §bv1.3.8§a!");
		plugin = this;
	
		if (getConfig().getBoolean("Chest.Enabled")) {
			
			Location lootchest = l.getLootChestLocation();
			
			l.deleteLootChest();
			
			l.createLootChest(lootchest);
			
		}
		
		//Core
		Bukkit.getPluginManager().registerEvents(new OwedKeysAdder(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFileCreator(), this);
		Bukkit.getPluginManager().registerEvents(new VoteListener(), this);
		
		//LootChest
		Bukkit.getPluginManager().registerEvents(new OpenMainChest(), this);
		Bukkit.getPluginManager().registerEvents(new ChestRewards(), this);
		Bukkit.getPluginManager().registerEvents(new LcInvClickEventCanceller(), this);
		getCommand("lootchest").setExecutor(new LootChestCommand());
		getCommand("addkey").setExecutor(new AddKeyCommand());
		getCommand("addchest").setExecutor(new AddChestCommand());
		
		//Essentials
		Bukkit.getPluginManager().registerEvents(new PlayerJoinMessage(), this);
		Bukkit.getPluginManager().registerEvents(new EnderChestSaver(), this);
		Bukkit.getPluginManager().registerEvents(new EsInvClickEventCanceller(), this);
		Bukkit.getPluginManager().registerEvents(new InvSeeUpdateInventory(), this);
		getCommand("gamemode").setExecutor(new SetGamemodeCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("workbench").setExecutor(new WorkbenchCommand());
		getCommand("clearinventory").setExecutor(new ClearInventoryCommand());
		getCommand("banip").setExecutor(new BanIPCommand());
		getCommand("chest").setExecutor(new EnderChestCommand());
		getCommand("time").setExecutor(new TimeCommand());
		getCommand("weather").setExecutor(new WeatherCommand());
		getCommand("invsee").setExecutor(new InvSeeCommand());
		
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
	
	public static String getPrefix() {
		return prefix;
	}

}
