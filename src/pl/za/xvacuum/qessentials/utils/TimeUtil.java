package pl.za.xvacuum.qessentials.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;

public class TimeUtil{
	
	public final static List<Player> list = new ArrayList<Player>();
	
	public static void teleportDelay(final Player player, final Location loc)
	{
		if(player.hasPermission("qessentials.teleport.bypass")){
			BackUtil.setLastLocation(player, player.getLocation());
			player.teleport(loc);
			Util.sendMessage(player, "&7Zostales przeteleportowany!");
			return;
		}
		
		list.add(player);
		Util.sendMessage(player, "&7Zaczekaj &c" + Main.getInstance().getConfig().getLong("tp-delay") + "&7 sekund!".replace("L", ""));
		Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
		    public void run() {
		    	if(list.contains(player)){
		    		if(!player.isOnline()) {
		    			list.remove(player);
		    			return;
		    		}
		    		
		    	   BackUtil.setLastLocation(player, player.getLocation());
			       player.teleport(loc);
			       list.remove(player);
			       Util.sendMessage(player, "&7Zostales przeteleportowany!");
			       Main.getInstance().getServer().getScheduler().cancelAllTasks();
		    	}
		    }
		}, Main.getInstance().getConfig().getLong("tp-delay") * 20); 
	}

	
	
	
	public static String parseTime(long time) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		Date d = new Date(time);
		return format.format(d);
	}
	
	public static String parseTimeHour(long time) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss", Locale.GERMANY);
		Date d = new Date(time);
		return format.format(d);
	}
	
	
	public static long parseStringToTime(int liczba, String jednostka){
		switch(jednostka){
			case "sec"://Jak daæ drugie min i minuty do 1
				@SuppressWarnings("unused")
				long sec = liczba * 1000;
			case "min":
				@SuppressWarnings("unused")
				long min = liczba * 1000 * 60;
			case "h":
				@SuppressWarnings("unused")
				long h = liczba * 1000 * 60 * 60;
				
		}
		return 0;
	}
}
