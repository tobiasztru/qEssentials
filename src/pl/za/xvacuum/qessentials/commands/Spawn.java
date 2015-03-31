package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Spawn extends QCommand{

	public Spawn() {
		super("spawn", "Teleportacja na spawn", "/spawn [player]", "spawn", Arrays.asList(new String[] { "spwn", "qspawn" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn-world"));
		TimeUtil.teleportDelay(p, world.getSpawnLocation());
		
	}

}
