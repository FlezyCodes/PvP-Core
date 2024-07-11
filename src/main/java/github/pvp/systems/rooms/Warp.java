package github.pvp.systems.rooms;

import github.pvp.Main;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

@Getter
@RequiredArgsConstructor
public abstract class Warp {

    private final WarpType type;
    private final Set<Player> players = new HashSet<>();
    private final ItemStack material;
    private final int slot;
    private final List<String> description;


    public abstract void join(Player player);

    public abstract void exit(Player player);

    public Location getLocation() {
        return Main.location.getLocation(type.name().toLowerCase());
    }

}
