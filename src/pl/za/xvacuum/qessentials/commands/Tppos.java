package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Tppos extends QCommand{

	public Tppos() {
		super("tppos", "Teleportacja w okreslone koordynaty", "/tppos [player] <x> <y> <z>", "tppos", Arrays.asList(new String[] { "qtppos", "tpp", "qtpp", "tpposition" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if ((args.length == 0) || (args.length == 2) || (args.length >= 5)){
			Util.sendMessage((Player)sender, "&cPoprawne uzycie: /tppos [player] <x> <y> <z>");
			return;
		}
	    if (args.length == 4) {
	        Player p = Bukkit.getPlayerExact(args[0]);
	        Player player = (Player)sender;
	        if (p == null) 
	        { 
	        	Util.sendMessage(player, "&cTaki gracz nie jest online!");
	            return; 
	        } 
	        int x = 0;
	        int y = 0;
	        int z = 0;
	        if(Util.isInteger(args[1]) || Util.isInteger(args[2]) || Util.isInteger(args[3])){
	        	x = Integer.parseInt(args[1]);
	            y = Integer.parseInt(args[2]);
	            z = Integer.parseInt(args[3]);
	        }else{
	             Util.sendMessage(player, "&cKoordynaty musza byc liczba!");
	        }

	        Location loc = p.getLocation();
	        loc.setX(x + 0.5D);
	        loc.setY(y + 0.3D);
	        loc.setZ(z + 0.5D);

	        p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
	        Util.sendMessage(player, "&7Gracz &c" + p.getName() + "&7 zostal przeteleportowany!");
	        return;
	    }if (args.length == 3) {
	        Player p = (Player)sender;

	        int x = 0; 
	        int y = 0; 
	        int z = 0;
	        if(Util.isInteger(args[0]) || Util.isInteger(args[1]) || Util.isInteger(args[2])){
	        	x = Integer.parseInt(args[0]);
	            y = Integer.parseInt(args[1]);
	            z = Integer.parseInt(args[2]);
	        }else{
	             Util.sendMessage(p, "&cKoordynaty musza byc liczba!");
	        }

	        Location loc = p.getLocation();
	        loc.setX(x + 0.5D);
	        loc.setY(y + 0.3D);
	        loc.setZ(z + 0.5D);

	        p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
	        Util.sendMessage(p, "&7Zostales przeteleportowany!");
	        return;
	     }
	     
	}
		
	

}
