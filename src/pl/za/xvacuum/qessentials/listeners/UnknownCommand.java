package pl.za.xvacuum.qessentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;

public class UnknownCommand implements Listener{
	
	public static FileConfiguration cfg = Main.getInstance().getConfig();
	
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if(!Main.getInstance().getConfig().getBoolean("uc-enabled")){
			return;
		}
		if ((!event.isCancelled())) {
			String command = event.getMessage().split(" ")[0];
			HelpTopic htopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
			if (htopic == null) {
				for (String s : cfg.getStringList("uc-msg")) {
					Util.sendMessage(p, s);
				}
				event.setCancelled(true);
				return;
			}
		}
	}

}
