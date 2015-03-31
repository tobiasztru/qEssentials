package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class World extends QCommand{

	public World() {
		super("world", "Teleportacja miedzy swiatami", "/world <world>", "world", Arrays.asList(new String[] { "w", "qw", "qworld", "swiat", "qswiat" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0 ) || (args.length >= 2 )){
			Util.sendMessage(p, "&cPoprawne uzycie: /world <swiat>");
			Util.sendMessage(p, "&cDostepne swiaty:");
			List<org.bukkit.World> worlds = Bukkit.getWorlds(); 
			for (org.bukkit.World w : worlds){
				Util.sendMessage(p, "&c   '" + w.getName() + "'");
			}
			return;
		}
		org.bukkit.World w = Bukkit.getWorld(args[0]); 
		if(w == null){
			Util.sendMessage(p, "&cTaki swiat nie istnieje!");
			return;
		}else{
			TimeUtil.teleportDelay(p, w.getSpawnLocation());
			return;
		}
		
		
	}

}
