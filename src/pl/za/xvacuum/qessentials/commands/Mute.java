package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import net.minecraft.util.org.apache.commons.lang3.StringUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Mute extends QCommand{

	public Mute() {
		super("mute", "Mute dla gracza", "/mute <gracz> <czas> <powod>", "mute", Arrays.asList("qmute", "wycisz"), false);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		
		if(args.length < 3) {
			Util.sendMessage(sender, "&cPoprawne uzycie: /mute <gracz> <czas w min> <powod>");
			return;
		}
		
			Player nick = Bukkit.getPlayer(args[0]);
			if(nick == null){
				Util.sendMessage(sender, "&cTen gracz nie jest online!");
				return;
			}
			
			if(!StringUtils.isNumeric(args[1])) {
				Util.sendMessage(sender, "&cArgument drugi musi byc liczba!");
				return;
			}
			
			if(nick.getName() == sender.getName()){
				Util.sendMessage(sender, "&cNie mozesz wyciszyc samego siebie!");
				return;
			}
			if(nick.hasPermission("qessentials.bypass")) {
				Util.sendMessage(sender, "&cTen gracz jest niekaralny.");
				return;
			}
			
			if(!StringUtils.isNumeric(args[1])) {
				Util.sendMessage(sender, "&cCzas nie jest liczba!");
				return;
			}
			
			long przelicznik = 1000 * 60 * Integer.parseInt(args[1]);
			
			long till = System.currentTimeMillis() + przelicznik;
			
			String reason = LogUtil.parseArgs(2, args);
	
			QPlayer player =  MetadataStorage.getFromPlayer(nick); 
			player.setMute(till);
			String admin = sender.getName();
			String parsed = TimeUtil.parseTimeHour(till);
			nick.sendMessage(Util.setHEX("&cZostales wyciszony do &7" + parsed + " &c przez &7" + admin + " &c za:&7 " + reason));
			return;
		}

		
		

}
