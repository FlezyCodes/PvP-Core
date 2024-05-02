package github.pvp.systems.events.type;

import github.pvp.systems.events.EventHandler;
import github.pvp.systems.registers.PlayerManager;
import github.pvp.systems.registers.type.LoadPlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
@AllArgsConstructor
public class JoinHandler extends EventHandler {

    private final Player player;

    public void register(Player player){
        PlayerManager manager = new LoadPlayer();
        manager.registrar(player);
    }
}
