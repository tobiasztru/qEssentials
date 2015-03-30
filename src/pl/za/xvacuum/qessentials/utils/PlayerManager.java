package pl.za.xvacuum.qessentials.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.Main;

public class PlayerManager {
	
	public final static List<Player> onlinePlayers = new ArrayList<Player>();
	
	public static List<Player> getOnlinePlayers(){
		return onlinePlayers;
	}
	
	public static void addPlayer(Player p){
		onlinePlayers.add(p);
		if(!p.hasPlayedBefore()){
			if(Main.getInstance().getConfig().getBoolean("start-items") == true){
				Inventory pi = p.getInventory();
				pi.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.COOKED_BEEF, 128));
				pi.addItem(new ItemStack(Material.ENDER_CHEST, 1));
				pi.addItem(new ItemStack(Material.TORCH, 16));
				pi.addItem(new ItemStack(Material.BOAT, 2));
			}
			Bukkit.broadcastMessage(Util.setHEX("&7Witamy gracza &c" + p.getName() + " &7po raz pierwszy na serwerze!"));
		}
		if(Main.getInstance().getConfig().getBoolean("motd-show") == true){
			for(String s : Main.getInstance().getConfig().getStringList("motd")){
				Util.sendMessage(p, s.replace("{PLAYER}", p.getName()));
			}
		}
		
	}
	public static void removePlayer(Player p){
		onlinePlayers.remove(p);
	}

}
