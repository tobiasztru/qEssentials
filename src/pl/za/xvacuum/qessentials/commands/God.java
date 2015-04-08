package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class God extends QCommand{

	public God() {
		super("god", "Daje goda", "/god", "god", Arrays.asList(new String[] { "invulnerable", "qgod", "niesmiertelnosc", "bog" }), false);
	
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if(args.length == 1)
		{
			if(sender instanceof Player){
				Player p = (Player)sender;
				QPlayer q = MetadataStorage.getFromPlayer(p);
				
				if(args[0].equalsIgnoreCase("on")){
					q.setGod(true);
					p.setHealth(20.0);
					p.setFoodLevel(20);
					Util.sendMessage(p, "&7Wlaczyles sobie goda");
					return;
				}else if (args[0].equalsIgnoreCase("off")){
					q.setGod(false);
					Util.sendMessage(p, "&7Wylaczyles sobie goda!");
					return;
				}
			}else{
				Util.sendMessage(sender, "Mozesz tylko komus ustawic goda z poziomu konsoli!");
				return;
			}
		}else if (args.length == 2){
			if(sender.hasPermission("qessentials.god.others")){
				Player pl = Bukkit.getPlayerExact(args[1]);
				if (pl == null){
					Util.sendMessage(sender, "&cGracz nie jest na serwerze!");
					return;
				}
				
				QPlayer qp =  MetadataStorage.getFromPlayer(pl);
			
				if(args[0].equalsIgnoreCase("on")){
					qp.setGod(true);
					pl.setHealth(20.0);
					pl.setFoodLevel(20);
					
					Util.sendMessage(sender, "&7Wlaczyles graczowi&c " + pl.getName() + "&7 goda!");
					return;
				}else if (args[0].equalsIgnoreCase("off")){
					qp.setGod(false);
					Util.sendMessage(sender, "&7Wylaczyles graczowi&c " + pl.getName() + "&7 goda!");
					return;
				}	
			}else{
				Util.sendMessage(sender, "&cNie masz uprawnien do wlaczania goda innym osoba!");
				return;
			}
		}else{
			Util.sendMessage(sender, "&cPoprawne uzycie: /god <on/off> <gracz>");
			return;
		}
		
		
	}
}
