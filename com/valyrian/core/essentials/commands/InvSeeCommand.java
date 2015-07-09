package com.valyrian.core.essentials.commands;

public class InvSeeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        String prefix = MainClass.getPrefix();
    
        if (!(sender instanceof Player) {
            
            sender.sendMessage(prefix + "§cOnly a player can run this command!");
            return true;
            
        }
        
        Player s = (Player) sender;
        
        if (args.length < 1) {
            
            s.sendMessage(prefix + "§cNot enough arguments!");
            s.sendmessage(prefix + "§cUsage: §a/invsee <player>")
            return true;
            
        }
        
        else {
            
            Player t = Bukkit.getPlayer(args[0]);
            
            if (t == null) {
                
                s.sendMessage(prefix + "§cThat player does not exist, or is not online.")
                return true;
                
            }
            
            Inventory tinv = t.getInventory();
            
            Inventory ninv = Bukkit.createInventory(s, 36, args[0] + "'s Inventory");
            
            for (ItemStack i : tinv) {
                
                ninv.addItem(i);
                
            }
            
            s.openInventory(ninv);
            
        }
    
    }

}
