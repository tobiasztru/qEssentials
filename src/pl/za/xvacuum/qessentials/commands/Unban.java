package pl.za.xvacuum.qessentials.commands;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;
import pl.za.xvacuum.qessentials.mysql.QueryStream;
import pl.za.xvacuum.qessentials.objects.DataContainer;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Unban extends QCommand{

	public Unban() {
		super("unban", "Odbanowywuje gracza", "/unban <gracz>", "unban", Arrays.asList("qunban", "ub", "odbanuj"), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(sender, "&cPoprawne uzycie: /unban <gracz>");
			return;
		}
		String nick = args[0];
		
		if(DataContainer.getBan(nick) == null){
			Util.sendMessage(sender, "&cTen gracz nie ma bana!");
			return;
		}
		
		if(DataContainer.getBan(nick).getValidateTill() != 0 && DataContainer.getBan(nick).getValidateTill() < System.currentTimeMillis()){
			Util.sendMessage(sender, "&cTen gracz nie ma bana!");
			return;
		}
		
		if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			QueryStream.sendQuery(new EncapsulatedQuery(String.format("DELETE FROM bans WHERE `victim`='%s'", nick)));
		} else {
			File folder = new File(Main.getInstance().getDataFolder(), "bandata");
			
			File f = new File(folder, DataContainer.getBan(nick).getVictim() + ".yml");
			if(f.exists()) {
				f.delete();
			}
		}
		
		
		DataContainer.removeBan(DataContainer.getBan(nick));
		Bukkit.broadcastMessage(Util.setHEX("&7Gracz &c" + nick+ "&7 zostal odbanowany przez &c" + sender.getName() + "&7!"));
		return;
	}
	
	

}
