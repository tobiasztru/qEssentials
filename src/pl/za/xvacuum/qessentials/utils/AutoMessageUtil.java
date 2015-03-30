
package pl.za.xvacuum.qessentials.utils;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import pl.za.xvacuum.qessentials.Main;


public class AutoMessageUtil {
	
	public static FileConfiguration cfg = Main.getInstance().getConfig();
	public static List<String> list = cfg.getStringList("automessages");
	
	public static List<String> getList()
	{
		return list;
	}
	
	public static void sendRandomMessage()
	{
		if(getNumberOfMessages() == 0 || list == null){
			LogUtil.warn("Nie znaleziono zadnych wiadomosci do automessage! Wylaczanie funkcji...");
			return;
		}
		Random random = new Random(); 
		String message = list.get(random.nextInt(list.size())); 
		Bukkit.broadcastMessage(Util.setHEX(message));
			
		
	}
	
	public static int getNumberOfMessages()
	{
		return list.size();
	}
	
	public static void getMessages()
	{
		if(getNumberOfMessages() == 0){
			LogUtil.warn("Nie znaleziono zadnych automessage! Wylaczanie funkcji...");
			return;
		}
	}
	
	public static void getRandomMessagesFromConfig()
	{
		for (String msg : list){
			list.add(msg);
			LogUtil.debug("Dodano '" + msg + "' do automessage!");
		}
		LogUtil.info("Zaladowano automessage!");
	}

}
