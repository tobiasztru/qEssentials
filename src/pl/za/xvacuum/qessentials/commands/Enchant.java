package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.utils.EnchantUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Enchant extends QCommand{

	public Enchant() {
		super("enchant", "Enchantowanie przedmiotow", "/enchant <enchant> <level>", "enchant", Arrays.asList(new String[] { }), true);
		
	}
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if ((args.length == 1) || (args.length == 2)) 
		{
			ItemStack item = p.getItemInHand();
		    String enchantName = args[0];
		    Enchantment enchant = EnchantUtil.get(enchantName);
		    if (enchant == null) {
		        Util.sendMessage(p, "&cTakie zaklecie nie istnieje!");
		        return;
		    }
		    int level = enchant.getMaxLevel();
		    if (args.length == 2) {
		    	if(Util.isInteger(args[1])){
		    		level = Integer.parseInt(args[1]);
		    	}else{
		    		Util.sendMessage(p, "&cPoziom musi byc liczba!");
		    		return;
		    	}
		    }
		    item.addUnsafeEnchantment(enchant, level);
		    Util.sendMessage(p, "&7Nalozono enchant &c" + enchant.getName().toLowerCase().replace("_", " ") + " (" + level + ")" + " &7na przedmiot w Twojej rece!");
		}else{
			Util.sendMessage(p, "&cPoprawne uzycie: /enchant <enchant> <level>");
		}
		
	}
	
	

}
