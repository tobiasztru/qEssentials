package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Spawn extends newCommand{

	public Spawn() {
		super("spawn", "Teleportacja na spawn", "/spawn [player]", "spawn", Arrays.asList(new String[] { "spwn", "qspawn" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		TimeUtil.teleportDelay(p, p.getWorld().getSpawnLocation());
		
	}

}
