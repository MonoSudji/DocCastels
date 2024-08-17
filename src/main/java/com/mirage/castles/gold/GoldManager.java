package com.mirage.castles.gold;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.PlayerInventory;

public class GoldManager {

    public void convertGold(Player player) {
        PlayerInventory inventory = player.getInventory();
        int nuggets = countItems(inventory, Material.GOLD_NUGGET);
        int ingots = countItems(inventory, Material.GOLD_INGOT);
        int blocks = countItems(inventory, Material.GOLD_BLOCK);


        while (nuggets >= 50) {
            inventory.removeItem(new ItemStack(Material.GOLD_NUGGET, 50));
            inventory.addItem(new ItemStack(Material.GOLD_INGOT, 1));
            nuggets -= 50;
        }


        while (ingots >= 5) {
            inventory.removeItem(new ItemStack(Material.GOLD_INGOT, 5));
            inventory.addItem(new ItemStack(Material.GOLD_BLOCK, 1));
            ingots -= 5;
        }

        updateGoldCounter(player, nuggets, ingots, blocks);
    }

    private int countItems(PlayerInventory inventory, Material material) {
        int count = 0;
        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == material) {
                count += item.getAmount();
            }
        }
        return count;
    }

    private void updateGoldCounter(Player player, int nuggets, int ingots, int blocks) {
        int totalGold = nuggets + (ingots * 50) + (blocks * 450);
        String message = String.format("Общее количество золота: %d", totalGold);
        player.sendMessage(message);
    }
}