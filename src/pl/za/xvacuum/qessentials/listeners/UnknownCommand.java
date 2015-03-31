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
		if ((!event.isCancelled()) && (p.hasPermission("CUC.message"))) {
			String command = event.getMessage().split(" ")[0];
			HelpTopic htopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
			if (htopic == null) {
				if(cfg.getBoolean("uc-oneline") == true){
					Util.sendMessage(p, cfg.getString("uc-oneline-msg"));
				}else if (cfg.getBoolean("uc-oneline") == false){
					for (String s : cfg.getStringList("uc-multiline-msg")){
						Util.sendMessage(p, s);
					}
				}
				event.setCancelled(true);
				return;
			}
		}
	}

}
