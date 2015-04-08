package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Heal extends QCommand{

	public Heal() {
		super("heal", "Leczenie uzytkownika", "/heal [player]", "heal", Arrays.asList(new String[] { "qheal", "ulecz", "qulecz" }), false);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if(args.length == 0){
			if(sender instanceof Player){
				Player p = (Player)sender;
				p.setHealth(20.0);
				p.setFoodLevel(20);
				Util.sendMessage(p, "&7Poprawnie uleczono!");
				return;
			}else{
				Util.sendMessage(sender, "&cMozesz leczyc tylko innych graczy z poziomu konsoli!");
				return;
			}
		}else if (args.length == 1){
			if(sender.hasPermission("qessentials.heal.others")){
				Player arg = Bukkit.getPlayerExact(args[0]);
				if(!(arg == null)){
					arg.setHealth(20.0);
					arg.setFoodLevel(20);
					Util.sendMessage(sender, "&7Poprawnie uleczono gracza &c" + arg.getName());
					return;
				}else{
					Util.sendMessage(sender, "&cTaki gracz nie jest online!");
				}
			}else{
				Util.sendMessage(sender, "&cNie masz uprawnien do leczenia innych osob!");
			}
		}
		
	}
	
	

}
