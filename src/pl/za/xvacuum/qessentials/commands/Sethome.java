package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.HomeUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Sethome extends newCommand{

	public Sethome() {
		super("sethome", "Ustawia dom", "/sethome", "sethome", Arrays.asList(new String[] { "qsethome", "sh", "ustawdom", "qustawdom", "qud", "qsh" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		HomeUtil home = new HomeUtil(p.getName());
		home.setHome(p.getLocation());
		Util.sendMessage(p, "&7Pomyslnie ustawiono lokacje domu! &c(x: " + p.getLocation().getBlockX() + ", y: " + p.getLocation().getBlockY() + ", z: " + p.getLocation().getBlockZ() + ")");
	}

}
