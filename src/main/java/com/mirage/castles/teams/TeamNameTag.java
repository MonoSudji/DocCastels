package com.mirage.castles.teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TeamNameTag {

    public static void setTeamNameTag(Player player, Team team) {
        if (team == null) {
            player.setDisplayName(ChatColor.AQUA + player.getName() + " [" + "Нейтральный" + "]");
            player.setPlayerListName(ChatColor.AQUA + player.getName() + " [" + "Нейтральный" + "]");
        }
        if (team != null) {
            String teamName = team.getName();
            ChatColor teamColor = team.getColor();


            player.setDisplayName(teamColor + player.getName() + " [" + teamName + "]");
            player.setPlayerListName(teamColor + player.getName() + " [" + teamName + "]");
        } else {
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
        }
    }
}