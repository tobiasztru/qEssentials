package pl.za.xvacuum.qessentials.utils;

import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

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
		KitUtil.getKits().add(kit);
	}
	
	public static void getSections(Player p)
	{
		String msg = "";
		for(String s : Main.getInstance().getConfig().getConfigurationSection("kits").getKeys(false)){
			msg += ", " + s;
		}
		Util.sendMessage(p, "&7Dostepne zestawy: &c" + msg.replaceFirst(", ", ""));
	}

}

