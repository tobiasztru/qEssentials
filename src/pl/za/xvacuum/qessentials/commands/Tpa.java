package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TeleportUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Tpa extends QCommand{

	public Tpa() {
		super("tpa", "Teleportacja za pozwoleniem", "/tpa <gracz>", "", Arrays.asList(new String[] { "tpa", "qtpa" }), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(p, "&cPoprawne uzycie: /tpa <gracz>");
			return;
		}
		
		if(sender.getName().equalsIgnoreCase(args[0])) {
			Util.sendMessage(p, "&cNie mozesz sie teleportowac do samego siebie!");
			return;
		}
		
		
		Player receiver = Bukkit.getPlayer(args[0]);
		if(receiver == null){
			Util.sendMessage(p, "&cTen gracz nie jest online!");
			return;
		}
		TeleportUtil.send(p, receiver);
		Util.sendMessage(receiver, "&c" + p.getName() + "&7 chce sie do Ciebie przeteleportowac!");
		Util.sendMessage(receiver, "&7Wpisz &c/tpaccept &7aby zaakceptowac teleport!");
		Util.sendMessage(receiver, "&7Wpisz &c/tpdeny &7aby odrzucic teleport!");
		Util.sendMessage(receiver, "&7Masz &c60 sekund &7aby potwierdzic teleport!");
		Util.sendMessage(p, "&7Pomyslnie wyslano prosbe teleportacji do &c " + receiver.getName());
		return;
	}

}
