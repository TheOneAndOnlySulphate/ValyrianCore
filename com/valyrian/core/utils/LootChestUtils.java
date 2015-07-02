package com.valyrian.core.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.valyrian.core.main.MainClass;

public class LootChestUtils {
	
	public static Location getLootChestLocation(Player p) {
		
		double x = MainClass.get().getConfig().getDouble("Chest.X");
		double y = MainClass.get().getConfig().getDouble("Chest.Y");
		double z = MainClass.get().getConfig().getDouble("Chest.Z");
		World w = p.getWorld();
		Location loc = new Location(w, x, y, z);
		
		return loc;
		
	}
	
	public static Hologram createChestHologram(Player p) {
		
		Location loc = getLootChestLocation(p).add(0.5, 2.75, 0.5);
		Hologram h = HologramsAPI.createHologram(MainClass.get(), loc);
		h.appendItemLine(new ItemStack(Material.CHEST));
		h.appendTextLine("§b§lValyrian Chest");
		h.appendTextLine("§5§oRight click with a §aLootChest Key §5§oto unlock!");
		h.appendItemLine(new ItemStack(Material.CHEST));
		return h;
		
	}
	
	public static boolean isLootChest(Block b, Player p) {
		
		double x = MainClass.get().getConfig().getDouble("Chest.X");
		double y = MainClass.get().getConfig().getDouble("Chest.Y");
		double z = MainClass.get().getConfig().getDouble("Chest.Z");
		World w = p.getWorld();
		Location loc = new Location(w, x, y, z);
		
		if (b.getLocation().equals(loc) && b.getType().equals(Material.CHEST)) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public static void createLootChest(Location l) {
		
		MainClass.get().getConfig().set("Chest.X", l.getX());
		MainClass.get().getConfig().set("Chest.Y", l.getY());
		MainClass.get().getConfig().set("Chest.Z", l.getZ());
		MainClass.get().saveConfig();
		
	}

}
