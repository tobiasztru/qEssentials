
package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.KitLoader;
import pl.za.xvacuum.qessentials.utils.KitUtil;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Kit extends QCommand{

	public Kit() {
		super("kit", "Zestawy", "/kit <zestaw[list]>", "kit", Arrays.asList(new String[] { "zestaw", "qkit" }), true);
		
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
		if(args[0].equalsIgnoreCase("list"))
		{
			KitLoader.getSections(p);
			return;
		}else if (Main.getInstance().getConfig().get("kits." + args[0]) !=null){
			if(KitUtil.tryCooldown(p, args[0], Main.getInstance().getConfig().getInt("kits." + args[0] + ".delay") * 1000)){
				List<String> items = Main.getInstance().getConfig().getStringList("kits." + args[0] + ".items");
				if(items == null){
					LogUtil.error("Nie znaleziono funkcji 'items' w sekcji kitow '" + args[0] + "'!");
					return;
				}
				for(String item : items){
					Util.giveItems(p, new ItemStack(KitUtil.getItem(item)));
				}
				Util.sendMessage(p, "&7Otrzymales zestaw &c" + args[0].toString());
				return;
			}
			Util.sendMessage(p, "&7Ten zestaw mozesz wziasc co &c" + Main.getInstance().getConfig().getInt("kits." + args[0] + ".delay") + " sekund&7! Zaczekaj chwile!");
			return;
		}else{
			KitLoader.getSections(p);
			return;
		}
		
		
	}

}

