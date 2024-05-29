package github.pvp;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import github.pvp.design.Motd;
import github.pvp.manager.AccountManager;
import github.pvp.listeners.register.ListenerHandler;
import github.pvp.loader.CommandLoader;
import github.pvp.manager.KitManager;
import github.pvp.manager.WarpManager;
import github.pvp.yaml.Config;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class Manager extends JavaPlugin {


    public static Manager instance;
    public static Config location;
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

        location = new Config(this);

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
