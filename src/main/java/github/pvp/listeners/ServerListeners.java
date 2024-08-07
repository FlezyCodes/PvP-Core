package github.pvp.listeners;

import github.pvp.Main;
import github.pvp.account.Account;
import github.pvp.design.PrefixManager;
import github.pvp.manager.AccountManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;

public class ServerListeners implements Listener {


    private final AccountManager accountManager = Main.getAccountManager();

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Account account = accountManager.read(player.getUniqueId());


    }

    @EventHandler
    public void exit(PlayerQuitEvent event) {
        event.setQuitMessage(null);

        Player player = event.getPlayer();

        Account account = accountManager.read(player.getUniqueId());
        if (account != null) {
            account.getWarp().exit(player);
            accountManager.delete(account.getId());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            double i = p.getHealth();
            if (i >= 20) {
                return;
            }
            if (e.getItem() == null) {
                return;
            }
            if (!(e.getItem().getType() == Material.MUSHROOM_SOUP)) {
                return;
            }
            p.setHealth(Math.min(p.getMaxHealth(), p.getHealth() + 7));
            p.setFoodLevel(Math.min(20, p.getFoodLevel() + 7));
            p.getInventory().setItemInHand(new ItemStack(Material.BOWL));
            p.updateInventory();
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {

    }

    @EventHandler
    public void motd(ServerListPingEvent event) {
        if (Bukkit.getServer().hasWhitelist()) {
            event.setMotd(" §6§lKitPVP §f §lMC  §7(1.8.*)\n §cServidor em manuten  o!");
        } else {
            event.setMotd(" 6§lKitPVP §f §lMC  §7(1.8.*)\n §fwww " + new PrefixManager().getWebsite() + ".com");
        }
    }

}
