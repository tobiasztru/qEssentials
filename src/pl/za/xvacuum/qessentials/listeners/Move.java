package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Move implements Listener{

	
	@EventHandler(priority = EventPriority.LOW)
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location nfrom = e.getFrom();
		Location nto = e.getTo();
		
		if(nfrom == null || nto == null) return;
		if(nfrom.getBlockX() == nto.getBlockX() && nfrom.getBlockZ() == nto.getBlockZ()) return;
		
		if(TimeUtil.list.contains(p)){
			TimeUtil.list.remove(p);
			Util.sendMessage(p, "&cRuszyles sie! Teleport przerwany...");
		}
		
	}
}
