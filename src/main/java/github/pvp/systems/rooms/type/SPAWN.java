package github.pvp.systems.rooms.type;

import github.pvp.Manager;
import github.pvp.builder.CreateItem;
import github.pvp.design.PrefixManager;
import github.pvp.systems.rooms.Room;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SPAWN extends Room {
    public SPAWN() {
        super(WarpEnum.SPAWN.name);
    }

    static String inventory() {
        return "§7►§b► §3Kits §6◄§7◄";
    }

    @Override
    public void join(Player player) {


        if (!Manager.location.hasLocation("spawn")) {
            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.hasPermission("pvp.set")) {
                    staff.sendMessage(STR."§cSpawn foi setado, use /set  \{getName()}");
                }
            }
        } else {
            player.teleport(WarpEnum.SPAWN.location);
            hotbar(player);
            message(player);
        }
    }

    @Override
    public void leave(Player player) {

    }

    @Override
    public void hotbar(Player player) {
        Inventory inventory = player.getInventory();
        inventory.setItem(4, CreateItem.itemStack(Material.CHEST, inventory()));

    }

    @Override
    public void message(Player player) {
        String[] message = {STR."§aSeja bem vindo ao \{new PrefixManager().getName()}"};


    }
}
