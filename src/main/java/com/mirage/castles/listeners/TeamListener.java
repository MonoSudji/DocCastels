package com.mirage.castles.listeners;

import com.mirage.castles.Castels;
import com.mirage.castles.teams.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;

public class TeamListener implements Listener {

    private final Castels plugin;

    public TeamListener(Castels plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();

            Team attackerTeam = plugin.TeamPlayer.get(attacker.getUniqueId());
            Team victimTeam = plugin.TeamPlayer.get(victim.getUniqueId());


            if (attackerTeam == null && victimTeam == null) {
                event.setCancelled(true);
                return;
            }


            if (attackerTeam != null && victimTeam != null && attackerTeam.getName().equals(victimTeam.getName())) {
                event.setCancelled(true);
                attacker.sendMessage("§cВы не можете атаковать игрока своей команды!");
            }
        }
    }
}