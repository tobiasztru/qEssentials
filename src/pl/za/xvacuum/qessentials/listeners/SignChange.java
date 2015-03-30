package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import pl.za.xvacuum.qessentials.utils.Util;

public class SignChange implements Listener{
	
	@EventHandler
	public void onchangesign(SignChangeEvent e){
		if(e.getPlayer().hasPermission("qessentials.sign.color")){
			for (int i = 0; i <= 3; i++){
				e.setLine(i, Util.setHEX(e.getLine(i)));
			}
		}
	}

}
