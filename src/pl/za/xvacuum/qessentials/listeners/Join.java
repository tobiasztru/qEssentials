package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.PlayerManager;
import pl.za.xvacuum.qessentials.utils.Util;

public class Join implements Listener {
	
	
	@EventHandler
	public void playerjoin(PlayerJoinEvent e){
		String format = Main.getInstance().getConfig().getString("join-format");
		if (format.isEmpty()){
			e.setJoinMessage(null);
		}else{
			e.setJoinMessage(Util.setHEX(format.replace("{PLAYER}", e.getPlayer().getName())));
		}
		PlayerManager.addPlayer(e.getPlayer());
	}

}
