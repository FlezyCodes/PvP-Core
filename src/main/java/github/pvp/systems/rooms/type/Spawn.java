package github.pvp.systems.rooms.type;

import github.pvp.builder.CreateItem;
import github.pvp.systems.imortal.ImortalEnum;
import github.pvp.systems.rooms.Warp;
import github.pvp.systems.rooms.WarpType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;

public class Spawn extends Warp {


    public static String inventoryName = "§3§l► §6Menu§e§l §3§l◄";
    public Spawn() {
        super(WarpType.SPAWN, CreateItem.itemStack(Material.BED, "§aSpawn"), 0, Collections.singletonList("§aSpawn"));
    }

    @Override
    public void join(Player player) {
        player.getInventory().clear();

        CreateItem.setItem(player, 5, CreateItem.itemStack(Material.ENDER_CHEST, inventoryName));
        getPlayers().add(player);
    }

    @Override
    public void exit(Player player) {
        getPlayers().remove(player);
    }
}