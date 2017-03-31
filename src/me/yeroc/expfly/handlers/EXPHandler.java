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

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Corey on 31/03/2017.
 */
public class EXPHandler {
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    CoreysAPI api = CoreysAPI.getInstance();
    static EXPHandler instance = new EXPHandler();
    public ArrayList<Player> onlineList = new ArrayList<Player>();

    private EXPHandler() {
    }

    public static EXPHandler getInstance() {
        return instance;
    }

//    public void checkExp() {
//        Bukkit.getScheduler().scheduleSyncRepeatingTask(RiftMCSurvival.plugin, new BukkitRunnable() {
//            @Override
//            public void run() {
//                for (Player p : Bukkit.getOnlinePlayers()) {
//
//                }
//            }
//        }, 20L, 20L);
//    }

    public void checkExp() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(RiftMCSurvival.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player ap : Bukkit._INVALID_getOnlinePlayers()) {
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
                }
            }
        }, 20L, 20L);
    }

    public void updateOnlineList() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (onlineList == null) {
                onlineList.add(p.getPlayer());
            } else {
                onlineList.clear();
                onlineList.add(p.getPlayer());
            }
        }
    }
}
