package github.pvp.systems.rooms.type;

import github.pvp.Manager;
import github.pvp.builder.CreateItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
@AllArgsConstructor
public enum WarpEnum {

    SPAWN("Spawn", "", Manager.location.getLocation("spawn"), CreateItem.itemStack(Material.BED, "§aSpawn"), 1),
    FPS("Fps", "", Manager.location.getLocation("fps"), CreateItem.itemStack(Material.GLASS, "§bFps"), 1);

    String name, description;
    Location location;
    ItemStack material;
    int position;


}
