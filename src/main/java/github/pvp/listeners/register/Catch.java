package github.pvp.listeners.register;

import github.pvp.systems.events.type.JoinHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Catch implements Listener {

    @EventHandler
    void register(JoinHandler handler){
        handler.register(handler.getPlayer());
    }
}
