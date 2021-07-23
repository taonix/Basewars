package fr.taonix.basewars.managers;

import fr.taonix.basewars.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static fr.taonix.basewars.Basewars.*;

public class InventoryManager {

    private static void setGlasses(int[] cases, Inventory inv) {
        for (int aCase : cases) {
            inv.setItem(aCase, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE, 1).setName(" ").toItemStack());
        }
    }

    public static void master(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9*3, "§6§l> §r§4 Master panel");

        setGlasses(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26}, inv);

        inv.setItem(10, new ItemBuilder(Material.PLAYER_HEAD, playerNumber).setName("§2Nombre de joueurs").setLore("§7", "§8● §7Clic-Gauche §6» §achanger le nombre", "", "§8---", "§cAttention ! Changer cette ", "§cvaleur va clear tout les", "§cjoueurs.").toItemStack());
        if (matchAMort) inv.setItem(13, new ItemBuilder(Material.ARROW, 1).setName("§2Match à mort").setLore("§7", "§8● §7Clic-Gauche §6» §adésactiver", "§8● §7Statut §6» §aon", "", "§8---", "§2Le match à mort","§2suprimme toutes", "§2les bases après", "§230m de jeux.").toItemStack());
        else  inv.setItem(13, new ItemBuilder(Material.ARROW, 1).setName("§2Match à mort").setLore("§7", "§8● §7Clic-Gauche §6» §aactiver", "§8● §7Statut §6» §coff", "", "§8---","§2Le match à mort","§2suprimme toutes", "§2les bases après", "§230m de jeux.").toItemStack());

        if (Bukkit.getOnlinePlayers().stream().filter(ply -> ply.getScoreboardTags().contains("player")).count() != playerNumber) inv.setItem(16, new ItemBuilder(Material.BARRIER, 1).setName("§cPas asser de joueur pour démarer").toItemStack());
        else inv.setItem(16, new ItemBuilder(Material.KELP, 1).setName("§2Démarer").toItemStack());

        player.openInventory(inv);
    }
}
