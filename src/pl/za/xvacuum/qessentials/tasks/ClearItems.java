package pl.za.xvacuum.qessentials.tasks;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;

public class ClearItems implements Runnable
{
	
	// Clearitems podes³ane przez Kreserek007, dziêki!

	@Override
	public void run() {
		Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("clear-first").replace("{TIME}", String.valueOf(Main.getInstance().getConfig().getLong("clear-delay-1")))));
		Bukkit.getScheduler().runTaskLater(Main.getInstance(), (Runnable)new Runnable(){
			public void run() {
	        	String worldname = Main.getInstance().getConfig().getString("clear-world");
	        	World world = Bukkit.getServer().getWorld(worldname);
	            List<Entity> entList = world.getEntities();
	            Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("clear-cleared")));
	            for(Entity current : entList){
	            	if (current instanceof Item){
	            		 current.remove();
	            	}
	            }
			}
		
		}, Main.getInstance().getConfig().getLong("clear-delay-1") * 20);
		
	}
}
