package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import net.minecraft.util.org.apache.commons.lang3.StringUtils;

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
import pl.za.xvacuum.qessentials.utils.TimeUnit;
import pl.za.xvacuum.qessentials.utils.Util;

public class TempBan extends QCommand{

	public TempBan() {
		super("tempban", "Banuje gracza na czas", "/tempban <nick> <czas> <powod>", "tempban", Arrays.asList("qtempban", "temp"), false);
	}

	/**
	 * @author Kresrek007
	 */
	
	@SuppressWarnings("unused")
	@Override
	public void onExecute(CommandSender sender, String[] args) {		
		if(args.length < 4) {
			Util.sendMessage(sender, "&cPoprawne uzycie: /tempban <nick> <czas> <jednostka> <powod>");
			return;
		}

		String reason = LogUtil.parseArgs(3, args);
		
		Player other = Bukkit.getPlayer(args[0]);
		String target = args[0];
		
		if(!StringUtils.isNumeric(args[1])) {
			Util.sendMessage(sender, "&cArgument drugi musi byc liczba!");
			return;
		}
	
		long time = System.currentTimeMillis() + TimeUnit.getTicks(args[2], Integer.parseInt(args[1]));
		long now = System.currentTimeMillis();
		long diff = time - now;		
		
		if(diff <= 0){			
			Util.sendMessage(sender, "&cPodano bledna jednostke!");
			return;
		}
		
		String vSender = sender instanceof ConsoleCommandSender ? "konsola" : sender.getName();
		long date = System.currentTimeMillis();		
		String sDate = TimeUtil.parseTime(date);	
		
		QBan ban = new QBan(vSender, target);		
		ban.setBanTime(date);
		ban.setReason(reason);		
		ban.setValidateTill(time);
		
		if (other != null) {
        	if(other.hasPermission("qessentials.bypass")) {
    			Util.sendMessage(sender, "&cTen gracz jest niekaralny.");
    			return;
    		}
        	String waznyDo = ban.getValidateTill() == 0L ? "&cpermamentny" :  "&a" + TimeUtil.parseTimeHour(ban.getValidateTill());
        	String msg = Util.setHEX(String.format("&6Otrzymales bana...\n&7Nadajacy: &c%s\n&7Powod: &c%s\n&7Data nadania:&c %s\n&7Wazny do: %s", vSender, reason, TimeUtil.parseTimeHour(ban.getBanTime()), waznyDo));
        	other.kickPlayer(msg);
        }
		
		
		DataContainer.addBan(ban);
		
		if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			//(punisher VARCHAR(16), victim VARCHAR(16), reason VARCHAR(100), giveDate bigint, deleteDate bigint)
			QueryStream.sendQuery(new EncapsulatedQuery(String.format("INSERT INTO `bans`  VALUES ('%s', '%s', '%s', '%d', '%d')", ban.getPunisher(), ban.getVictim(), ban.getReason(), ban.getBanTime(), ban.getValidateTill())));
			
		} else {
			Flat.createBanData(ban);
			ban.save();
		}
		
		Bukkit.broadcastMessage(Util.setHEX("&7Gracz &c" + target + " &7zostal zbanowany przez &c" + vSender + " &7do &c"+ TimeUtil.parseTimeHour(time) + " &7z powodu &c" + reason));
		
	}
	
}