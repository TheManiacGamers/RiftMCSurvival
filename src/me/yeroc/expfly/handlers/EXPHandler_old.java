package me.yeroc.expfly.handlers;


import com.sk89q.minecraft.util.commands.ChatColor;
import me.yeroc.riftmcsurvival.RiftMCSurvival;
import me.yeroc.riftmcsurvival.managers.PermissionsManager;
import me.yeroc.riftmcsurvival.managers.StringsManager;
import me.yeroc.riftmcsurvival.utils.ActionBarUtil.ActionBar;
import me.yeroc.riftmcsurvival.utils.CoreysAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Corey on 26/03/2017.
 */
public class EXPHandler_old {
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    CoreysAPI api = CoreysAPI.getInstance();
    static EXPHandler_old instance = new EXPHandler_old();

    private EXPHandler_old() {
    }

    public static EXPHandler_old getInstance() {
        return instance;
    }

    public void expCheck() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(RiftMCSurvival.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() != 0) {
                    for (Player ap : Bukkit.getOnlinePlayers()) {
                        if (ap.hasPermission(perms.EXPFly_Use)) {
                            if (RiftMCSurvival.expFlyToggle.get(ap.getPlayer()).equalsIgnoreCase("on")) {
                                ap.setLevel(ap.getLevel() - 1);
                                if (ap.getLevel() == 10) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 5) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 4) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 3) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 2) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 1) {
                                    ActionBar.send(ap.getPlayer(), ChatColor.RED + "WARNING: LOW EXP!!");
                                    return;
                                }
                                if (ap.getLevel() == 0) {
                                    ap.sendMessage(strings.defaultMsgs + ChatColor.RED + "EXP Flying has been disabled.");
                                    RiftMCSurvival.expFlyToggle.remove(ap.getPlayer());
                                    RiftMCSurvival.expFlyToggle.put(ap.getPlayer(), "off");
                                    ap.setAllowFlight(false);
                                    return;
                                }

                                return;
                            }
                            if (RiftMCSurvival.expFlyToggle.get(ap.getPlayer()).equalsIgnoreCase(null)) {
                                RiftMCSurvival.expFlyToggle.remove(ap.getPlayer());
                                RiftMCSurvival.expFlyToggle.put(ap.getPlayer(), "off");
                            }
                            return;
                        }
                        return;
                    }
                }
                // no return needed
            }
        }, 20L, 20L);
    }

}
