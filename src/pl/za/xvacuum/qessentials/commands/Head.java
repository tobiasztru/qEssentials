package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Head extends QCommand{

	public Head() {
		super("head", "Pobieranie glowy gracza", "/head <gracz>", "head", Arrays.asList(new String[] { "glowa", "qhead" }));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 2))
		{
			Util.sendMessage(p, "&cPoprawne uzycie: /head <gracz>");
			return;
		}
		Player arg = Bukkit.getPlayer(args[0]);
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
		SkullMeta sm = (SkullMeta) head.getItemMeta();
		sm.setDisplayName(Util.setHEX("&7Glowa gracza &c" + arg.getName()));
		sm.addEnchant(Enchantment.DURABILITY, 10, true);
		sm.setOwner(arg.getName());
		head.setItemMeta(sm);
		p.getInventory().addItem(head);
		Util.sendMessage(p, "&7Otrzymales glowe gracza &c" + arg.getName());
		return;
	}
	
	

}
