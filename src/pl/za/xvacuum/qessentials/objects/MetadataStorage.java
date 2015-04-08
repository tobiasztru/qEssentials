package pl.za.xvacuum.qessentials.objects;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import pl.za.xvacuum.qessentials.Main;


public class MetadataStorage {

	public static void insert(Player p) {
		p.setMetadata("user",new FixedMetadataValue(Main.getInstance(), DataContainer.getQPlayer(p.getName())));
	}
	
	
	public static QPlayer getFromPlayer(Player p) {
		if (p.hasMetadata("user")) {
			QPlayer user = null;
			for (MetadataValue mv : p.getMetadata("user")) {
				if (mv.getOwningPlugin().getName()
						.equalsIgnoreCase("qEssentials")) {
					Object v = mv.value();
					if ((v instanceof QPlayer)) {
						user = (QPlayer) v;
					}
				}
			}
			return user;
		}
		return null;
	}

	

}
