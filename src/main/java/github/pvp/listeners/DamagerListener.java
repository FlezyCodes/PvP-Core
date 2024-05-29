package github.pvp.listeners;

import github.pvp.account.Account;
import github.pvp.systems.imortal.ImortalEnum;
import github.pvp.systems.rooms.WarpType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.HashMap;

public class DamagerListener implements Listener {






    // Protection - SPAWN
    @EventHandler
    public void hit(EntityDamageEvent event) {
        if ((event.getEntity() instanceof Player && event.getCause() != DamageCause.LAVA && event.getCause() != DamageCause.VOID)) {
            Player player = (Player) event.getEntity();
            Account account = new Account(player.getUniqueId(), player.getName());
            if (account.getWarpType().name().equalsIgnoreCase(WarpType.SPAWN.name())) {
                event.setCancelled(true);
            }
        }
    }


}
