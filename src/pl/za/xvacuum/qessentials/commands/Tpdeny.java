package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TeleportUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Tpdeny extends QCommand{

	public Tpdeny() {
		super("tpdeny", "Odrzucenie teleportacji", "/tpdeny", "tpdeny", Arrays.asList(new String[] { "nie", "deny" } ), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 1) || (args.length >= 2)){
			Util.sendMessage(p, "&cPoprawne uzycie: /tpdeny (lub /nie)");
			return;
		}
		Player requester = TeleportUtil.getRequesterByReceiver().get(p);
		if (requester == null){
			Util.sendMessage(p, "&cNie masz oczekujacej prosby na teleportacje!");
			return;
		}
		if ((System.currentTimeMillis() - ((Long)TeleportUtil.getLastRequestTime().get(requester)).longValue()) / 1000L <= 60L) {
			TeleportUtil.accept(requester, p);
			Util.sendMessage(requester, "&c" + p.getName() + " &7odrzucil Twoja prosbe o teleportacje!");
			Util.sendMessage(p, "&7Odrzuciles prosbe gracza &c" + requester.getName() + " &7o teleporacje!");
			return;
		}else{
			Util.sendMessage(p, "&cNie masz oczekujacej prosby na teleportacje!");
			return;
		}
		
	}

}
