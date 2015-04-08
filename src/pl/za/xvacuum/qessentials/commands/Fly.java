package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Fly extends QCommand{

	public Fly() {
		super("fly", "Latanie", "/fly <on/off> <player>", "fly", Arrays.asList(new String[] { "qfly", "lataj", "ql", "qf" }), false);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if(args.length == 1)
		{
			if(sender instanceof Player){
				Player p = (Player)sender;
				if(args[0].equalsIgnoreCase("on")){
					p.setAllowFlight(true);
					p.setFlying(true);
					Util.sendMessage(p, "&7Wlaczyles sobie latanie!");
					return;
				}else if (args[0].equalsIgnoreCase("off")){
					p.setAllowFlight(false);
					p.setFlying(false);
					Util.sendMessage(p, "&7Wylaczyles sobie latanie!");
					return;
				}
			}else{
				Util.sendMessage(sender, "Mozesz tylko komus ustawic fly z poziomu konsoli!");
				return;
			}
		}else if (args.length == 2){
			if(sender.hasPermission("qessentials.tp.others")){
				Player pl = Bukkit.getPlayerExact(args[1]);
				if (pl == null){
					Util.sendMessage(sender, "&cGracz nie jest na serwerze!");
					return;
				}
				if(args[0].equalsIgnoreCase("on")){
					pl.setAllowFlight(true);
					pl.setFlying(true);
					Util.sendMessage(sender, "&7Wlaczyles graczowi&c " + pl.getName() + "&7 latanie!");
					return;
				}else if (args[0].equalsIgnoreCase("off")){
					pl.setAllowFlight(false);
					pl.setFlying(false);
					Util.sendMessage(sender, "&7Wylaczyles graczowi&c " + pl.getName() + "&7 latanie!");
					return;
				}	
			}else{
				Util.sendMessage(sender, "&cNie masz uprawnien do wlaczania fly innym osoba!");
				return;
			}
		}else{
			Util.sendMessage(sender, "&cPoprawne uzycie: /fly <on/off> <gracz>");
			return;
		}
		
	}

}
