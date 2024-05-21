package github.pvp.inventory.type;

import github.pvp.builder.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class MainMenu {

    public final static String inventoryName = "§aMenu principal";

    public static void open(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, inventoryName);
        inventory.setItem(2 , CreateItem.itemStack(Material.CHEST, ChatColor.GREEN + "Kits"));


        inventory.setItem( 4, CreateItem.itemStack(Material.STORAGE_MINECART, ChatColor.GREEN + "Extras"));

        inventory.setItem( 6, CreateItem.itemStack(Material.COMPASS, ChatColor.GREEN + "Warps"));

        inventory.setItem( 8, CreateItem.itemStack(Material.EMERALD, ChatColor.GREEN + "Loja"));
        player.openInventory(inventory);
    }
}

