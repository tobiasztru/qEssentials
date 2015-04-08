package pl.za.xvacuum.qessentials.commands;


import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class PlayerList extends QCommand{

	public PlayerList() {
		super("list", "Lista graczy", "/list", "list", Arrays.asList(new String[] { "online", "who", "qlist", "qwho", "qonline" }), false);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		@SuppressWarnings("deprecation")
		int number = Bukkit.getOnlinePlayers().length;
		@SuppressWarnings("deprecation")
		Player[] online = Bukkit.getOnlinePlayers();
		int slots = Main.getInstance().getConfig().getInt("server-slots");
		if(slots == 0){
			slots = Bukkit.getMaxPlayers();
		}
		Util.sendMessage(sender, "&7Na serwerze jest &c" + number + "&7 graczy z maksimum &c" + slots + "&7!");
		int index = 0;
		for (Player pl : online){
			index++;
			Util.sendMessage(sender, "&7" + index + ".  &c" + pl.getName());
		}
		
	}
	
	

}
