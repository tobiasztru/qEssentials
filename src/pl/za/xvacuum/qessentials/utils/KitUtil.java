package pl.za.xvacuum.qessentials.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;



public class KitUtil {
	
	public static List<KitUtil> kits = new ArrayList<KitUtil>();
	public static List<KitUtil> getKits()
	{
		return kits;
	}
	
	private String name;
	private long delay;
	private List<String> items;
	
	public String getName()
	{
		return this.name;
	}
	
	public long getDelay()
	{
		return this.delay;
	}
	
	public List<String> getItems()
	{
		return this.items;
	}
	
	
	public void setDelay(long delay)
	{
		this.delay = delay;
	}
	
	public void setItems(List<String> items)
	{
		this.items = items;
	}
	
	public static ItemStack getItem(String item) 
	{
	    String[] splits = item.split("@");
	    if (splits.length < 2)
	    {
	      return new ItemStack(Material.getMaterial(splits[0]));
	    }
	    if (splits.length == 2) 
	    {
	      return new ItemStack(Material.getMaterial(splits[0]), Util.parseInteger(splits[1]).shortValue());
	    }
	    return new ItemStack(Material.AIR);
	}
	
	private static Table<String, String, Long> cooldown = HashBasedTable.create();

	public static long getCooldown(Player player, String key) {
		return calculateRemainder((Long)cooldown.get(player.getName(), key));
	}

	public static long setCooldown(Player player, String key, long delay) {
		return calculateRemainder((Long)cooldown.put(player.getName(), key, Long.valueOf(System.currentTimeMillis() + delay)));
	}

	public static boolean tryCooldown(Player player, String key, long delay) {
		if (getCooldown(player, key) <= 0L) {
			setCooldown(player, key, delay);
			return true;
		}
		return false;
	}

	private static long calculateRemainder(Long expireTime) {
		return expireTime != null ? expireTime.longValue() - System.currentTimeMillis() : -9223372036854775808L;
	}
	

}
