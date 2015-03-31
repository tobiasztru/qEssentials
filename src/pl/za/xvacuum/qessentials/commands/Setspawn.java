package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Setspawn extends QCommand{

	public Setspawn() {
		super("setspawn", "Ustawianie spawnu", "/setspawn", "setspawn", Arrays.asList(new String[] { "setspwn", "qsetspawn", "ss" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		int spawnX = p.getLocation().getBlockX();
		int spawnY = p.getLocation().getBlockY();
		int spawnZ = p.getLocation().getBlockZ();
		World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn-world"));
		world.setSpawnLocation(spawnX, spawnY, spawnZ);
		Util.sendMessage(p, "&7Pomyslnie ustawiono globalny spawn!");
		
	}

}
