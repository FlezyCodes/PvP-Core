package github.pvp.listeners;

import github.pvp.Manager;
import github.pvp.account.Account;
import github.pvp.kit.KitType;
import github.pvp.manager.AccountManager;
import github.pvp.systems.login.LoginAPI;
import github.pvp.systems.rooms.WarpType;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class ServerListeners implements Listener {


    private final AccountManager accountManager = Manager.getAccountManager();

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Account account = new Account(player.getUniqueId(), player.getName());
        accountManager.save(account);
        account.sendWarp(WarpType.SPAWN);
        account.setKit(KitType.NONE);

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
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
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
    public void onLogin(PlayerLoginEvent event){

    }

}
