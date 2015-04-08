package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;

public class PlayerGod implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent evt) {
		if((evt.getEntity() instanceof Player)) {
			Player p = (Player) evt.getEntity();
			QPlayer q = MetadataStorage.getFromPlayer(p);
			if(q == null) {
				return;
			}
			
			if(q.isGod()) {
				evt.setCancelled(true);
				return;
			}
		}
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent evt) {
		if((evt.getEntity() instanceof Player)) {
			Player p = (Player) evt.getEntity();
			QPlayer q =MetadataStorage.getFromPlayer(p);
			if(q == null) {
				return;
			}
			if(q.isGod()) {
				evt.setCancelled(true);
				return;
			}
		}
	}
	
	
	
}
