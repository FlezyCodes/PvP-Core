package github.pvp.systems.rooms.type;

import github.pvp.Manager;
import github.pvp.builder.CreateItem;
import github.pvp.systems.rooms.Room;
import github.pvp.systems.rooms.RoomStrogare;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class FPS extends Room {
    FPS(){
        super(WarpEnum.FPS.name);
    }
    @Override
    public void join(Player player) {
        if(!Manager.location.hasLocation(getName())){
            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.hasPermission("pvp.set")) {
                    staff.sendMessage(getName() + " nao foi setado.");
                }
            }
        }else{
            player.teleport(WarpEnum.FPS.location);
        }
    }

    @Override
    public void leave(Player player) {
        RoomStrogare.set(WarpEnum.SPAWN.name).join(player);
    }

    @Override
    public void hotbar(Player player) {
        Inventory inventory = player.getInventory();

        inventory.setItem(0, CreateItem.itemStack(Material.STONE_SWORD, "§7Espada"));
        for (int i = 0; i < 36; i++) {
            player.getInventory().setItem(inventory.firstEmpty(), CreateItem.itemStack(Material.MUSHROOM_SOUP, "§aSopa"));
        }

    }

    @Override
    public void message(Player player) {
       String[] message = {""};
       player.sendMessage(message);

    }
}
