package github.pvp;

import github.pvp.loader.CommandLoader;
import github.pvp.loader.EventLoader;
import github.pvp.yaml.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Manager extends JavaPlugin {

    public static Manager instance;
    public static Config location;

    @Override
    public void onEnable() {
        instance = this;
        new EventLoader();
        new CommandLoader();

        location = new Config(this);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onLoad() {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§aServidor reniciando"));

    }
}
