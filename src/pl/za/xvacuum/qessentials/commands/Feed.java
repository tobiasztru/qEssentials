package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Feed extends QCommand{

	public Feed() {
		super("feed", "Dodaje ci punkty glodu", "/feed [gracz]", "feed", Arrays.asList("qfeed", "jedzenie"), false);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(sender, "&cPoprawne uzycie: /feed [gracz]");
			return;
		}
		if(args.length == 1){
			if(sender instanceof Player){
				Player p = (Player)sender;
				p.setFoodLevel(20);
				Util.sendMessage(p, "&7Zostales najedzony!");
				return;
			}else{
				Util.sendMessage(sender, "&cMozesz dodawac punkty glodu tylko innym osobom z poziomu konsoli");
				return;
			}
		}
		if(args.length == 2){
			Player arg = Bukkit.getPlayer(args[0]);
			if(arg == null){
				Util.sendMessage(sender, "&cTaki gracz nie jest online!");
				return;
			}
			arg.setFoodLevel(20);
			Util.sendMessage(sender, "&7Gracz &c" + arg.getName() + "&7 zostal najedzony!");
			
		}
		
	}

}
