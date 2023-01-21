package me.someone3.diamondpenalty;

import org.bukkit.plugin.java.JavaPlugin;

public final class DiamondPenaltyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new DiamondBreakListener(this);
        getCommand("diamondpenalty").setExecutor(new DiamondPenaltyCommand(this));
    }

}
