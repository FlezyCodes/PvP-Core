package github.pvp.design;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
    public  void send(Player p, String text) {
        CraftPlayer craftplayer = (CraftPlayer) p;
        IChatBaseComponent ichatbasecomponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + " \"}");
        PacketPlayOutChat packetplayoutchat = new PacketPlayOutChat(ichatbasecomponent, (byte) 2);
        craftplayer.getHandle().playerConnection.sendPacket(packetplayoutchat);
    }


}
