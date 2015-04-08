package pl.za.xvacuum.qessentials;

import org.bukkit.configuration.file.FileConfiguration;

public class Runtime {
	
	private static FileConfiguration cfg = Main.getInstance().getConfig();
	
	public static DataType getMySQL()
	{
		if((cfg.getString("type").equalsIgnoreCase("flatfile")) || (cfg.getString("type").equalsIgnoreCase("flat")) || (cfg.getString("type").equalsIgnoreCase("file"))){
			return DataType.FLAT;
		}else if ((cfg.getString("type").equalsIgnoreCase("mysql")) || (cfg.getString("type").equalsIgnoreCase("sql"))){
			return DataType.SQL;
		}else{
			return null;
		}
	}
	
	
	
	public enum DataType{
		FLAT,
		SQL;
	}
	

	

}
