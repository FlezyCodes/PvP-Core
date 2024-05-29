package github.pvp.listeners;

import github.pvp.inventory.type.InventoryKits;
import github.pvp.inventory.type.MainMenu;
import github.pvp.systems.rooms.type.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InventoryListener implements Listener {

    @EventHandler
    void onClicHk(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory() != null && e.getClickedInventory().getTitle() != null && e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kits")) {
            InventoryKits.Open(player);
        }
    }

    @EventHandler
    void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();


        if (e.getClickedInventory() == null && e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
            return;


        if (e.getInventory().getTitle().equalsIgnoreCase(Spawn.inventoryName)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItereract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Spawn.inventoryName)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                MainMenu.open(player);
            }
        }
    }
}