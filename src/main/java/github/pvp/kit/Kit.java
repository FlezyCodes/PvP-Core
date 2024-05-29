package github.pvp.kit;

import github.pvp.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public  abstract class Kit {

    KitType kitType;
    private final Set<Player> players = new HashSet<>();
    private final ItemStack material;
    private final int slot;


    public abstract void join(Player player);
    public abstract void exit(Player player);
    public abstract void hotbar(Player player);

    public Location getLocation() {
        return Manager.location.getLocation(kitType.name().toLowerCase());
    }
}
