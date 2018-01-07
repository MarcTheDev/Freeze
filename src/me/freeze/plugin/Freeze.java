package me.freeze.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Freeze extends JavaPlugin implements Listener {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("freeze")) {
            Player p = (Player) sender;
            String target = args[0];
            Player user = Bukkit.getPlayer(target);

            if(p.hasPermission("freeze.command")) {
                if(args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Usage: /freeze <player>");
                }
                if(args.length == 1 && user != null) {
                    user.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,Integer.MAX_VALUE, 255));
                    user.setWalkSpeed(0);
                    // Just in case user is in flight ; no interference
                    user.setAllowFlight(false);
                    user.sendMessage(ChatColor.RED + "You have been frozen by " + ChatColor.GOLD + p.getName() + "!");
                    p.sendMessage(ChatColor.GREEN + "Successfully froze " + ChatColor.GOLD + target);
                    return true;
                }
                else if(user == null){
                    p.sendMessage(ChatColor.GOLD + target + ChatColor.RED + " is not online!");
                }
            }
            else if(!(p.hasPermission("freeze.command"))) {
                p.sendMessage(ChatColor.RED + "No Permission.");
            }
        }
        if(cmd.getName().equalsIgnoreCase("unfreeze")) {
            Player p = (Player) sender;
            String target = args[0];
            Player user = Bukkit.getPlayer(target);

            if(p.hasPermission("unfreeze.command")) {
                if(args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Usage: /unfreeze <player>");
                }
                if(args.length == 1 && user != null) {
                    user.setWalkSpeed(1);
                    user.removePotionEffect(PotionEffectType.JUMP);
                    user.sendMessage(ChatColor.GREEN + "You are now unfrozen!");
                    p.sendMessage(ChatColor.GREEN + "Successfully unfroze " + target);
                    return true;
                }
                else {
                    p.sendMessage(ChatColor.GOLD + target + ChatColor.RED + " is not online!");
                }
            }
            else if(!(p.hasPermission("unfreeze.command"))) {
                p.sendMessage(ChatColor.RED + "No permission.");
            }
        }
        return false;
    }
}
