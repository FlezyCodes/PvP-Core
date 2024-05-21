package github.pvp.account;

import github.pvp.Manager;
import github.pvp.kit.Kit;
import github.pvp.kit.KitType;
import github.pvp.systems.rooms.Warp;
import github.pvp.systems.rooms.WarpType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Account {

    private final UUID id;
    private final String name;

    private WarpType warpType = WarpType.LOGIN;
    private KitType kitType = KitType.NONE;



    public Player getPlayer() {
        return Bukkit.getPlayer(id);
    }

    public Warp getWarp() {
        return Manager.getWarpManager().read(warpType);
    }



        public Kit getKit () {
            return Manager.getKitManager().read(kitType);
        }
        public void setKit(KitType type){
            Player player = getPlayer();

            if (player == null) return;

            if (hasKit(type)) {
                player.sendMessage("§cVocê já estár usando kit: " + type.name() + "!");
                return;
            }

            Kit current = Manager.getKitManager().read(kitType), kit = Manager.getKitManager().read(type);

            if (kit == null) {
                player.sendMessage("§cA warp solicitada não foi encontrada.");
                return;
            }



            if (current != null) current.exit(player);

            kit.join(player);

            player.sendMessage("§aVocê foi enviado para a warp " + type.name());

        }

        public boolean hasKit(KitType type){
        return kitType.equals(type);
        }

    public void sendWarp(WarpType type) {
        Player player = getPlayer();

        if (player == null) return;

        if (inWarp(type)) {
            player.sendMessage("§cVocê já está na warp " + type.name() + "!");
            return;
        }

        Warp current = Manager.getWarpManager().read(warpType), warp = Manager.getWarpManager().read(type);

        if (warp == null) {
            player.sendMessage("§cA warp solicitada não foi encontrada.");
            return;
        }

        if (warp.getLocation() == null) {
            player.sendMessage("§cA localização da warp " + type.name() + " não foi encontrada.");
            return;
        }

        if (current != null) current.exit(player);

        warp.join(player);
        setWarpType(type);

        player.teleport(warp.getLocation());

        player.sendMessage("§aVocê foi enviado para a warp " + type.name());
    }

    public boolean inWarp(WarpType warp) {
        return warpType.equals(warp);
    }
}
