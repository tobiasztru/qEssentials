package pl.za.xvacuum.qessentials.api;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.BackUtil;
import pl.za.xvacuum.qessentials.utils.ChatUtil;
import pl.za.xvacuum.qessentials.utils.EnchantUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class QEssentialsAPI 
{
	
	public static boolean getChatStatus()
	{
		return ChatUtil.getChat();
	}
	
	public static boolean setChatStatus(boolean mode)
	{
		return ChatUtil.setChat(mode);
	}
	
	public static String getServerMotd()
	{
		return Main.getInstance().getConfig().getString("server-motd");
	}
	
	public static String setHEX(String text)
	{
		return Util.setHEX(text);
	}
	
	public static boolean isInteger(String text)
	{
		return Util.isInteger(text);
	}
	
	public static int getRandomInt(int min, int max)
	{
		return Util.getRandomInt(min, max);
	}
	
	public static HashMap<String, Enchantment> getEnchantmentList()
	{
		return EnchantUtil.getEnchants();
	}
	
	public static Location getLastLocation(Player player)
	{
		return BackUtil.getLastLocation(player);
	}
	
	public static void setLastLocation(Player player, Location loc)
	{
		BackUtil.setLastLocation(player, loc);
	}
	

}
