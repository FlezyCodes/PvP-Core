package github.pvp.executor;

import github.pvp.Manager;
import github.pvp.account.Account;
import github.pvp.design.PrefixManager;
import github.pvp.systems.rooms.WarpType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Warp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(new PrefixManager().getConsoleCatch());
            return false;
        }

        Player player = ((Player) commandSender).getPlayer();

        String[] message = {player.hasPermission("pvp.set") ? new PrefixManager().getPrefix() + "§aUso correto /warp {warp/on/off}" : new PrefixManager().getPrefix() + "§aUso correto /warp {warp}"};

        if (strings.length == 0) {
            player.sendMessage(message);
            return false;
        }
        Account account = Manager.getAccountManager().read(player.getUniqueId());

        WarpType type = Arrays.stream(WarpType.values()).filter(warp -> warp.name().equalsIgnoreCase(strings[0])).findFirst().orElse(null);


        if (type == null) {
            player.sendMessage("§aA warp nao existe!");
            return false;
        }
        account.sendWarp(type);

        return false;
    }
}
