package com.mirage.castles.teams;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.UUID;

public class Team {
    private final Material material;
    private final UUID leader;
    private final String name;
    private final ChatColor color;

    public Team(Material material, UUID leader, String name, ChatColor color) {
        this.material = material;
        this.leader = leader;
        this.name = name;
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public UUID getLeader() {
        return leader;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }


}