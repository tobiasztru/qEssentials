package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Sethome extends QCommand{

	public Sethome() {
		super("sethome", "Ustawia dom", "/sethome", "sethome", Arrays.asList(new String[] { "qsethome", "sh", "ustawdom", "qustawdom", "qud", "qsh" }), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		QPlayer qp =  MetadataStorage.getFromPlayer(p);
		qp.setHome(p.getLocation());
		Util.sendMessage(p, "&7Pomyslnie ustawiono lokacje domu! &c(x: " + p.getLocation().getBlockX() + ", y: " + p.getLocation().getBlockY() + ", z: " + p.getLocation().getBlockZ() + ")");
	}

}
