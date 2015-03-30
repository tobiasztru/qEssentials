package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Fly extends QCommand{

	public Fly() {
		super("fly", "Latanie", "/fly <on/off> <player>", "fly", Arrays.asList(new String[] { "qfly", "lataj", "ql", "qf" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 1)
		{
			if(args[0].equalsIgnoreCase("on")){
				p.setFlying(true);
				Util.sendMessage(p, "&7Wlaczyles sobie latanie!");
				return;
			}else if (args[0].equalsIgnoreCase("off")){
				p.setFlying(false);
				Util.sendMessage(p, "&7Wylaczyles sobie latanie!");
				return;
			}
		}else if (args.length == 2){
			Player pl = Bukkit.getPlayerExact(args[1]);
			if (pl == null){
				Util.sendMessage(p, "&cGracz nie jest na serwerze!");
				return;
			}
			if(args[0].equalsIgnoreCase("on")){
				pl.setFlying(true);
				Util.sendMessage(p, "&7Wlaczyles graczowi&c " + pl.getName() + "&7 latanie!");
				return;
			}else if (args[0].equalsIgnoreCase("off")){
				pl.setFlying(false);
				Util.sendMessage(p, "&7Wylaczyles graczowi&c " + pl.getName() + "&7 latanie!");
				return;
			}	
		}else{
			Util.sendMessage(p, "&cPoprawne uzycie: /fly <gracz>");
			return;
		}
		
	}

}
