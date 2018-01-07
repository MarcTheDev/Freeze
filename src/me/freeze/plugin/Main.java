package me.freeze.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
* Freeze Plugin made by MarcTheDev.
*/

public class Main extends JavaPlugin implements Listener {
    @EventHandler
    public void onPlayerJoin(AsyncPlayerChatEvent e) {
        // You can change this if your building the plugin.
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GREEN + "This server uses an open source project called 'Freeze'. Check it out here: https://github.com/MarcTheDev");
    }
    public void onEnable() {
        // Registering the event will make sure that the Freeze class is included.
        Bukkit.getPluginManager().registerEvents(this, new Freeze());
        saveDefaultConfig();
        Bukkit.getLogger().info("Freeze - Enabled");
    }
    public void onDisable() {
        Bukkit.getLogger().info("Freeze - Disabled");
    }
}
