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
			Util.sendMessage(p, "&7Strona &c1/3&7!");
		}else if(page == 2){
			Util.sendMessage(p, "&7Twoje dostepne &ckomendy&7:");
			if(p.hasPermission("qessentials.gamemode")) Util.sendMessage(p, "&c  /gm <tryb> &8- &7Zmiana trybu gry"); 
			if(p.hasPermission("qessentials.motd")) Util.sendMessage(p, "&c  /motdset <motd> &8- &7Dynamiczna zmiana motd"); 
			if(p.hasPermission("qessentials.time")) Util.sendMessage(p, "&c  /time <day/night> &8- &7Zmiana czasu swiata"); 
			if(p.hasPermission("qessentials.weather")) Util.sendMessage(p, "&c  /weather <thunder/sun> &8- &7Zmiana pogody swiata"); 
			if(p.hasPermission("qessentials.sethome")) Util.sendMessage(p, "&c  /sethome &8- &7Ustawianie domu");
			if(p.hasPermission("qessentials.home")) Util.sendMessage(p, "&c  /home &8- &7Teleport do domu"); 
			if(p.hasPermission("qessentials.teleport")) Util.sendMessage(p, "&c  /tp <gracz[all]> [<gracz>] &8- &7Teleportowanie graczy"); 
			if(p.hasPermission("qessentials.whois")) Util.sendMessage(p, "&c  /whois [gracz] &8- &7Informacje na temat gracza"); 
			if(p.hasPermission("qessentials.heal")) Util.sendMessage(p, "&c  /heal [gracz] &8- &7Ulecza gracza");
			if(p.hasPermission("qessentials.tppos")) Util.sendMessage(p, "&c  /tppos [gracz] <x> <y> <z> &8- &7Teleportacja w okreslone koordynaty"); 
			Util.sendMessage(p, "&7Strona &c2/3&7!");
		}else if (page == 3){
			Util.sendMessage(p, "&7Twoje dostepne &ckomendy&7:");
			if(p.hasPermission("qessentials.setspawn")) Util.sendMessage(p, "&c  /setspawn &8- &7Ustawia globalny spawn");
			if(p.hasPermission("qessentials.spawn")) Util.sendMessage(p, "&c  /spawn &8- &7Teleportuje na spawn");
			if(p.hasPermission("qessentials.msg")) Util.sendMessage(p, "&c  /msg <gracz> <tekst> &8- &7Komunikacja z graczem");
			if(p.hasPermission("qessentials.reply")) Util.sendMessage(p, "&c  /reply <tekst> &8- &7Odpowiedz na wiadomosc");
			if(p.hasPermission("qessentials.list")) Util.sendMessage(p, "&c  /list &8- &7Lista graczy");
			if(p.hasPermission("qessentials.chat")) Util.sendMessage(p, "&c  /chat <off/on/clear>&8- &7Manipulacja czatem");
			Util.sendMessage(p, "&7Strona &c3/3&7!");
		}
	}

}
