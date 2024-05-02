package github.pvp.systems.events;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EventHandler extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

 public void call(){
     Bukkit.getPluginManager().callEvent(this);
 }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
