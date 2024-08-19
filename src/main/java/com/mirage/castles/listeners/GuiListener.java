package com.mirage.castles.listeners;

import com.mirage.castles.Castels;
import com.mirage.castles.gui.SelectionGui;
import com.mirage.castles.player.PlayerClass;
import com.mirage.castles.player.ext.Archer;
import com.mirage.castles.player.ext.Mage;
import com.mirage.castles.player.ext.Warrior;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class GuiListener implements Listener {

    private final Castels castles;
    private final SelectionGui selectionGui;
    private final Set<Player> waitingForTwoPlayers = new HashSet<>();
    private final Set<Player> waitingForFourPlayers = new HashSet<>();

    public GuiListener(Castels castles) {
        this.castles = castles;
        this.selectionGui = new SelectionGui(castles);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Выбор количества игроков")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String displayName = clickedItem.getItemMeta().getDisplayName();
                if (displayName.equals("2 Игрока")) {
                    if (waitingForTwoPlayers.contains(player)) {
                        waitingForTwoPlayers.remove(player);
                        player.sendMessage("§fВы вышли из ожидания на 2 игр��ка.");
                    } else {
                        waitingForTwoPlayers.add(player);
                        player.sendMessage("§fВы вошли в ожидание на 2 игрока.");
                        selectionGui.openTeamSelectionGui(player);
                    }
                } else if (displayName.equals("4 Игрока")) {
                    if (waitingForFourPlayers.contains(player)) {
                        waitingForFourPlayers.remove(player);
                        player.sendMessage("§fВы вышли из ожидания на 4 игрока.");
                    } else {
                        waitingForFourPlayers.add(player);
                        player.sendMessage("§fВы вошли в ожидание на 4 игрока.");
                        selectionGui.openTeamSelectionGui(player);
                    }
                }
            }
        } else if (event.getView().getTitle().equals("Выбор команды")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String displayName = clickedItem.getItemMeta().getDisplayName();
                selectionGui.openClassSelectionGui(player);
            }
        } else if (event.getView().getTitle().equals("Выбор класса")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String displayName = clickedItem.getItemMeta().getDisplayName();
                PlayerClass playerClass = null;

                switch (displayName) {
                    case "Воин":
                        playerClass = new Warrior();
                        break;
                    case "Маг":
                        playerClass = new Mage();
                        break;
                    case "Лучник":
                        playerClass = new Archer();
                        break;
                }

                if (playerClass != null) {
                    PlayerClass.setPlayerClass(player, playerClass);
                    player.sendMessage("Вы выбрали класс: " + playerClass.getName());
                }
            }
        }
    }
}
