package github.pvp.listeners;

import github.pvp.Manager;
import github.pvp.account.Account;
import github.pvp.executor.Gamemode;
import github.pvp.kit.Kit;
import github.pvp.kit.KitManager;
import github.pvp.kit.type.PvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerListeners implements Listener {


    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
//
        Account user = new Account(player);

        KitManager.setKit(player, "PvP");
        player.sendMessage("§aaq");

    }
}
