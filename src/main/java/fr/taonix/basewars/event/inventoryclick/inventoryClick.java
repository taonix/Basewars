package fr.taonix.basewars.event.inventoryclick;

import fr.taonix.basewars.managers.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static fr.taonix.basewars.Basewars.*;

public class inventoryClick implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null && event.getCurrentItem().getType() != Material.AIR && event.getView().getTitle().contains("§6§l> §r§4 Master panel")) {

            String n = "\n";
            ItemStack current = event.getCurrentItem();
            String name = event.getCurrentItem().getItemMeta().getDisplayName();
            Player player = (Player) event.getWhoClicked();

            switch (current.getType()) {

                case WHITE_STAINED_GLASS_PANE:
                    if (name.equals("")) {
                        event.setCancelled(true);
                    }
                    break;

                case PLAYER_HEAD:
                    event.setCancelled(true);
                    if (current.getAmount() == 8) {

                        Bukkit.getOnlinePlayers().forEach((ply)-> {
                            if (ply.getScoreboardTags().contains("player")) ply.removeScoreboardTag("player");
                        });

                        playerNumber = 2;
                        current.setAmount(2);
                    } else {
                        playerNumber = playerNumber + 2;
                        current.setAmount(playerNumber + 2);
                    }

                case ARROW:
                    event.setCancelled(true);
                    if (matchAMort) matchAMort = false;
                    else matchAMort = true;
                    InventoryManager.master(player);
            }

        }

    }
}
