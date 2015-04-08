package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Invsee extends QCommand {

	public Invsee() {
		super("invsee", "Otwiera ekwipunek gracza", "/invsee <player>", "invsee", Arrays.asList(new String[] { "invs", "is", "qinvsee", "qinvs", "qis"} ), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0){
			Util.sendMessage(p, "&cPrawidlowe uzycie: /invsee <gracz>");
			return;
		}else if (args.length == 1){
			Player pl = Bukkit.getPlayerExact(args[0]);
			if(!(pl == null)){
				p.openInventory(pl.getInventory());
				return;
			}else{
				Util.sendMessage(p, "&cTen gracz nie jest online!");
				return;
			}
		}else{
			Util.sendMessage(p, "&cPrawidlowe uzycie: /invsee <gracz>");
			return;
		}
		
	}

}
