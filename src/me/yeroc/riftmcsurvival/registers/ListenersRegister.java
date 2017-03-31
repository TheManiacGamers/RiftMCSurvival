package me.yeroc.riftmcsurvival.registers;

import me.yeroc.riftmcsurvival.RiftMCSurvival;
import me.yeroc.riftmcsurvival.listeners.PVPListener;
import me.yeroc.riftmcsurvival.listeners.PlayerListener;
import org.bukkit.plugin.PluginManager;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class ListenersRegister {
    RiftMCSurvival plugin;

    public ListenersRegister(RiftMCSurvival plugin) {
        this.plugin = plugin;
    }

    public ListenersRegister() {

    }

    public static ListenersRegister instance = new ListenersRegister();

    public static ListenersRegister getInstance() {
        return instance;
    }

    public void registerListeners(RiftMCSurvival plugin) {
        RiftMCSurvival.log("Enabling the listener classes.");
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new PlayerListener(plugin), plugin);
        RiftMCSurvival.log("Player Listener Class was registered.");

        pm.registerEvents(new PVPListener(plugin), plugin);
        RiftMCSurvival.log("PVPListener Class was registered.");

        RiftMCSurvival.log("All Listener Classes were registered.");

    }
}
