package github.pvp.kit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
@Getter
public  class Kit {

    String name;
    ItemStack material;
    int slot;
    public void join(Player player){

    }
    public void leave(Player player){

    }

}
