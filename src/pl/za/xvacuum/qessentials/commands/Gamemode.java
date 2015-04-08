package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.GmUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Gamemode extends QCommand{

	public Gamemode() {
		super("gm", "Zmiana trybu gry", "/gm <tryb>", "gamemode", Arrays.asList(new String[] { "gamemode", "qgm", "qgamemode" }), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if ((args.length == 0) || (args.length >= 3)) {
			Util.sendMessage(sender, "&cPoprawne uzycie: /gm <tryb>");
			return;
		}
		if(args.length == 1){
			if(sender instanceof Player){
				Player p = (Player)sender;
				try {
		
					GameMode gm = GmUtil.parseGameName(args[0]);
					if (gm == null) {
						Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
						return;
					}
					p.setGameMode(gm);
					Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
					return;
				}catch (NumberFormatException e) {
					GameMode gm = GmUtil.parseGameName(args[0]);
					if (gm == null) {
						Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
						return;
					}
					p.setGameMode(gm);
					Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
					return;
				}
			}else{
				Util.sendMessage(sender, "&cMozesz jedynie dac gamemode innej osobie z poziomu konsoli!");
				return;
			}
		}else if (args.length == 2){
			try {
				Player arg = Bukkit.getPlayer(args[1]);
				if(arg == null){
					Util.sendMessage(sender, "&cTen gracz nie jest online!");
					return;
				}
				GameMode gm = GmUtil.parseGameName(args[0]);
				if (gm == null) {
					Util.sendMessage(sender, "&cNie znaleziono takiego trybu!");
					return;
				}
				arg.setGameMode(gm);
				Util.sendMessage(sender, "&7Tryb gry zostal zmieniony dla gracza &c" + args[1]);
				return;
			}catch (NumberFormatException e) {
				Player arg = Bukkit.getPlayer(args[1]);
				if(arg == null){
					Util.sendMessage(sender, "&cTen gracz nie jest online!");
					return;
				}
				GameMode gm = GmUtil.parseGameName(args[0]);
				if (gm == null) {
					Util.sendMessage(sender, "&cNie znaleziono takiego trybu!");
					return;
				}
				arg.setGameMode(gm);
				Util.sendMessage(sender, "&7Tryb gry zostal zmieniony dla gracza &c" + args[1]);
				return;
			}
		}

	}
	
	

}
