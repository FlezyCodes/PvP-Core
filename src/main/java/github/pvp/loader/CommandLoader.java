package github.pvp.loader;

import github.pvp.Main;
import github.pvp.executor.Login;
import github.pvp.executor.Set;
import github.pvp.executor.WarpCMD;

public class CommandLoader {


   public  void load(Main manager){
       manager.getCommand("set").setExecutor(new Set());
       manager.getCommand("warp").setExecutor(new WarpCMD());
       manager.getCommand("register").setExecutor(new Login());
       manager.getCommand("changepass").setExecutor(new Login());

    }
}
