package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;




import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Time extends newCommand{

	public Time() {
		super("time", "Manipulacja czasem", "/time <day/night>", "time", Arrays.asList(new String[] { "qtime", "qt", "czas", "qczas" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		World world = Bukkit.getWorld(p.getWorld().getName());
		if(args.length == 0){
			Util.sendMessage(p, "&cPoprawne uzycie: /time <day/night>");
			return;
		}else if (args.length == 1){
			if(args[0].equalsIgnoreCase("day")){
				world.setTime(2500L);
				Util.sendMessage(p, "&7Ustawiono czas swiata &c'"+p.getWorld().getName()+"' &7na &cdzien");
				return;
			}else if (args[0].equalsIgnoreCase("night")){
				world.setTime(14500L);
				Util.sendMessage(p, "&7Ustawiono czas swiata &c'"+p.getWorld().getName()+"' &7na &cnoc");
				return;
			}else{
				Util.sendMessage(p, "&cPoprawne uzycie: /time <day/night>");
				return;
			}
		}
		
	}

}
