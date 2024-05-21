package github.pvp.listeners;

import github.pvp.Manager;
import github.pvp.account.Account;
import github.pvp.manager.AccountManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerListeners implements Listener {
    private final AccountManager accountManager = Manager.getAccountManager();

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Account account = new Account(player.getUniqueId(), player.getName());
        accountManager.save(account);
        account.sendWarp(account.getWarpType());

    }
}
