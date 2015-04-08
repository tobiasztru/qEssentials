package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.flatfile.Flat;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;
import pl.za.xvacuum.qessentials.mysql.QueryStream;
import pl.za.xvacuum.qessentials.objects.DataContainer;
import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.PlayerManager;
import pl.za.xvacuum.qessentials.utils.Util;

public class Join implements Listener {
	
	
	@EventHandler
	public void playerjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String format = Main.getInstance().getConfig().getString("join-format");
		if (format.isEmpty()){
			e.setJoinMessage(null);
		}else{
			e.setJoinMessage(Util.setHEX(format.replace("{PLAYER}", p.getName())));
		}
		
		if(DataContainer.getQPlayer(p.getName()) == null) {
			QPlayer q = new QPlayer(p.getName());
			World w = p.getWorld();
			int x = w.getSpawnLocation().getBlockX();
			int y = w.getSpawnLocation().getBlockY();
			int z = w.getSpawnLocation().getBlockZ();
			if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
					q.setFly(false);
					q.setGm(GameMode.SURVIVAL); 
					q.setGod(false);
					q.setHome(new Location(w, x, y ,z));
					q.setMute(0L);					
					q.setChanged(true);
					QueryStream.sendQuery(new EncapsulatedQuery(String.format("INSERT INTO `players` VALUES ('%s', '%d', '%d', '%d', '%s', '%d', '%d', '%d')", p.getName(), x, y, z, p.getWorld().getName(), 0, 0, 0L)));
					DataContainer.addQPlayer(q);
					MetadataStorage.insert(p);
					LogUtil.info("Wprowadzono gracza do MySQL: " + p.getName());
				} else {
					Flat.createPlayerData(p.getName());
					q.setFly(false);
					q.setGm(GameMode.SURVIVAL); 
					q.setGod(false);
					q.setHome(new Location(w, x, y ,z));
					q.setMute(0L);					
					q.setChanged(true);
					q.save();
					DataContainer.addQPlayer(q);
					MetadataStorage.insert(p);
					LogUtil.info("Stworzono flatfile userdata playera " + p.getName());
				}
		}
		MetadataStorage.insert(p);
		PlayerManager.addPlayer(p);
	}

}
