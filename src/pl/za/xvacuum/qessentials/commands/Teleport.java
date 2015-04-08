package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Teleport extends QCommand{

	public Teleport() {
		super("tp", "Teleportacja", "/tp <player/[all]> [<player>]", "teleport", Arrays.asList(new String[] { "qtp", "teleport", "qteleport", "teleportacja" }), false);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if((args.length == 0) || (args.length > 2)){
			Util.sendMessage(sender, "&cPoprawne uzycie: /tp <player/[all]> [<player>]");
			return;
		}
		if(args.length == 1){
			if(sender instanceof Player){
				Player p = (Player)sender;
				if(args[0].equalsIgnoreCase("all")){
					if(p.hasPermission("qessentials.teleport.all")){
						for (Player online : Bukkit.getOnlinePlayers()){
							online.teleport(p.getLocation());
							Util.sendMessage(online, "&7Zostales przeteleportowany do &c" + p.getName());
						}
						Util.sendMessage(p, "&7Przeteleportowales wszystkich graczy do siebie!");
						return;
					}else{
						Util.sendMessage(p, "&cNie masz uprawnien do wykonania tej czynnosci! &7(qessentials.teleport.all)");
						return;
					}
				}else{
					Player tpTo = Bukkit.getPlayerExact(args[0]);
					if(!(tpTo == null)){
						p.teleport(tpTo);
						Util.sendMessage(p, "&7Zostales przeteleportowany do &c" + tpTo.getName());
					}else{
						Util.sendMessage(p, "&cTaki gracz nie jest online!");
					}
				}
			}
		}
		if(args.length == 2){
			if(sender.hasPermission("qessentials.tp.others")){
				Player tpFrom = Bukkit.getPlayerExact(args[0]);
				Player tpTo = Bukkit.getPlayerExact(args[1]);
				if (!(tpFrom == null) || !(tpTo == null)){
					tpFrom.teleport(tpTo.getLocation());
					Util.sendMessage(tpFrom, "&7Zostales przeteleportowany do &c" + tpTo.getName());
					Util.sendMessage(sender, "&7Gracz &c" + tpFrom.getName() + " &7zostal przeteleportowany do &c" + tpTo.getName());
				}else{
					Util.sendMessage(sender, "&cKtorys gracz nie jest online!");
				}
			}else{
				Util.sendMessage(sender, "&cNie masz uprawnien do teleportowania innych osob!");
				return;
			}
		}
		
	}

}
