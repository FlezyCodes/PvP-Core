package github.pvp.systems.rooms.type;

import github.pvp.Manager;
import lombok.AllArgsConstructor;
import org.bukkit.Location;

@AllArgsConstructor
public enum WarpEnum {

    SPAWN("Spawn", "", Manager.location.getLocation("spawn")), FPS("Fps", "",Manager.location.getLocation("fps")), ONEVSONE("OneVsOne", "", Manager.location.getLocation("onevsone")), GLADIATOR("Gladiator", "", Manager.location.getLocation("gladiator"));

    String name, description;
    Location location;


}
