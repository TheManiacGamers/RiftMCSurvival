package me.yeroc.riftmcsurvival.listeners;

import me.yeroc.riftmcsurvival.RiftMCSurvival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Corey on 26/03/2017.
 */
public class PlayerListener implements Listener {

    RiftMCSurvival plugin;

    public PlayerListener(RiftMCSurvival plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        RiftMCSurvival.expFlyToggle.remove(p.getPlayer());
        RiftMCSurvival.expFlyToggle.put(p.getPlayer(), "off");
    }
}
