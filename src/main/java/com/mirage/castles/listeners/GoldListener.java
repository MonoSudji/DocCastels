package com.mirage.castles.listeners;

import com.mirage.castles.gold.GoldManager;
import com.mirage.castles.Castels;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class GoldListener implements Listener {

    private final GoldManager goldManager;
    private final Castels plugin;

    public GoldListener(GoldManager goldManager, Castels plugin) {
        this.goldManager = goldManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
        Player player = event.getPlayer();

        if (item.getType() == Material.GOLD_NUGGET || item.getType() == Material.GOLD_INGOT) {
            goldManager.convertGold(player);
        }
    }
}