package com.valyrian.core.essentials.listeners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinMessage implements Listener {

    @EventHandler
    public void onEvent(PlayerJoinEvent e) {
    
        Player p = e.getPlayer();
        String pn = p.getName();
        
        for (Player pl : Bukkit.getOnlinePlayers()) {
        	
        	if (isStaff(pl) && isStaff(p)) {
        		
        		pl.sendMessage("§7[§a+§7] §a(§c" + getRank(p) + "§a) " + pn);
        		
        	}
        	
        	else {
        		
        		pl.sendMessage("§7[§a+§7] §a" + pn);
        		
        	}
        	
        }
    
    }
    
    public String getRank(Player p) {
    
        if (p.hasPermission("vc.owner")) {
        	
        	return "owner";
        	
        }
        
        else if (p.hasPermission("vc.coowner")) {
        	
        	return "coowner";
        	
        }
        
        else if (p.hasPermission("vc.developer")) {
        	
        	return "developer";
        	
        }
        
        else if (p.hasPermission("vc.admin")) {
        	
        	return "admin";
        	
        }
        
        else if (p.hasPermission("vc.srmod")) {
        	
        	return "srmod";
        	
        }
        
        else if (p.hasPermission("vc.moderator")) {
        	
        	return "moderator";
        	
        }
        
        else if (p.hasPermission("vc.helper")) {
        	
        	return "helper";
        	
        }
        
        else {
        	
        	return "member";
        	
        }
    
    }
    
    public boolean isStaff(Player p) {
    	
    	List<String> staffranks = Arrays.asList("owner","coowner","developer","admin","srmod","moderator","helper");
    	
    	if (staffranks.contains(getRank(p))) {
    		
    		return true;
    		
    	}
    	
    	else {
    		
    		return false;
    		
    	}
    	
    }


}
