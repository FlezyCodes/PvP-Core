package github.pvp.loader;

import github.pvp.Manager;
import github.pvp.executor.Set;
import github.pvp.executor.Warp;

public class CommandLoader {


   public  void load(Manager manager){
       manager.getCommand("set").setExecutor(new Set());
       manager.getCommand("warp").setExecutor(new Warp());

    }
}
