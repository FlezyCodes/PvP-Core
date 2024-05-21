package github.pvp.kit.type;

import github.pvp.builder.CreateItem;
import github.pvp.kit.Kit;
import github.pvp.kit.KitType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class None extends Kit {
    @Override
    public void hotbar(Player player) {

    }

    public None() {
        super(KitType.NONE, CreateItem.itemStack(Material.ENDER_CHEST, "§aSpawn"), 0);
    }



    @Override
    public void join(Player player) {

    }

    @Override
    public void exit(Player player) {

    }
}
