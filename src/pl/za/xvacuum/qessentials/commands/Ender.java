package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Ender extends QCommand{

	public Ender() {
		super("ender", "Panel sterowania enderchestem", "/ender <open/clear> <gracz>", "ender", Arrays.asList("enderchest", "endersee", "qender", "skrzyniakresu"), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 3)){
			Util.sendMessage(p, "&cPoprawne uzycie: /ender <open/clear> <gracz>");
			return;
		}
		if(args.length == 2){
			if(args[0].equalsIgnoreCase("open")){
				Player arg = Bukkit.getPlayer(args[1]);
				if(arg == null){
					Util.sendMessage(p, "&cTaki gracz nie jest online!");
					return;
				}
				p.openInventory(arg.getEnderChest());
				Util.sendMessage(p, "&7Otworzono enderchest gracza &c" + arg.getName() + "&7!");
				return;
			}else if (args[0].equalsIgnoreCase("clear")){
				Player arg = Bukkit.getPlayer(args[1]);
				if(arg == null){
					Util.sendMessage(p, "&cTaki gracz nie jest online!");
					return;
				}
				arg.getEnderChest().clear();
				Util.sendMessage(p, "&7Wyczyszczono enderchest gracza &c" + arg.getName() + "&7!");
				return;
			}
		}else{
			Util.sendMessage(p, "&cPoprawne uzycie: /ender <open/clear> <gracz>");
			return;
		}
		
	}

}
