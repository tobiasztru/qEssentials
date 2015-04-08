package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import net.minecraft.util.org.apache.commons.lang3.StringUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.utils.Parser;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Give extends QCommand{

	public Give() {
		super("give", "Dawanie przedmiotow", "/give <nick> <id:data> [liczba]", "give", Arrays.asList("qgive"), false);
	}
	
	@Override
	public void onExecute(CommandSender sender, String[] args) {
			if(args.length < 2 || args.length > 3) {
				Util.sendMessage(sender, "&cPoprawne uzycie: /item <gracz> <id:data> [liczba]");
				return;
			}
			final Player other = Bukkit.getPlayer(args[0]);
			if(other == null){
				Util.sendMessage(sender, "&cTaki gracz nie jest online!");
				return;
			}
			int amount = StringUtils.isNumeric(args[2]) ? Integer.parseInt(args[2]) : 64;
			ItemStack item = Parser.getItem(args[1], amount);
			if(item == null) {
				Util.sendMessage(sender, "&cNie ma takiego itemu!");
				return;
			}
			
			Util.giveItems(other, item);
			Util.sendMessage(sender, "&7Gracz &c" + other.getName() + " &7otrzymal (&c" + amount + "x&7) &c" + args[2]);
			return;
			
	}
}
