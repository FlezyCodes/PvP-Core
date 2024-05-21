package github.pvp.listeners.register;
import github.pvp.util.ClassLoader;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;

@RequiredArgsConstructor
public class ListenerHandler {
    private final JavaPlugin plugin;

    public void load(String directory) {
        Instant now = Instant.now();

        int loaded = 0;

        plugin.getLogger().info("Registrando Eventos...");
        for (Class<?> listenerClass : ClassLoader.getClassesForPackage(plugin, directory)) {
            if (Listener.class.isAssignableFrom(listenerClass)) {
                try {
                    Listener listener = (Listener) listenerClass.newInstance();

                    plugin.getServer().getPluginManager().registerEvents(listener, plugin);

                    for (Method method : listenerClass.getMethods()) {
                        if (method.isAnnotationPresent(EventHandler.class))
                            loaded++;
                    }

                } catch (Exception e) {
                    plugin.getLogger().log(Level.WARNING, "Não foi possível registrar o evento " + listenerClass.getSimpleName(), e);
                }
            }
        }

        if (loaded > 0)
            plugin.getLogger().info("Registro de Eventos concluído com sucesso. (Total de eventos registrados: " + loaded
                    + " em " + Duration.between(now, Instant.now()).toMillis() + "ms)");
    }

}
