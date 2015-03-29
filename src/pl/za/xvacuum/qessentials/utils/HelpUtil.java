package pl.za.xvacuum.qessentials.utils;

import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;

public class HelpUtil {
	
	public static void sendHelp(int page, Player p){
		if(page == 1){
			Util.sendMessage(p, "&7Twoje dostepne &ckomendy&7:");
			if(p.hasPermission("qessentials.info")) Util.sendMessage(p, "&c  /qinfo &8- &7Informacje na temat pluginu");
			if(p.hasPermission("qessentials.reload")) Util.sendMessage(p, "&c  /qreload &8- &7Przeladowanie pluginu");
			if(p.hasPermission("qessentials.helpop")) Util.sendMessage(p, "&c  /helpop <tekst> &8- &7Szybki kontakt z administracja");
			if(p.hasPermission("qessentials.help")) Util.sendMessage(p, "&c  /help <strona> &8- &7Spis twoich komend");
			if(p.hasPermission("qessentials.gc")) Util.sendMessage(p, "&c  /gc &8- &7Kolekcja danych serwera");
			if(p.hasPermission("qessentials.enchant")) Util.sendMessage(p, "&c  /enchant <enchant> <level> &8- &7Enchantowanie przedmiotow");
			if(p.hasPermission("qessentials.clear")) Util.sendMessage(p, "&c  /clear &8- &7Czyszczenie ekwipunku");
			if(p.hasPermission("qessentials.changename")) Util.sendMessage(p, "&c  /changename <tekst["+Main.getInstance().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana nazwy przedmiotu");
			if(p.hasPermission("qessentials.changelore")) Util.sendMessage(p, "&c  /changelore <tekst["+Main.getInstance().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana opisu przedmiotu");
			if(p.hasPermission("qessentials.adminchat")) Util.sendMessage(p, "&c  /adminchat &8- &7Chat administratorow");
			Util.sendMessage(p, "&7Strona &c1/2&7!");
		}else if(page == 2){
			Util.sendMessage(p, "&7Twoje dostepne &ckomendy&7:");
			if(p.hasPermission("qessentials.gamemode")) Util.sendMessage(p, "&c  /gm <tryb> &8- &7Zmiana trybu gry"); 
			Util.sendMessage(p, "&7Strona &c2/2&7!");
		}
	}

}
