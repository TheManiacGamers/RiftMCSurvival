package me.yeroc.expfly;


import com.sk89q.minecraft.util.commands.ChatColor;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import me.yeroc.riftmcsurvival.RiftMCSurvival;
import me.yeroc.riftmcsurvival.managers.PermissionsManager;
import me.yeroc.riftmcsurvival.managers.StringsManager;
import me.yeroc.riftmcsurvival.utils.CoreysAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Corey on 3/12/2016.
 */
public class EXPFlyCommands {
    CoreysAPI api = CoreysAPI.getInstance();
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    RiftMCSurvival plugin;

    public EXPFlyCommands(RiftMCSurvival plugin) {
        this.plugin = plugin;
    }


    @Command(aliases = "ff", desc = "Toggle EXP Flying on and off.")
    public void onFFCommand(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (p.hasPermission(perms.EXPFly_Use)) {
                if (p.getLevel() >= 1) {
                    if (RiftMCSurvival.expFlyToggle.get(p.getPlayer()).equalsIgnoreCase("on")) {
                        RiftMCSurvival.expFlyToggle.remove(p.getPlayer());
                        RiftMCSurvival.expFlyToggle.put(p.getPlayer(), "off");
                        p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "EXP Flying now" + ChatColor.RED + "" + ChatColor.BOLD + " disabled" + ChatColor.GOLD + ".");
                        p.setAllowFlight(false);
                        return;
                    }
                    if (RiftMCSurvival.expFlyToggle.get(p.getPlayer()).equalsIgnoreCase("off")) {
                        RiftMCSurvival.expFlyToggle.remove(p.getPlayer());
                        RiftMCSurvival.expFlyToggle.put(p.getPlayer(), "on");
                        p.setAllowFlight(true);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "EXP Flying now" + ChatColor.GREEN + "" + ChatColor.BOLD + " enabled" + ChatColor.GOLD + ".");
                    } else {
                        RiftMCSurvival.expFlyToggle.remove(p.getPlayer());
                        RiftMCSurvival.expFlyToggle.put(p.getPlayer(), "off");
                        p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "EXP Flying now" + ChatColor.RED + "" + ChatColor.BOLD + " disabled" + ChatColor.GOLD + ".");
                        p.setAllowFlight(false);
                    }
                } else {
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You have no EXP.");
                }
            } else {
                p.sendMessage(strings.noPermissionCommand);
            }
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }
}