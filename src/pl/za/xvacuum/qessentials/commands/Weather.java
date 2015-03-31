package pl.za.xvacuum.qessentials.commands;


import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Weather extends QCommand{

	public Weather() {
		super("weather", "Manipulacja pogoda", "/weather <sun/thunder>", "weather", Arrays.asList(new String[] { "qweather", "qw", "pogoda", "qpogoda" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		World world = Bukkit.getWorld(p.getWorld().getName());
		if(args.length == 0){
			Util.sendMessage(p, "&cPoprawne uzycie: /weather <sun/thunder>");
			return;
		}else if (args.length == 1){
			if(args[0].equalsIgnoreCase("sun")){
				world.setStorm(false);
				Util.sendMessage(p, "&7Ustawiono pogode swiata &c'"+p.getWorld().getName()+"' &7na &csloneczna");
				return;
			}else if (args[0].equalsIgnoreCase("thunder")){
				world.setStorm(true);
				Util.sendMessage(p, "&7Ustawiono pogode swiata &c'"+p.getWorld().getName()+"' &7na &cdeszczowa");
				return;
			}else{
				Util.sendMessage(p, "&cPoprawne uzycie: /weather <sun/thunder>");
				return;
			}
		}
		
	}

}
