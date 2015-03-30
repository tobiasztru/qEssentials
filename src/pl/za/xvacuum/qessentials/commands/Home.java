package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.HomeUtil;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Home extends QCommand{

	public Home() {
		super("home", "Teleportuje do domu", "/home", "home", Arrays.asList(new String[] { "qhome", "h", "dom", "qdom", "qd", "qh" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		HomeUtil home = new HomeUtil(p.getName());
		if(!home.hasHome()){
			Util.sendMessage(p, "&cMusisz posiadac ustawiony dom!");
			return;
		}
		TimeUtil.teleportDelay(p, home.getHomeLocation());
		
	}

}
