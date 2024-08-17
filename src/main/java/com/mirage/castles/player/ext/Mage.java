package com.mirage.castles.player.ext;

import com.mirage.castles.Castels;
import com.mirage.castles.player.PlayerClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class Mage extends PlayerClass {
    private Castels plugin;
    public Mage() {
        super("Маг", "Мастер магии, использующий огненные заклинания.");
    }

    public void useAbility(Player player) {
        launchFireball(player);
    }

    private void launchFireball(Player player) {
        Fireball fireball = player.getWorld().spawn(player.getEyeLocation(), Fireball.class);
        fireball.setDirection(player.getLocation().getDirection());
        fireball.setIsIncendiary(true);
        fireball.setYield(4);

        Bukkit.getScheduler().runTaskLater(plugin, () -> fireball.remove(), 100);
    }
}