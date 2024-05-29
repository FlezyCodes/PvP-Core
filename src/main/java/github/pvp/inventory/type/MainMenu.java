package github.pvp.inventory.type;

import github.pvp.builder.CreateItem;
import github.pvp.systems.rooms.type.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class MainMenu {


    // RAF
    public final static String inventoryName = Spawn.inventoryName;

    public static void open(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, inventoryName);
        inventory.setItem(3 , CreateItem.itemStack(Material.CHEST, "§aKits"));
        inventory.setItem( 4, CreateItem.itemStack(Material.STORAGE_MINECART, "§aExtras"));
        inventory.setItem( 5, CreateItem.itemStack(Material.COMPASS, "§aWarps"));
        inventory.setItem( 6, CreateItem.itemStack(Material.EMERALD, "§aLoja"));
        player.openInventory(inventory);
    }
}

