package pl.za.xvacuum.qessentials.utils;


import net.minecraft.util.org.apache.commons.lang3.StringUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Parser {


	@SuppressWarnings("deprecation")
	public static ItemStack getItem(String item, int amount) {
		
		ItemStack itemR = null;
		try{
		short data;
		String[] split;
		
		if(!item.contains(":")) {
			split = new String[]{item};
			data = 0;
		} else {
			split = item.split(":");
			data = split[1].length() < 5 && split[1].length() > 0 ? Short.parseShort(split[1]) : 0;
		}
		
		String namer = split[0];
		
		if(StringUtils.isNumeric(namer)) {
			int id = namer.length() < 5 && namer.length() > 0 ? Integer.parseInt(namer) : 0;
			itemR = new ItemStack(Material.getMaterial(id), amount, data);
		} else {
			itemR = new ItemStack(Material.matchMaterial(namer.toUpperCase()), amount, data);
		}
		}catch(Exception e) {
			return null;
		}
		
		return itemR;
	}
	
}
