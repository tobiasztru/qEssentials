package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Unmute extends QCommand {

	
	public Unmute() {
		super("unmute", "Odmutowuje gracza", "/unmute <gracz>", "unmute", Arrays.asList("qunmute", "um", "odcisz"), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(sender, "&cPoprawne uzycie: /unmute <gracz>");
			return;
		}

		Player pd = Bukkit.getPlayer(args[0]);
		if(!pd.isOnline() || pd == null){
			Util.sendMessage(sender, "&cNie ma takiego gracza!");
			return;
		}
		
		QPlayer q =  MetadataStorage.getFromPlayer(pd);
		
	
		if(q == null){
			Util.sendMessage(sender, "&cNie ma takiego gracza!");
			return;
		}
		
		
		
		
		if(q.getMute() > 0) {
			if(q.getMute() < System.currentTimeMillis()) {
				Util.sendMessage(sender, "&cTen gracz nie jest wyciszony!");
				return;
			}
			q.setMute(0);
			Util.sendMessage(sender, "&7Odciszyles gracza &c" + pd.getName());
			Util.sendMessage(pd, "&7Zostales odciszony przez &c" + sender.getName() + "&7. Staraj sie nie popelniac wiecej bledow.");
		} else {
			Util.sendMessage(sender, "&cTen gracz nie jest wyciszony!");
			return;
		}
		
		return;
	}
}
