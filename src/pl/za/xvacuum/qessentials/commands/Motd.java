package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Motd extends QCommand{

	public Motd() {
		super("motdset", "Zmiana motd", "/motdset <tekst>", "motd", Arrays.asList(new String[] { "ms", "qms", "qmotd", "qmotdset", "setmotd"}), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if (args.length > 0) {
			StringBuilder sb = new StringBuilder();
			
			for (String arg : args) {
				sb.append(arg).append(" ");
			}
			String motd = sb.toString();
			Main.getInstance().getConfig().set("server-motd", motd);
			Main.getInstance().saveConfig();
			Util.sendMessage(sender, "&7Pomyslnie ustawiono nowe motd: &c" + motd);
			return;
		}else{
			Util.sendMessage(sender, "&cPoprawne uzycie: /motdset <tekst>");
		}
		
	}

}
