package github.pvp.listeners;

import github.pvp.systems.events.type.JoinHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerListeners implements Listener {


    @EventHandler
    void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        new JoinHandler(player).call();
    }
}
