package github.pvp.systems.login;

import github.pvp.Manager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class LoginAPI {

    private static ArrayList<UUID> inLogin = new ArrayList<>();



    public boolean correctPassword(Player player){
        return Manager.location.correctPassword(player);
    }


}
