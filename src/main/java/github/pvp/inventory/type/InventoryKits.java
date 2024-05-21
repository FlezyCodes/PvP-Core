package github.pvp.inventory.type;

import github.pvp.kit.Kit;
import github.pvp.manager.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Set;


public class InventoryKits {


    public static String name = "§aKits";


    public static void Ope(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 4 * 9, "§aKits");


        Set<Kit> kits = KitManager.getKit();
        int slot = 10, last = slot;
        for (Kit kit : kits) {
            inventory.setItem(kit.getSlot(), kit.getMaterial());
            slot++;
            if (slot == (last + 7)) {
                slot += 2;
                last = slot;
            }
        }

    }

}
