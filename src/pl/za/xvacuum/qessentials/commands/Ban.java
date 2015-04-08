package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.flatfile.Flat;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;
import pl.za.xvacuum.qessentials.mysql.QueryStream;
import pl.za.xvacuum.qessentials.objects.DataContainer;
import pl.za.xvacuum.qessentials.objects.QBan;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Ban extends QCommand{

	public Ban() {
		super("ban", "Banuje gracza", "/ban", "ban", Arrays.asList("qban", "b", "zbanuj", "perm"), false);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void onExecute(CommandSender sender, String[] args) {		
		if(args.length < 2) {
			Util.sendMessage(sender, "&cPoprawne uzycie: /ban <nick> <powod>");
			return;
		}
		String reason = LogUtil.parseArgs(1, args);
		
		String other = args[0];
		String vSender = sender instanceof ConsoleCommandSender ? "konsola" : sender.getName();
        Player ot = Bukkit.getPlayer(other);
    	
		QBan ban = new QBan(vSender, other);		
		long date = System.currentTimeMillis();		
		String sDate = TimeUtil.parseTime(date);
		ban.setBanTime(date);
		ban.setReason(reason);
		ban.setValidateTill(0);
		
        if (ot != null) {
        	if(ot.hasPermission("qessentials.bypass")) {
        		sender.sendMessage("Nie mozesz zbanowac tego gracza.");
        		return;
        	}
        	String waznyDo = ban.getValidateTill() == 0L ? "&cpermamentny" :  "&a" + TimeUtil.parseTimeHour(ban.getValidateTill());
        	String msg = Util.setHEX(String.format("&6Otrzymales bana...\n&7Nadajacy: &c%s\n&7Powod: &c%s\n&7Data nadania:&c %s\n&7Wazny do: %s", vSender, reason, TimeUtil.parseTimeHour(ban.getBanTime()), waznyDo));
			ot.kickPlayer(msg);
        }
        
        DataContainer.addBan(ban);
		
        
		if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			//(punisher VARCHAR(16), victim VARCHAR(16), reason VARCHAR(100), giveDate bigint, deleteDate bigint)
			QueryStream.sendQuery(new EncapsulatedQuery(String.format("INSERT INTO `bans` VALUES ('%s', '%s', '%s', '%d', '%d')", ban.getPunisher(), ban.getVictim(), ban.getReason(), ban.getBanTime(), ban.getValidateTill())));
			
		} else {
			Flat.createBanData(ban);
			ban.save();
		}
		
		Bukkit.broadcastMessage(Util.setHEX("&7Gracz &c" + other + " &7zostal zbanowany przez &c" + vSender + " &7z powodu &c" + reason));
		
	}
	
}
