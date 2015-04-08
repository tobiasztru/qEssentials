package pl.za.xvacuum.qessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatUtil {
	
	public static boolean chat;
	
	public static boolean setChat(boolean mode){
		chat = mode;
		return mode;
	}
	
	
	public static boolean getChat()
	{
		return chat;
	}
	
	@SuppressWarnings("deprecation")
	public static void clearChat()
	{
		for (Player p : Bukkit.getOnlinePlayers()){
		    for (int i = 0; i < 100; i++){
		        p.sendMessage(" ");
		    }
		}
	}

}
