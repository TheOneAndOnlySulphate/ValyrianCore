package com.valyrian.core.lootchest.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.valyrian.core.main.MainClass;

public class LootChestUtils {
	
	private static Hologram chesthologram;
	
	public Location getLootChestLocation() {
		
		double x = MainClass.get().getConfig().getDouble("Chest.X");
		double y = MainClass.get().getConfig().getDouble("Chest.Y");
		double z = MainClass.get().getConfig().getDouble("Chest.Z");
		World w = Bukkit.getWorld(MainClass.get().getConfig().getString("Chest.World"));
		Location loc = new Location(w, x, y, z);
		
		return loc;
		
	}
	
	public void createChestHologram() {
		
		Location loc = getLootChestLocation().add(0.5, 2.75, 0.5);
		Hologram h = HologramsAPI.createHologram(MainClass.get(), loc);
		setChestHologram(h);
		h.appendItemLine(new ItemStack(Material.CHEST));
		h.appendTextLine("§b§lValyrian Chest");
		h.appendTextLine("§5§oRight click with a §aLootChest Key §5§oto unlock!");
		h.appendTextLine("§5§oLeft click to view available items!");
		h.appendItemLine(new ItemStack(Material.CHEST));
		
	}
	
	public boolean isLootChest(Block b) {
		
		double x = MainClass.get().getConfig().getDouble("Chest.X");
		double y = MainClass.get().getConfig().getDouble("Chest.Y");
		double z = MainClass.get().getConfig().getDouble("Chest.Z");
		World w = Bukkit.getWorld(MainClass.get().getConfig().getString("Chest.World"));
		Location loc = new Location(w, x, y, z);
		
		if (b.getLocation().equals(loc) && b.getType().equals(Material.CHEST)) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public void createLootChest(Location l) {
		
		if (MainClass.get().getConfig().getBoolean("Chest.Enabled")) {
			
			return;
			
		}
		
		MainClass.get().getConfig().set("Chest.Enabled", true);
		MainClass.get().getConfig().set("Chest.X", l.getX());
		MainClass.get().getConfig().set("Chest.Y", l.getY());
		MainClass.get().getConfig().set("Chest.Z", l.getZ());
		MainClass.get().getConfig().set("Chest.World", l.getWorld().getName());
		MainClass.get().saveConfig();
		
		createChestHologram();
		
	}
	
	public void deleteLootChest() {
		
		getChestHologram().delete();
		
		MainClass.get().getConfig().set("Chest.Enabled", false);
		MainClass.get().getConfig().set("Chest.X", null);
		MainClass.get().getConfig().set("Chest.Y", null);
		MainClass.get().getConfig().set("Chest.Z", null);
		MainClass.get().getConfig().set("Chest.World", null);
		
	}
	
	public boolean isEnabled() {
		
		if (MainClass.get().getConfig().getBoolean("Chest.Enabled")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public void setChestHologram(Hologram h) {
		chesthologram = h;
	}
	
	public Hologram getChestHologram() {
		return chesthologram;
	}

}
