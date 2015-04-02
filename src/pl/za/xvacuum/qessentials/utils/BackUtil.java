package pl.za.xvacuum.qessentials.utils;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BackUtil {
	
	public static HashMap<Player, Location> lastLoc = new HashMap<Player, Location>();
	
	public static Location getLastLocation(Player p)
	{
		return lastLoc.get(p);
	}
	
	public static void setLastLocation(Player p, Location loc)
	{
		lastLoc.put(p, loc);
	}
	
	public static HashMap<Player, Location> getMap()
	{
		return lastLoc;
	}

}
