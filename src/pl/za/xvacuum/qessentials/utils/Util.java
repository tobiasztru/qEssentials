package pl.za.xvacuum.qessentials.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Util {
	
	/**
	 * G³ówna klasa z utilsami, np. setHex, czy sender :)
	 * @return 
	 * @author: KRSRK (Kresrek007), xVacuum (AdamGrzegorz)
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
	public static Integer parseInteger(String integer){
		try{
			return Integer.valueOf(Integer.parseInt(integer));
		}catch(NumberFormatException o)
		{
			o.printStackTrace();
			LogUtil.error("Wystapil blad z parsowaniem numeru!");
		}
		return null;
		
	}
    public static void giveItems(final Player p, final ItemStack... items) {
        final Inventory i = (Inventory)p.getInventory();
        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>)i.addItem(items);
        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack)e.getValue());
        }
        p.updateInventory();
        
    }
	

	

}


