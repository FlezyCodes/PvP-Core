package github.pvp;

import github.pvp.design.Motd;
import github.pvp.manager.AccountManager;
import github.pvp.listeners.register.ListenerHandler;
import github.pvp.loader.CommandLoader;
import github.pvp.manager.KitManager;
import github.pvp.manager.WarpManager;
import github.pvp.yaml.LocationYAML;
import github.pvp.yaml.LoginYAML;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Main extends JavaPlugin {


    public static Main instance;
    public static LocationYAML location;
    public static LoginYAML login;

    public static Plugin plugin;

    @Getter
    private static final AccountManager accountManager = new AccountManager();

    @Getter
    private static WarpManager warpManager;

    @Getter
    private static KitManager kitManager;

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;

        location = new LocationYAML(this);
        login = new LoginYAML(this);

        warpManager = new WarpManager();
        warpManager.load(this);

        kitManager = new KitManager();
        kitManager.load(this);

        new Motd().load(this);
        new CommandLoader().load(this);
        new ListenerHandler(this).load("github.pvp.listeners");
    }

    @Override
    public void onDisable() {       
    }

    @Override
    public void onLoad() {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§aServidor reniciando..."));
    }


}
