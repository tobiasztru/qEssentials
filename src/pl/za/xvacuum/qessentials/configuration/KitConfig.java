
package pl.za.xvacuum.qessentials.configuration;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.za.xvacuum.qessentials.Main;

public class KitConfig {
	
	private static FileConfiguration kitConfig = null;
	private static File kitConfigFile = null;
	
	public static void createConfig()
	{
		if(kitConfigFile == null)
		{
			kitConfigFile = new File(Main.getInstance().getDataFolder(), "kits.yml");
		}
		kitConfig = YamlConfiguration.loadConfiguration(kitConfigFile);
	}
	
	public static FileConfiguration getConfig()
	{
		return kitConfig;
	}
	
	

}

