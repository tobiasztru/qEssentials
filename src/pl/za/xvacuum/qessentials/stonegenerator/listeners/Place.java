package pl.za.xvacuum.qessentials.stonegenerator.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;


public class Place implements Listener {
	
	@EventHandler
	  public void PlaceStoneGenerator(BlockPlaceEvent e)
	  {
	    if (e.getBlock().getType() == Material.ENDER_STONE) {
	      final Location loc1 = new Location(e.getBlock().getLocation().getWorld(), 
	        e.getBlock().getLocation().getX(), 
	        e.getBlock().getLocation().getY() + 1.0D, 
	        e.getBlock().getLocation().getZ());

	      if (loc1.getBlock().getType() == Material.AIR) {
	        e.getBlock().getLocation();
	        e.getBlock().getWorld();
	          Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
	            public void run() {
	              loc1.getBlock().setType(Material.STONE);
	            }
	          }
	          , 60L);
	        }
	        else {
	          e.setCancelled(true);
	          Util.sendMessage(e.getPlayer(), "&cNie mozesz tu stawiac stoniarek!");
	        }
	      }
	      else {
	    	  Util.sendMessage(e.getPlayer(), "&cNad stoniarka jest juz jakis blok!");
	      }
	    }
	  }


