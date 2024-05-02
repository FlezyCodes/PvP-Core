package github.pvp.systems.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
@AllArgsConstructor
public abstract class Room {
        //FLEZY

        String name;

        public abstract void join(Player player);
        public abstract void leave(Player player);
        public abstract void hotbar(Player player);
        public abstract void message(Player player);

}
