package github.pvp.systems.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public abstract class Warp {

    private final WarpType type;

    private final Set<Player> players = new HashSet<>();


    public abstract void join(Player player);

    public abstract void exit(Player player);

    public Location getLocation() {
        return null;
    }
}
