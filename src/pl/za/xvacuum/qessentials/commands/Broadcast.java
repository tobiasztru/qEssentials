package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Broadcast extends QCommand{

	public Broadcast() {
		super("broadcast", "Wysy³a globaln¹ wiadomoœæ na chat", "/broadcast <tekst>", "broadcast", Arrays.asList(new String[] { "bc","og", "ann", "qbroadcast", "qbd", "ogloszenie", "qogloszenie" }), false);
	
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if(args.length == 0){
			Util.sendMessage(sender, "&cPoprawne uzycie: /broadcast <tekst>");
			return;
		}
	    StringBuilder mb = new StringBuilder();
	    for (String a : args) {
	        if (mb.length() > 0) {
	            mb.append(" ");
	        }
	        mb.append(a);
	    }
	    Bukkit.broadcastMessage(Util.setHEX("&7[&cOgloszenie&7] &c" + mb.toString()));
		
	}

}
