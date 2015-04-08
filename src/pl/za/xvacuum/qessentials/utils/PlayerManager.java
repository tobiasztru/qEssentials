package pl.za.xvacuum.qessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.Main;

public class PlayerManager {
	
	public static void addPlayer(Player p){
		if(!p.hasPlayedBefore()){
			if(Main.getInstance().getConfig().getBoolean("start-items") == true){
				Inventory pi = p.getInventory();
				for (String item : Main.getInstance().getConfig().getStringList("items")){
					pi.addItem(new ItemStack(KitUtil.getItem(item)));
				}
			}
			Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("first-message").replace("{PLAYER}", p.getName())));
		}
		if(Main.getInstance().getConfig().getBoolean("motd-show") == true){
			for(String s : Main.getInstance().getConfig().getStringList("motd")){
				Util.sendMessage(p, s.replace("{PLAYER}", p.getName()));
			}
		}
		
	}


}
