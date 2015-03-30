package pl.za.xvacuum.qessentials.stonegenerator.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;

public class Break implements Listener {
	
	  @EventHandler
	  public void BreakStone(final BlockBreakEvent e)
	  {
	    if (e.getBlock().getType() == Material.STONE) {
	      final Location loc1 = new Location(e.getBlock().getLocation().getWorld(), 
	        e.getBlock().getLocation().getX(), 
	        e.getBlock().getLocation().getY() - 1.0D, 
	        e.getBlock().getLocation().getZ());
	      if (loc1.getBlock().getType() == Material.ENDER_STONE)
	        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable()
	        {
	          public void run() {
	            if (loc1.getBlock().getType() == Material.ENDER_STONE)
	              e.getBlock().setType(Material.STONE);
	          }
	        }
	        , 25L);
	    }
	  }

	  @EventHandler
	  public void BreakStoneGenerator(BlockBreakEvent e)
	  {
	    if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
	      ItemStack drop = new ItemStack(Material.ENDER_STONE, 1);
	      ItemMeta meta = drop.getItemMeta();
	      meta.setDisplayName("§7Stoniarka");
	      drop.setItemMeta(meta);
	      if (e.getBlock().getType() == Material.ENDER_STONE) {
	          e.getBlock().setType(Material.AIR);
	          e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop);
	          e.setCancelled(true);
	          Util.sendMessage(e.getPlayer(), "&7Zniszczyles stoniarke!");
	        }
	      }
	    }
	  }


