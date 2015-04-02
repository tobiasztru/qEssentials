package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import pl.za.xvacuum.qessentials.utils.PlayerManager;

public class KickPlayer implements Listener{
	
	
	
	@EventHandler
	public void playerkick(PlayerKickEvent e){
		PlayerManager.removePlayer(e.getPlayer());
	}
}
