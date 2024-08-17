package com.mirage.castles.player.ext;

import com.mirage.castles.Castels;
import com.mirage.castles.player.PlayerClass;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

public class Archer extends PlayerClass {

    private Castels plugin;

    public Archer() {
        super("Лучник", "Мастер дальнего боя, использующий лук и стрелы.");
    }

    public void useAbility(Player player) {
        launchFirework(player);
    }

    private void launchFirework(Player player) {
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withFade(Color.YELLOW).with(FireworkEffect.Type.BALL).build());
        meta.setPower(1);
        firework.setFireworkMeta(meta);
        firework.setVelocity(player.getLocation().getDirection().multiply(2));

        Bukkit.getScheduler().runTaskLater(plugin, firework::detonate, 100);
    }
}