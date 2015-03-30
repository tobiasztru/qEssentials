package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Gamemode extends QCommand{

	public Gamemode() {
		super("gm", "Zmiana trybu gry", "/gm <tryb>", "gamemode", Arrays.asList(new String[] { "gamemode", "qgm", "qgamemode" }));
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if (args.length == 0) {
			Util.sendMessage(p, "&cPoprawne uzycie: /gm <tryb>");
			return;
		}
		try {
			int mode = Integer.parseInt(args[0]);
			@SuppressWarnings("deprecation")
			GameMode gm = GameMode.getByValue(mode);
			if (gm == null) {
				Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
				return;
			}
			p.setGameMode(gm);
			Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
			return;
		}
		catch (NumberFormatException e) {
			GameMode gm = GameMode.valueOf(args[0].toUpperCase());
			if (gm == null) {
				Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
				return;
			}
			p.setGameMode(gm);
			Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
			return;
		}

	}

	

}
