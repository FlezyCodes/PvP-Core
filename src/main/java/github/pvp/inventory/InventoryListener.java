package github.pvp.inventory;

import github.pvp.inventory.type.InventoryKits;
import github.pvp.inventory.type.MainMenu;
import github.pvp.manager.WarpManager;
import github.pvp.systems.rooms.Warp;
import github.pvp.systems.rooms.type.Spawn;
import org.bukkit.ChatColor;
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

        if (e.getClickedInventory() == null) return;
        if (e.getClickedInventory().getTitle() == null) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kits")) {
            InventoryKits.Ope(player);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Loja")) {
            // Loja.open();
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Extras")) {
            // Extras.open();
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Warps")) {
            // Warps.open();
            return;
        }
    }

    @EventHandler
    void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory() == null) return;
        if (e.getClickedInventory().getTitle() == null) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;



        if(e.getInventory().getTitle().equalsIgnoreCase(Spawn.inventoryName)){



        }




    }
    @EventHandler
    public void onItereract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Spawn.inventoryName)){
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                MainMenu.open(player);
            }
        }
    }
}