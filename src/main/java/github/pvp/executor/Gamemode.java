package github.pvp.executor;

import github.pvp.design.PrefixManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(new PrefixManager().getConsoleCatch());
            return false;
        }

        Player player = ((((Player) commandSender).getPlayer()));

        if (player.hasPermission("pvp.gm")) {
            if (strings.length == 0) {
                player.sendMessage(new PrefixManager().getPrefix() + "§aUso correto /gm {1/0}");
                return false;
            }
            GameMode gameMode = getGameMode(strings[0]);
            if(gameMode == null){
                player.sendMessage(new PrefixManager().getPrefix() + "§cGamemode nao encontrado.");
                return false;
            }
            if (player.getGameMode().equals(gameMode)) {
                player.sendMessage(new PrefixManager().getPrefix() + "§aVoce ja estar neste modo.");
                return false;
            }

            player.setGameMode(gameMode);
            player.sendMessage(new PrefixManager().getPrefix() + "§aVoce estar no modo " + player.getGameMode());

        }else{
            player.sendMessage(new PrefixManager().getNoPermission());
        }
        return false;
    }

    protected GameMode getGameMode(String name) {
        switch (name.toLowerCase()) {
            case "creative":
            case "1":
                return GameMode.CREATIVE;
            case "survival":
            case "0":
                return GameMode.SURVIVAL;
            case "adventure":
            case "2":
                return GameMode.ADVENTURE;
            case "spectator":
            case "3":
                return GameMode.SPECTATOR;
            default:
                return null;
        }
    }
}
