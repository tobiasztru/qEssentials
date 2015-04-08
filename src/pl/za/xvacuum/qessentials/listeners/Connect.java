package pl.za.xvacuum.qessentials.listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;
import pl.za.xvacuum.qessentials.mysql.QueryStream;
import pl.za.xvacuum.qessentials.objects.DataContainer;
import pl.za.xvacuum.qessentials.objects.QBan;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Connect implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerConnect(PlayerLoginEvent e)
	{
		Player p = e.getPlayer();
		
		QBan ban = DataContainer.getBan(p.getName());
		
		if(ban == null) {
			if(Bukkit.getOnlinePlayers().length >= Bukkit.getMaxPlayers()) {
			if(p.hasPermission("qessentials.joinfullserver")){
				e.allow();
				return;
			}else{
				e.disallow(Result.KICK_FULL, "§cSerwer jest pelny!");
				return;
			}
			}
			return;
		}

		
		if(ban.getValidateTill() <= System.currentTimeMillis() && ban.getValidateTill() != 0L) {
			if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
				QueryStream.sendQuery(new EncapsulatedQuery(String.format("DELETE FROM bans WHERE `victim`=`%s%`", p.getName())));
			} else {
				File folder = new File(Main.getInstance().getDataFolder(), "bandata");
				
				File f = new File(folder, p.getName() + ".yml");
				if(f.exists()) {
					f.delete();
				}
			}
			DataContainer.removeBan(ban);
			return;
		}
		
		String reason = ban.getReason();
		String punisher = ban.getPunisher();
		String waznyDo = ban.getValidateTill() == 0L ? "&cpermamentny" : "&a" + TimeUtil.parseTimeHour(ban.getValidateTill());
		String msg = Util.setHEX(String.format("&6Otrzymales bana...\n&7Nadajacy: &c%s\n&7Powod: &c%s\n&7Data nadania:&c %s\n&7Wazny do: %s", punisher, reason, TimeUtil.parseTimeHour(ban.getBanTime()), waznyDo));
		e.disallow(Result.KICK_OTHER, msg);
	}

}
