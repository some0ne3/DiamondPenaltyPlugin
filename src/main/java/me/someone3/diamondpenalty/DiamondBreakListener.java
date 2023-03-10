package me.someone3.diamondpenalty;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DiamondBreakListener implements Listener {

    private final DiamondPenaltyPlugin plugin;

    public DiamondBreakListener(DiamondPenaltyPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onDiamondBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (!block.getType().name().contains("DIAMOND_ORE")) return;

        Player player = event.getPlayer();
        if (player.hasPermission("diamondpenalty.bypass")) return;
        if (!player.hasPermission("diamondpenalty.penalty")) return;

        ItemStack playerTool = player.getInventory().getItemInMainHand();
        int dropSize = block.getDrops(playerTool).size();
        if (dropSize == 0) return;

        if (Math.random() < plugin.getConfig().getDouble("penalty-chance")) {
            event.setDropItems(false);
            event.setExpToDrop(0);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, dropSize));
        }

    }
}
