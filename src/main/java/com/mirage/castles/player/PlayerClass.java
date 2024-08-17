package com.mirage.castles.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerClass {
    private static final Map<Player, PlayerClass> playerClasses = new HashMap<>();

    private final String name;
    private final String description;

    public PlayerClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public static PlayerClass getPlayerClass(Player player) {
        return playerClasses.get(player);
    }


    public static void setPlayerClass(Player player, PlayerClass playerClass) {
        playerClasses.put(player, playerClass);
    }


    public static void removePlayerClass(Player player) {
        playerClasses.remove(player);
    }


    public abstract void useAbility(Player player);
}