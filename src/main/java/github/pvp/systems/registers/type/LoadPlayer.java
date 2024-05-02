package github.pvp.systems.registers.type;

import github.pvp.design.ActionBar;
import github.pvp.design.PrefixManager;
import github.pvp.systems.registers.PlayerManager;
import github.pvp.systems.rooms.RoomStrogare;
import github.pvp.systems.rooms.type.WarpEnum;
import org.bukkit.entity.Player;

public class LoadPlayer implements PlayerManager {
    @Override
    public void registrar(Player player) {
        //TODO -  Vericar se ele estar no banco de dados, se nao ele vai registrar ele.
        ActionBar.send(player, STR."§aSeja bem vindo ao\{new PrefixManager().getName()}");
        RoomStrogare.set(WarpEnum.SPAWN.name()).join(player);
    }
}
