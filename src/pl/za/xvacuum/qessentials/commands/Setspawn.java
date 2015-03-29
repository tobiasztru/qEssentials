package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Setspawn extends newCommand{

	public Setspawn() {
		super("setspawn", "Ustawianie spawnu", "/setspawn", "setspawn", Arrays.asList(new String[] { "setspwn", "qsetspawn", "ss" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		int spawnX = p.getLocation().getBlockX();
		int spawnY = p.getLocation().getBlockY();
		int spawnZ = p.getLocation().getBlockZ();
		p.getWorld().setSpawnLocation(spawnX, spawnY, spawnZ);
		Util.sendMessage(p, "&7Pomyslnie ustawiono globalny spawn!");
		
	}

}
