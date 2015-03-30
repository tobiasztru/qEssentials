package pl.za.xvacuum.qessentials.utils;

import java.util.Random;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Util {
	
	/**
	 * G³ówna klasa z utilsami, np. setHex, czy sender :)
	 * @return 
	 */
	public static String setHEX(String text)
	{
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static boolean sendMessage(CommandSender player, String text)
	{
		if ((text != null) || (text != ""))
		{
		    player.sendMessage(setHEX(text));
		}
		
	   return true;
	}
	public static boolean isInteger(String string) {
	    return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
	}		
	
	public static int getRandomInt(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((max + 1) - min) + min;

        return randomNumber;

    }

	

	

}


