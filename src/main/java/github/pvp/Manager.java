package github.pvp;

import github.pvp.loader.CommandLoader;
import github.pvp.loader.EventLoader;
import github.pvp.loader.RoomLoader;
import github.pvp.yaml.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Manager extends JavaPlugin {

    public static Manager instance;
    public static Config location;
    CommandLoader commandLoader = new CommandLoader();

    @Override
    public void onEnable() {
        instance = this;
        location = new Config(this);


        commandLoader.load(this);


//      new CommandLoader();
        new EventLoader();
        new RoomLoader();

    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onLoad() {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§aServidor reniciando..."));
    }
}
