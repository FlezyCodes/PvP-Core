package github.pvp.manager;
import github.pvp.systems.rooms.Warp;
import github.pvp.systems.rooms.WarpType;
import github.pvp.util.ClassLoader;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
    @Getter
    public class WarpManager {

        private final Set<Warp> list = new HashSet<>();

        public void load(JavaPlugin plugin) {
            Instant now = Instant.now();

            plugin.getLogger().info("Registrando Warps...");

            int loaded = 0;
            for (Class<?> warpClass : ClassLoader.getClassesForPackage(plugin, "github.pvp.systems.rooms.type")) {
                if (Warp.class.isAssignableFrom(warpClass)) {
                    try {
                        Warp warp = (Warp) warpClass.newInstance();

                        list.add(warp);

                        loaded++;
                    } catch (Exception e) {
                        plugin.getLogger().log(Level.WARNING, "Não foi possível registrar a warp " + warpClass.getSimpleName(), e);
                    }
                }
            }

            if (loaded > 0)
                plugin.getLogger().info("Registro de warps concluído com sucesso. (Total de warps registradas: " + loaded + " em "
                        + Duration.between(now, Instant.now()).toMillis() + "ms)");
        }


        public Warp read(WarpType type) {
            return read(type.name());
        }


        public Warp read(String name) {
            return list.stream().filter(warp -> warp.getType().name().equalsIgnoreCase(name)).findFirst().orElse(null);
        }
}
