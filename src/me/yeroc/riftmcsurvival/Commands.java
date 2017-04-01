package me.yeroc.riftmcsurvival;


import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import me.yeroc.expfly.handlers.EXPHandler;
import me.yeroc.riftmcsurvival.managers.PermissionsManager;
import me.yeroc.riftmcsurvival.managers.StringsManager;
import me.yeroc.riftmcsurvival.utils.CoreysAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Corey on 3/12/2016.
 */
public class Commands {
    CoreysAPI api = CoreysAPI.getInstance();
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    RiftMCSurvival plugin;
    EXPHandler exph = EXPHandler.getInstance();

    public Commands(RiftMCSurvival plugin) {
        this.plugin = plugin;
    }

    @Command(aliases = "flist", desc = "Toggle EXP Flying on and off.")
    public void onList(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(String.valueOf(Bukkit.getOnlinePlayers()));
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }
}