package pl.za.xvacuum.qessentials.utils;

public class KitLoader {
	
}
/**


import java.util.List;

import org.bukkit.configuration.ConfigurationSection;

import pl.za.xvacuum.qessentials.Main;

public class KitLoader {
	
	public static void loadKits()
	{
		ConfigurationSection csLoad = Main.getInstance().getConfig().getConfigurationSection("kits");
		KitUtil kit = new KitUtil();
		for (String s : csLoad.getKeys(false)){
			ConfigurationSection cs = csLoad.getConfigurationSection(s);
			long delay = cs.getLong("delay");
			List<String> items = cs.getStringList("items");
			if(items == null){
				LogUtil.error(" [KIT # PARSER] Nie znaleziono ustawienia 'items' w jednym z kitow!");
				return;
			}
			
			kit.setDelay(delay);
			kit.setItems(items);
		}
		kit.getKits().add(kit);
	}

}
*/
