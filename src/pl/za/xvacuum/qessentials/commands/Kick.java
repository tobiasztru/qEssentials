package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Kick extends QCommand{

	public Kick() {
		super("kick", "Wyrzucanie graczy", "/kick <gracz> <powod>", "kick", Arrays.asList("qkick", "wyrzuc"), false);
		
	}


	@Override
	public void onExecute(CommandSender sender, String[] args) {
		CommandSender p = sender;
		if((args.length == 0) || (args.length >= 3)){
			Util.sendMessage(p, "&cPoprawne uzycie: /kick <gracz> <powod>");
			return;
		}
		Player arg = Bukkit.getPlayer(args[0]);
		if(arg == null){
			Util.sendMessage(p, "&cTaki gracz nie jest online!");
			return;
		}
		if(arg.getName() == p.getName()){
			Util.sendMessage(p, "&cNie mozesz wyrzucic samego siebie!");
			return;
		}
		
		String reason = LogUtil.parseArgs(1, args);
		
		if(arg.hasPermission("qessentials.bypass")) {
			Util.sendMessage(sender, "&cTen gracz jest niekaralny.");
			return;
		}
		arg.kickPlayer("§7Zostales wyrzucony z serwera. \n§7Admin:§c " + p.getName() + "\n§7Powod: §c" + reason); 
		Bukkit.broadcastMessage(Util.setHEX("&7Gracz &c" + arg.getName() + " &7zostal wyrzucony za &c" + reason + "&7!"));
		return;
		
	}

}
