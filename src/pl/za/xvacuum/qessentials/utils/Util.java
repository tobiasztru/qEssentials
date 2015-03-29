package pl.za.xvacuum.qessentials.utils;

import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {
	
	/**
	 * G³ówna klasa z utilsami, np. setHex, czy sender :)
	 * @return 
	 */
	public static String setHEX(String text)
	{
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static boolean sendMessage(Player player, String text)
	{
		if(player instanceof Player){
		   if ((text != null) || (text != ""))
		   {
		      player.sendMessage(setHEX(text));
		   }
		}else{
			LogUtil.info("Konsola nie moze wykonywac komend!");
		}
	   return true;
	}
	public static boolean isInteger(String string) {
	    return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
	}		

	

	

}


