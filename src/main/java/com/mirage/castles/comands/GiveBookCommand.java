package com.mirage.castles.comands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Collections;

public class GiveBookCommand implements CommandExecutor {

    private final String teamName = "YourTeamName";

    public GiveBookCommand() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


            if (player.getScoreboard().getPlayerTeam(player) != null &&
                    player.getScoreboard().getPlayerTeam(player).getName().equals(teamName)) {
                return true;
            }

            giveMenuBookToPlayer(player);
            player.sendMessage("Вы получили книгу для открытия меню.");
            return true;
        }
        return false;
    }

    private void giveMenuBookToPlayer(Player player) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        ItemMeta meta = book.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("Открыть меню");
            meta.setLore(Collections.singletonList("Нажмите для открытия меню"));
            book.setItemMeta(meta);
        }
        player.getInventory().addItem(book);
    }
}