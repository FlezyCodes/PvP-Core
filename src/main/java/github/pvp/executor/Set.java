package github.pvp.executor;

import github.pvp.Main;
import github.pvp.design.PrefixManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Set implements CommandExecutor {

//FLEZY
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
            commandSender.sendMessage(new PrefixManager().getConsoleCatch());

        Player player = (Player) commandSender;
        if (player.hasPermission("pvp.set")) {
            if (strings.length == 0) {
                player.sendMessage(new PrefixManager().getPrefix() + "§aUso correto /set {Localizacao}");
                return false;
            }
            Main.location.setLocation(player.getLocation(), strings[0]);
            player.sendMessage("§aVoce setou loc ( "+ strings[0] +"  )");
            return false;
        } else {
            player.sendMessage(new PrefixManager().getNoPermission());
        }
        return false;
    }
}
