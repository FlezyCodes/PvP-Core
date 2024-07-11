package github.pvp.yaml;

import github.pvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;


public class LocationYAML {

    public Main main;
    private File file;
    private YamlConfiguration configfile;

    public LocationYAML(Main loader) {
        this.main = loader;
        load();
    }

    private void load() {
        file = new File(main.getDataFolder(), "location.yml");
        if (!main.getDataFolder().exists()) main.getDataFolder().mkdirs();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
        }
        configfile = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            configfile.save(file);
        } catch (Exception e) {
        }
    }

    public YamlConfiguration config() {
        return configfile;
    }
    public boolean hasLocation(String loc) {
        return configfile.contains("Locations." + loc);
    }


    public void setLocation(Location loc, String locname) {
        configfile.set("Locations." + locname + ".world", loc.getWorld().getName());
        configfile.set("Locations." + locname + ".x", loc.getX());
        configfile.set("Locations." + locname + ".y", loc.getY());
        configfile.set("Locations." + locname + ".z", loc.getZ());
        configfile.set("Locations." + locname + ".yaw", loc.getYaw());
        configfile.set("Locations." + locname + ".pitch", loc.getPitch());
        save();
    }

    public Location getLocation(String locname) {
        String world = configfile.getString(String.format("Locations.%s.world", locname));
        double x = configfile.getDouble(String.format("Locations.%s.x", locname));
        double y = configfile.getDouble(String.format("Locations.%s.y", locname));
        double z = configfile.getDouble(String.format("Locations.%s.z", locname));
        float yaw = configfile.getInt(String.format("Locations.%s.yaw", locname));
        float pitch = configfile.getInt(String.format("Locations.%s.pitch", locname));
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);

    }
    public  void teleportLocation(Player player, String location){

        if(!hasLocation(location)){
            player.sendMessage(new String[]{
                    String.format("§cLocalizacao §4%s§c nao foi encontrado.", location),
                    "§aUse /set [loc] para adapitar uma warp."
            });
        }else{
            player.teleport(getLocation(location));
            player.sendMessage("§aVoce foi teleportado para " + location);
        }



    }

}