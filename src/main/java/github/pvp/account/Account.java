package github.pvp.account;


import github.pvp.kit.Kit;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class Account {

    private final static Set<Account> list = new HashSet<>();

    private final Player player;

    private Kit kit;
//    private WarpManager warp;

    public Account(Player player) {
        this.player = player;

        list.add(this);
    }

    public static Account readKit(UUID id) {
        return list.stream().filter(user -> user.getPlayer().getUniqueId().equals(id)).findFirst().orElse(null);
    }

    public static void removeKit(UUID id) {
        list.removeIf(user -> user.getPlayer().getUniqueId().equals(id));
    }

    public boolean hasKit() {
        return kit != null;
    }

    public boolean hasKit(String name) {
        return hasKit() && kit.getName().equalsIgnoreCase(name);
    }




}
