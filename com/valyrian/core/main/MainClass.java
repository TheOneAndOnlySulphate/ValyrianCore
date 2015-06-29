package com.valyrian.core.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.valyrian.core.commands.LootChestCommand;
import com.valyrian.core.utils.SendConsoleMessage;

public class MainClass extends JavaPlugin {
	
	SendConsoleMessage c = new SendConsoleMessage();
	private static MainClass plugin;
	private String prefix = "§7[§bValyrian§7] §a";
	
	public void onEnable() {
		c.sendMessage(prefix + "ValyrianCore has been enabled!");
		c.sendMessage(prefix + "The current version is: §bv1.0§a!");
		plugin = this;
		getCommand("lootchest").setExecutor(new LootChestCommand());
	}
	
	public void onDisable() {
		plugin = null;
	}
	
	public static MainClass get() {
		return plugin;
	}

}
