package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import net.minecraft.util.org.apache.commons.lang3.StringUtils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.utils.Parser;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Item extends QCommand{

	public Item() {
		super("item", "Dawanie przedmiotow sobie", "/item <id:data> [liczba]", "item", Arrays.asList(new String[] { "qgive", "i", "qi" }), true);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
			if(args.length < 1 || args.length > 2) {
				Util.sendMessage(sender, "&cPoprawne uzycie: /item <id:data> [liczba]");
				return;
			}
			int amount = StringUtils.isNumeric(args[1]) ? Integer.parseInt(args[1]) : 64;
			ItemStack item = Parser.getItem(args[0], amount);
			if(item == null) {
				Util.sendMessage(sender, "&cNie ma takiego itemu!");
				return;
			}
			Util.giveItems((Player)sender, item);
			Util.sendMessage(sender, "&7Otrzymales &8(&c" + amount + "x&8) &c" + item.getType().name().toLowerCase().replace("_", " "));
			return;
			
	}	

}