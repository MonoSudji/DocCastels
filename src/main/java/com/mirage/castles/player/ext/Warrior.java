package com.mirage.castles.player.ext;

import com.mirage.castles.player.PlayerClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Warrior extends PlayerClass {
    public Warrior() {
        super("Воин", "Мастер ближнего боя, использующий мощные удары.");
    }

    public void useAbility(Player player) {
        createShockwave(player);
    }

    private void createShockwave(Player player) {
        double radius = 5.0;
        int duration = 140;
        double centerX = player.getLocation().getX();
        double centerZ = player.getLocation().getZ();
        Random random = new Random();


        for (double angle = 0; angle < 360; angle += 10) {
            double x = centerX + radius * Math.cos(Math.toRadians(angle)) + (random.nextDouble() - 0.5);
            double z = centerZ + radius * Math.sin(Math.toRadians(angle)) + (random.nextDouble() - 0.5);
            Location location = new Location(player.getWorld(), x, player.getLocation().getY(), z);


            for (Player target : Bukkit.getOnlinePlayers()) {
                if (target.getLocation().distance(location) < 1.5 && target != player) {

                    target.damage(5.0);

                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, 2));
                }
            }
        }

        Bukkit.getLogger().info("Воин " + player.getName() + " создал ударную волну!");
    }
}