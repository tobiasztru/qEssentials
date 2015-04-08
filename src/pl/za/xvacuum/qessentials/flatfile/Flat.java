package pl.za.xvacuum.qessentials.flatfile;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.objects.QBan;
import pl.za.xvacuum.qessentials.utils.LogUtil;

public class Flat {

	
	public static YamlConfiguration createPlayerData(String player)
	{
		File folder = new File(Main.getInstance().getDataFolder(), "userdata");
		
		File data = new File(folder, player + ".yml");
		
		if(!data.exists()){
			try{
				data.createNewFile();
				return YamlConfiguration.loadConfiguration(data);
			}catch(IOException o){
				o.printStackTrace();
				LogUtil.error("Nie udalo sie wczytac danych gracza");
			}
		}
		return YamlConfiguration.loadConfiguration(data);
	}
	
	public static void prepare() {
		File f = new File(Main.getInstance().getDataFolder().getAbsolutePath(), "bandata");
		if(!f.exists()) {
			f.mkdirs();
			System.out.println("Wygenerowano folder: /bandata/");
		}
		
		File f2 = new File(Main.getInstance().getDataFolder().getAbsolutePath(), "userdata");
		if(!f2.exists()) {
			f2.mkdirs();
			System.out.println("Wygenerowano folder: /userdata/");
		}
	}
	
	public static YamlConfiguration createBanData(QBan ban) {
		
		File folder = new File(Main.getInstance().getDataFolder(), "bandata");
		
		File data = new File(folder, ban.getVictim() + ".yml");
	
		if(!data.exists()){
			try{
				data.createNewFile();
				return YamlConfiguration.loadConfiguration(data);
			}catch(IOException o){
				o.printStackTrace();
				LogUtil.error("Nie udalo sie wczytac danych bana");
			}
		}
		return YamlConfiguration.loadConfiguration(data);
	}
	
	public static YamlConfiguration getBanData(String victim) {
		File folder = new File(Main.getInstance().getDataFolder(), "bandata");
		File data = new File(folder, victim + ".yml");
		if(!data.exists() || data == null){
			System.out.println("Data " + victim + " jest nullem.");
			return null;
		}
		YamlConfiguration playerData = YamlConfiguration.loadConfiguration(data);
		return playerData;
	}
	

	
	public static YamlConfiguration getData(String player)
	{
		File folder = new File(Main.getInstance().getDataFolder(), "userdata");
		File data = new File(folder, player + ".yml");
		if(!data.exists() || data == null){
			System.out.println("Data " + player + " jest nullem.");
			return null;
		}

		YamlConfiguration playerData = YamlConfiguration.loadConfiguration(data);
		return playerData;
	}
	
	
	
	

}
