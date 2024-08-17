package com.mirage.castles.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.mirage.castles.player.PlayerClass;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PlayerClassListener extends PacketAdapter {
    private PlayerSelectionGui playerSelectionGui;
    private final Map<Player, Long> cooldowns = new HashMap<>();
    private final JavaPlugin plugin;

    public PlayerClassListener(JavaPlugin plugin) {
        super(plugin, PacketType.Play.Client.STEER_VEHICLE);
        this.plugin = plugin;
    }
    @EventHandler
    public void onBookUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();


        if (item != null && item.getType() == Material.WRITTEN_BOOK) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && "Открыть меню команд".equals(meta.getDisplayName())) {

                event.setCancelled(true);

                player.sendMessage("Вы использовали книжку!");


                playerSelectionGui.openPlayerSelectionGui(player);
            }
        }
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        Player player = event.getPlayer();
        if (event.getPacket().getBooleans().read(0)) {

            if (event.getPacket().getBooleans().read(1)) {
                long currentTime = System.currentTimeMillis();
                if (cooldowns.containsKey(player) && (currentTime - cooldowns.get(player)) < 30000) {
                    player.sendMessage("Способность на перезарядке! Подождите 20 секунд.");
                    return;
                }

                PlayerClass playerClass = PlayerClass.getPlayerClass(player);
                if (playerClass != null) {
                    playerClass.useAbility(player);
                }

                cooldowns.put(player, currentTime);
            }
        }
    }
}