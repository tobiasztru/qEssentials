package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TimeUtil;

public class Home extends QCommand{

	public Home() {
		super("home", "Teleportuje do domu", "/home", "home", Arrays.asList(new String[] { "qhome", "h", "dom", "qdom", "qd", "qh" }), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		QPlayer q = MetadataStorage.getFromPlayer(p);
		TimeUtil.teleportDelay(p, q.getHome());
		
	}

}
