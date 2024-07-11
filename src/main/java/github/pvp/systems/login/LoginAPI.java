package github.pvp.systems.login;


import github.pvp.Main;
import github.pvp.yaml.LoginYAML;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LoginAPI {


    private static final LoginYAML config = Main.login;
    private static String old, newpass, confirm, password;
    private final HashMap<Player, Boolean> map = new HashMap<>();
    private static CategoryType categoryType;
    private static Player player;


    public LoginAPI(Player player) {
        get(categoryType);
    }

    public boolean cheackLogin(Player player) {
        return map.get(player);

    }

    public void add(Player player) {
        if (!map.containsKey(player)) map.put(player, true);
        Bukkit.getLogger().info("Jogador " + player.getName() + " estar agora na lista de login");
    }

    public void remove(Player player) {
        if (map.containsKey(player)) map.remove(player, false);
        Bukkit.getLogger().info("Jogador " + player.getName() + " voi retirado da lista de login");
    }


    public String getPassword(Player player) {
        return config.getPassword(player);
    }

    public void registerPlayer(Player player, String password, String confirm) {
        if (!password.equals(confirm)) {
            player.sendMessage("§cPasswords do not match!");
        } else {
            player.sendMessage("§aYou are registered, welcome!");
            config.registerPassword(player, password);
        }

    }
    public void get(CategoryType categoryType){
        switch (categoryType) {
            case CHANGE_PASSWORD:
                if (old.equals(getPassword(player)) || newpass.equals(confirm)) {
                    config.changePassword(player, newpass);
                } else {
                    player.sendMessage("§cNot match");
                }
                break;
            case HAS_ACCOUNT:
                config.hasAccount(player);

                break;
            case REGISTER:
                if (!password.equals(confirm)) {
                    player.sendMessage("§cPasswords do not match!");
                } else {
                    player.sendMessage("§aYou are registered, welcome!");
                    config.registerPassword(player, password);
                }
            case GET_PASSWORD:
                config.getPassword(player);

            case DELETE_USER:
            case FORCE_LOGIN:
            case LOGIN:
        }
    }
}
