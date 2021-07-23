package fr.taonix.basewars.event.command;

import fr.taonix.basewars.managers.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (player.getScoreboardTags().contains("master")) {
                InventoryManager.master(player);
            }
        }
        return false;
    }
}
