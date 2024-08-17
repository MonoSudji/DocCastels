package com.mirage.castles;

import com.mirage.castles.comands.GiveBookCommand;
import com.mirage.castles.gold.GoldManager;
import com.mirage.castles.listeners.GoldListener;
import com.mirage.castles.listeners.GuiListener;
import com.mirage.castles.listeners.TeamListener;
import com.mirage.castles.teams.Team;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Castels extends JavaPlugin {

    private GoldManager goldManager;
    public final Map<UUID, Team> TeamPlayer = new HashMap<>();

    @Override
    public void onEnable() {
        goldManager = new GoldManager();
        this.getCommand("getmenubook").setExecutor(new GiveBookCommand());

        getServer().getPluginManager().registerEvents(new GuiListener(this), this);
        getServer().getPluginManager().registerEvents(new GoldListener(goldManager , this), this);
        getServer().getPluginManager().registerEvents(new TeamListener(this), this);
    }

    @Override
    public void onDisable() {

    }
}