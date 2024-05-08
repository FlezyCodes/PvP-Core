package github.pvp.systems.rooms;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RoomStrogare {
    //FLEZY
    public static Set<Room> set = set = new HashSet<>();
    public static HashMap<UUID, String> warps = new HashMap<>();


    public static String getWarp(Player player){
        return warps.getOrDefault(player.getUniqueId(), "Spawn");
    }

    public static void setWarp(Player player, String warp){
        warps.put(player.getUniqueId(), warp);
        System.out.println("Jogador " + player.getName()+ " foi inviado de warp " + getWarp(player) + " para   " + warp);
    }

    public static void save(Room room){
        set.add(room);
    }
    public static Room set(String name){
        return set.stream().filter(room -> room.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
