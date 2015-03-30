package pl.za.xvacuum.qessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import pl.za.xvacuum.qessentials.Main;


public class AutoMessageUtil {
	
	public static FileConfiguration cfg = Main.getInstance().getConfig();
	// Tymczasowe automessage :u
	public static void sendRandomMessage(){
		String am1 = cfg.getString("automessage.1"); 
		String am2 = cfg.getString("automessage.2"); 
		String am3 = cfg.getString("automessage.3"); 
		String am4 = cfg.getString("automessage.4"); 
		String am5 = cfg.getString("automessage.5"); 
		String am6 = cfg.getString("automessage.6"); 
		String am7 = cfg.getString("automessage.7"); 
		String am8 = cfg.getString("automessage.8"); 
		String am9 = cfg.getString("automessage.9"); 
		String am10 = cfg.getString("automessage.10");
		if ((am1 == "" || am1 == null)) 
		{
			am1 = null;
		}
		if ((am2 == "" || am1 == null)) 
		{
			am2 = null;
		}
		if ((am3 == "" || am1 == null)) 
		{
			am3 = null;
		}
		if ((am4 == "" || am1 == null)) 
		{
			am4 = null;
		}
		if ((am5 == "" || am1 == null)) 
		{
			am5 = null;
		}
		if ((am6 == "" || am1 == null)) 
		{
			am6 = null;
		}
		if ((am7 == "" || am1 == null)) 
		{
			am7 = null;
		}
		if ((am8 == "" || am1 == null)) 
		{
			am8 = null;
		}
		if ((am9 == "" || am1 == null)) 
		{
			am9 = null;
		}
		if ((am10 == "" || am1 == null)) 
		{
			am10 = null;
		}
		int rand = Util.getRandomInt(1, 10);
		if (rand == 1){
			Bukkit.broadcastMessage(Util.setHEX(am1));
			return;
		}
		if (rand == 2){
			Bukkit.broadcastMessage(Util.setHEX(am2));
			return;
		}
		if (rand == 3){
			Bukkit.broadcastMessage(Util.setHEX(am3));
			return;
		}
		if (rand == 4){
			Bukkit.broadcastMessage(Util.setHEX(am4));
			return;
		}
		if (rand == 5){
			Bukkit.broadcastMessage(Util.setHEX(am5));
			return;
		}
		if (rand == 6){
			Bukkit.broadcastMessage(Util.setHEX(am6));
			return;
		}
		if (rand == 7){
			Bukkit.broadcastMessage(Util.setHEX(am7));
			return;
		}
		if (rand == 8){
			Bukkit.broadcastMessage(Util.setHEX(am8));
			return;
		}
		if (rand == 9){
			Bukkit.broadcastMessage(Util.setHEX(am9));
			return;
		}
		if (rand == 10){
			Bukkit.broadcastMessage(Util.setHEX(am10));
			return;
		}
	}
	
	
}








// TUTAJ PROSZÊ O POMOC :/

/**
package pl.za.xvacuum.qessentials.utils;

import java.util.List;

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
		int random = Util.getRandomInt(1, getNumberOfMessages());
		if(random == co?){
			Tutaj utkn¹³em, proszê o pomoc, tymczasowo bêdzie 10 automessage które mo¿na wy³¹czyæ ... sorka :/
			
		}
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
*/