package com.mirage.castles.gui;

import com.mirage.castles.Castels;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelectionGui {

    private final Castels castles;

    public SelectionGui(Castels castles) {
        this.castles = castles;
    }

    public void openClassSelectionGui(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Выбор класса");

        ItemStack warriorItem = createItemStack(Material.IRON_SWORD, "Воин");
        ItemStack mageItem = createItemStack(Material.BLAZE_ROD, "Маг");
        ItemStack archerItem = createItemStack(Material.BOW, "Лучник");

        inventory.setItem(11, warriorItem);
        inventory.setItem(13, mageItem);
        inventory.setItem(15, archerItem);

        player.openInventory(inventory);
    }

    public void openPlayerSelectionGui(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Выбор количества игроков");

        ItemStack twoPlayersItem = createItemStack(Material.BOOK, "2 Игрока");
        ItemStack fourPlayersItem = createItemStack(Material.BOOK, "4 Игрока");

        inventory.setItem(11, twoPlayersItem);
        inventory.setItem(15, fourPlayersItem);

        player.openInventory(inventory);
    }

    public void openTeamSelectionGui(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Выбор команды");

        ItemStack glassPane = createItemStack(Material.WHITE_STAINED_GLASS_PANE, " ");
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glassPane);
        }

        ItemStack blueTeamItem = createItemStack(Material.BLUE_WOOL, "Команда Синий");
        ItemStack redTeamItem = createItemStack(Material.RED_WOOL, "Команда Красный");

        inventory.setItem(11, blueTeamItem);
        inventory.setItem(15, redTeamItem);

        player.openInventory(inventory);
    }

    private static ItemStack createItemStack(Material material, String displayName) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }
}