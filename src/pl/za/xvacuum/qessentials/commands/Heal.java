package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Heal extends QCommand{

	public Heal() {
		super("heal", "Leczenie uzytkownika", "/heal [player]", "heal", Arrays.asList(new String[] { "qheal", "ulecz", "qulecz" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0){
			p.setHealth(20.0);
			p.setFoodLevel(20);
			Util.sendMessage(p, "&7Poprawnie uleczono!");
			return;
		}else if (args.length == 1){
			Player arg = Bukkit.getPlayerExact(args[0]);
			if(!(arg == null)){
				arg.setHealth(20.0);
				arg.setFoodLevel(20);
				Util.sendMessage(p, "&7Poprawnie uleczono gracza &c" + arg.getName());
				return;
			}else{
				Util.sendMessage(p, "&cTaki gracz nie jest online!");
			}
		}
		
	}
	
	

}
