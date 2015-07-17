package com.valyrian.core.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import com.valyrian.core.main.MainClass;

public class InvSeeCommand implements CommandExecutor {

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        String prefix = MainClass.getPrefix();
    
        if (!(sender instanceof Player)) {
            
            sender.sendMessage(prefix + "§cOnly a player can run this command!");
            return true;
            
        }
        
        Player s = (Player) sender;
        
        if (!(s.hasPermission("vc.invsee"))) {
        	
        	s.sendMessage(prefix + "§cYou do not have permission to use this command.");
        	return true;
        	
        }
        
        if (args.length < 1) {
            
            s.sendMessage(prefix + "§cNot enough arguments!");
            s.sendMessage(prefix + "§cUsage: §a/invsee <player>");
            return true;
            
        }
        
        else {
            
            Player t = Bukkit.getPlayer(args[0]);
            
            if (t == null) {
                
                s.sendMessage(prefix + "§cThat player does not exist, or is not online.");
                return true;
                
            }
            
            Inventory tinv = t.getInventory();
            
            s.openInventory(tinv);
            
        }
        
		return true;
    
    }

}
