package pl.za.xvacuum.qessentials.commands;

public class Kit {
	
}
/**
package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.KitUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Kit extends QCommand{

	public Kit() {
		super("kit", "Zestawy", "/kit <zestaw[list]>", "kit", Arrays.asList(new String[] { "zestaw", "qkit" }));
		
	}
	
	public static FileConfiguration cfg = Main.getInstance().getConfig();

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if ((args.length == 0) || (args.length >= 2))
		{
			Util.sendMessage(p, "&cPoprawne uzycie: /kit <zestaw[list]>");
			return;
		}
		KitUtil kit = new KitUtil();
		if(args[0].equalsIgnoreCase("list"))
		{
			Util.sendMessage(p, "&7Dostepne zestawy: &c" + kit.getKits());
			return;
		}else if (p.hasPermission("")){
			for (KitUtil k : kit.getKits()){
				Inventory pi = p.getInventory();
				for (String item : kit.getItems()){
					Material is = Material.getMaterial(item);
					pi.addItem(new ItemStack(is, 16));
				}
				Util.sendMessage(p, "&7Uzyles zestaw &c" + k.getName().toString());
			}
			return;
		}else{
			Util.sendMessage(p, "&7Dostepne zestawy: &c" + kit.getKits().toString().replace("[", "").replace("]", ""));
			return;
		}
		
		
	}

}
*/
