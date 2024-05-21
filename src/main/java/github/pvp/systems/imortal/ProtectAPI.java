package github.pvp.systems.imortal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import java.util.HashMap;

public class ProtectAPI implements Listener {

    private static HashMap<Player, ImortalEnum> imortal = new HashMap<>();


    @EventHandler
    public void hit(EntityDamageEvent event){
        if((event.getEntity() instanceof  Player && event.getCause() != EntityDamageEvent.DamageCause.LAVA && event.getCause() != EntityDamageEvent.DamageCause.VOID) ){
            Player player = (Player) event.getEntity();
            if(isMortal(player)) event.setCancelled(true);
        }
    }

    @EventHandler
    public void entityDamage(EntityDamageByEntityEvent event){
        Player damager = (Player) event.getEntity();

        if(event.getEntity() instanceof  Player && event.getDamager() instanceof Player){
            if(event.getCause() == DamageCause.FALL){
                if(isMortal(damager)) event.setCancelled(true);
            }
            if((event.getDamager() instanceof  Player)){
                Player player = (Player) event.getDamager();
                if(isMortal(player)) event.setCancelled(true);
            }
        }
    }


    public static ImortalEnum getImortal(Player player){
        return imortal.get(player);
    }
    public static boolean isMortal(Player player){
        if(getImortal(player) == ImortalEnum.ON){
            return true;
        }
        return false;
    }
    public static void setImortal(Player player, boolean i){
        if(i) imortal.put(player, ImortalEnum.ON);
        else imortal.put(player, ImortalEnum.OFF);
    }
}
