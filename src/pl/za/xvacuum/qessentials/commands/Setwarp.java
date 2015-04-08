package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Setwarp extends QCommand{

	public Setwarp() {
		super("setwarp", "Ustawia warpa", "/setwarp <nazwa>", "warp", Arrays.asList("ustawwarp", "qsetwarp"), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(p, "&cPoprawne uzycie: /setwarp <nazwa>");
			return;
		}
		String name = args[0];
		if(!name.matches("^[a-zA-Z0-9_]*$")){
			Util.sendMessage(p, "&cNazwa warpu musi byc alfanumeryczna!");
			return;
		}
		
	}

}
