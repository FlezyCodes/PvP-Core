package github.pvp.design;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrefixManager {
//FLEZY

    String name, prefix, consoleCatch, playerOffline, noPermission;


    {
        name = "§a§lSERVIDOR";
        prefix = "§b§lKIT§f§lPVP§7► ";
        consoleCatch = "§cConsole nao pode executar este commando";
        playerOffline = "§cJogador nao estar online";
        noPermission = "§cVoce nao possui permissao.";
    }


}
