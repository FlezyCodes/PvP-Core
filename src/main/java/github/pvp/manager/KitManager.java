package github.pvp.manager;

import github.pvp.kit.Kit;
import github.pvp.kit.KitType;
import github.pvp.systems.rooms.Warp;
import github.pvp.util.ClassLoader;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

public class KitManager {
    @Getter
    private static final Set<Kit> kit = new HashSet<>();

    public void load(JavaPlugin plugin) {
        Instant now = Instant.now();

        plugin.getLogger().info("Registrando kits...");

        int loaded = 0;
        for (Class<?> kitClass : ClassLoader.getClassesForPackage(plugin, "github.pvp.kit.type")) {
            if (Warp.class.isAssignableFrom(kitClass)) {
                try {
                    Kit kits = (Kit) kitClass.newInstance();

                    kit.add(kits);

                    loaded++;
                } catch (Exception e) {
                    plugin.getLogger().log(Level.WARNING, "Não foi possível registrar a warp " + kitClass.getSimpleName(), e);
                }
            }
        }

        if (loaded > 0)
            plugin.getLogger().info("Registro de warps concluído com sucesso. (Total de warps registradas: " + loaded + " em "
                    + Duration.between(now, Instant.now()).toMillis() + "ms)");
    }


    public Kit read(KitType type) {
        return read(type.name());
    }

    public Kit read(String name) {
        return kit.stream().filter(kit -> kit.getKitType().name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
