package pl.za.xvacuum.qessentials.commands;


import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.PlayerManager;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class PlayerList extends QCommand{

	public PlayerList() {
		super("list", "Lista graczy", "/list", "list", Arrays.asList(new String[] { "online", "who", "qlist", "qwho", "qonline" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		int number = PlayerManager.getOnlinePlayers().size();
		java.util.List<Player> online = PlayerManager.getOnlinePlayers();
		Util.sendMessage(p, "&7Na serwerze jest &c" + number + "&7 graczy z maksimum &c" + Main.getInstance().getConfig().getInt("server-slots") + "&7!");
		int index = 0;
		for (Player pl : online){
			index++;
			Util.sendMessage(p, "&7" + index + ".  &c" + pl.getName());
		}
		
	}
	
	

}
