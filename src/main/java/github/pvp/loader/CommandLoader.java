package github.pvp.loader;

import github.pvp.Manager;
import github.pvp.executor.Set;

public class CommandLoader {


   public void load(Manager manager){
       manager.getCommand("set").setExecutor(new Set());

    }
}
