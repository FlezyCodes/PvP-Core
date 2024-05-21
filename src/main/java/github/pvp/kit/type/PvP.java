package github.pvp.kit.type;

import github.pvp.builder.CreateItem;
import github.pvp.kit.Kit;
import github.pvp.kit.KitType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class PvP extends Kit {


    public PvP() {
        super(KitType.PVP, CreateItem.itemStack(Material.STONE_SWORD, "", Arrays.asList("§aSEm habilidades", "§cEspada sla")), 0 );

    }


    @Override
    public void join(Player player) {
        player.getInventory().setItem(0, CreateItem.itemStack(Material.STONE_SWORD, "§aEspada"));
        hotbar(player);

    }

    @Override
    public void exit(Player player) {

    }

    @Override
    public void hotbar(Player player) {
            player.getInventory().clear();
            player.sendMessage("§aKit " + getKitType().name() + " §aselected");
            player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
    }

}
