package me.someone3.diamondpenalty;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiamondPenaltyCommand implements CommandExecutor {

    private final DiamondPenaltyPlugin plugin;

    public DiamondPenaltyCommand(DiamondPenaltyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("diamondpenalty.reload")) {
                sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
                return true;
            }
            plugin.reloadConfig();
            plugin.saveConfig();
            sender.sendMessage(ChatColor.DARK_GREEN + "Config reloaded.");
            return true;
        }
        return false;
    }
}
