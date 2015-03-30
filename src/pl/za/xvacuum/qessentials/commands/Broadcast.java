package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Broadcast extends QCommand{

	public Broadcast() {
		super("broadcast", "Wysy³a globaln¹ wiadomoœæ na chat", "/broadcast <tekst>", "broadcast", Arrays.asList(new String[] { "bd", "qbroadcast", "qbd", "ogloszenie", "qogloszenie" }));
	
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0){
			Util.sendMessage(p, "&cPoprawne uzycie: /broadcast <tekst>");
			return;
		}
	    StringBuilder mb = new StringBuilder();
	    for (String a : args) {
	        if (mb.length() > 0) {
	            mb.append(" ");
	        }
	        mb.append(a);
	    }
	    Bukkit.broadcastMessage(Util.setHEX("&7Ogloszenie: &c" + mb.toString()));
		
	}

}
