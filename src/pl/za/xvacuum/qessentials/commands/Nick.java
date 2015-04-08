package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Nick extends QCommand{

	public Nick() {
		super("nick", "Zmiana nicku", "/nick <nowy nick>", "nick", Arrays.asList(new String[] { "qnick", "nazwa" }), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(p, "&cPoprawne uzycie: /nick <nowy nick>");
			return;
		}
		if(!args[0].matches("^[a-zA-Z0-9_]*$")){
			Util.sendMessage(p, "&cNick musi byc alfanumeryczny!");
			return;
		}
		p.setDisplayName(args[0]);
		Util.sendMessage(p, "&7Poprawnie zmieniles sobie nick na &c" + p.getDisplayName());
		
	}

}
