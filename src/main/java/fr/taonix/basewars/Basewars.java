package fr.taonix.basewars;

import fr.taonix.basewars.event.command.CommandStart;
import fr.taonix.basewars.event.inventoryclick.inventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basewars extends JavaPlugin {

    public static int playerNumber = 2;
    public static boolean matchAMort = true;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("start").setExecutor(new CommandStart());
        getServer().getPluginManager().registerEvents(new inventoryClick(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
