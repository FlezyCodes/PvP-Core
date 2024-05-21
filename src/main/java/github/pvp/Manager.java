package github.pvp;

import github.pvp.manager.AccountManager;
import github.pvp.listeners.register.ListenerHandler;
import github.pvp.loader.CommandLoader;
import github.pvp.manager.WarpManager;
import github.pvp.yaml.Config;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
@Getter
public class Manager extends JavaPlugin {


    public static Manager instance;
    public static Config location;

    @Getter
    private static final AccountManager accountManager = new AccountManager();

    @Getter
    private static WarpManager warpManager;

    @Override
    public void onEnable() {
        instance = this;
        location = new Config(this);
        warpManager = new WarpManager();
        warpManager.load(this);

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
