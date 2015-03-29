package pl.za.xvacuum.qessentials.utils;

import org.bukkit.entity.Player;

public class ChatUtil {
	
	public static boolean chat;
	
	public static void setChat(String mode){
		if (mode == "off")
		{
			chat = false;
		}
		else if(mode == "on")
		{
			chat = true;
		}
	}
	
	public static boolean getChat()
	{
		return chat;
	}
	
	public static void clearChat()
	{
		for (Player p : PlayerManager.getOnlinePlayers()){
		    for (int i = 0; i < 100; i++){
		        p.sendMessage(" ");
		    }
		}
	}

}
