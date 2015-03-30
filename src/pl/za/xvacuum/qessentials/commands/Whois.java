package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Whois extends QCommand{

	public Whois() {
		super("whois", "Informacje o u¿ytkowniku", "/whois [player]", "whois", Arrays.asList(new String[] { "qwhois", "pinfo", "playerinfo" }));
		
	}
	
	public static String getOperator(Player p){
		if(p.isOp() || p.hasPermission("'*'")){
			return Util.setHEX("&aTak");
		}
		return Util.setHEX("&cNie");
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0){
			Util.sendMessage(p, "&7Informacje o graczu &c" + p.getName() + "&7:");
			Util.sendMessage(p, "&7  IP: &c" + p.getAddress().getHostString());
			Util.sendMessage(p, "&7  Admin: &c" + getOperator(p));
			Util.sendMessage(p, "&7  Gamemode: &c" + p.getGameMode().toString());
			Util.sendMessage(p, "&7  Jedzenie: &c" + p.getFoodLevel() + "/20");
			Util.sendMessage(p, "&7  Polozenie: &cx: " + p.getLocation().getBlockX() + ", y: " + p.getLocation().getBlockY() + ", z: " + p.getLocation().getBlockZ());
			return;
		}else if (args.length == 1){
			Player arg = Bukkit.getPlayerExact(args[0]);
			if(!(arg == null)){
				Util.sendMessage(p, "&7Informacje o graczu &c" + arg.getName() + "&7:");
				Util.sendMessage(p, "&7  IP: &c" + arg.getAddress().getHostString());
				Util.sendMessage(p, "&7  Admin: &c" + getOperator(arg));
				Util.sendMessage(p, "&7  Gamemode: &c" + arg.getGameMode().toString());
				Util.sendMessage(p, "&7  Jedzenie: &c" + arg.getFoodLevel() + "/20");
				Util.sendMessage(p, "&7  Polozenie: &cx: " + arg.getLocation().getBlockX() + ", y: " + arg.getLocation().getBlockY() + ", z: " + arg.getLocation().getBlockZ());
				return;
			}else{
				Util.sendMessage(p, "&cTaki gracz nie jest online!");
				return;
			}
		}
		
	}

}
