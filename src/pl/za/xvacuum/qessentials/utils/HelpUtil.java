package pl.za.xvacuum.qessentials.utils;

import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.Main;

public class HelpUtil {
	
	public static void sendHelp(int page, CommandSender sender){
		if(page == 1){
			Util.sendMessage(sender, "&7Twoje dostepne &ckomendy&7:");
			if(sender.hasPermission("qessentials.info")) Util.sendMessage(sender, "&c  /qinfo &8- &7Informacje na temat pluginu");
			if(sender.hasPermission("qessentials.reload")) Util.sendMessage(sender, "&c  /qreload &8- &7Przeladowanie pluginu");
			if(sender.hasPermission("qessentials.helpop")) Util.sendMessage(sender, "&c  /helpop <tekst> &8- &7Szybki kontakt z administracja");
			if(sender.hasPermission("qessentials.help")) Util.sendMessage(sender, "&c  /help <strona> &8- &7Spis twoich komend");
			if(sender.hasPermission("qessentials.gc")) Util.sendMessage(sender, "&c  /gc &8- &7Kolekcja danych serwera");
			if(sender.hasPermission("qessentials.enchant")) Util.sendMessage(sender, "&c  /enchant <enchant> <level> &8- &7Enchantowanie przedmiotow");
			if(sender.hasPermission("qessentials.clear")) Util.sendMessage(sender, "&c  /clear &8- &7Czyszczenie ekwipunku");
			if(sender.hasPermission("qessentials.changename")) Util.sendMessage(sender, "&c  /changename <tekst["+Main.getInstance().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana nazwy przedmiotu");
			if(sender.hasPermission("qessentials.changelore")) Util.sendMessage(sender, "&c  /changelore <tekst["+Main.getInstance().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana opisu przedmiotu");
			if(sender.hasPermission("qessentials.adminchat")) Util.sendMessage(sender, "&c  /adminchat &8- &7Chat administratorow");
			Util.sendMessage(sender, "&7Strona &c1/4&7!");
		}else if(page == 2){
			Util.sendMessage(sender, "&7Twoje dostepne &ckomendy&7:");
			if(sender.hasPermission("qessentials.gamemode")) Util.sendMessage(sender, "&c  /gm <tryb> &8- &7Zmiana trybu gry"); 
			if(sender.hasPermission("qessentials.motd")) Util.sendMessage(sender, "&c  /motdset <motd> &8- &7Dynamiczna zmiana motd"); 
			if(sender.hasPermission("qessentials.time")) Util.sendMessage(sender, "&c  /time <day/night> &8- &7Zmiana czasu swiata"); 
			if(sender.hasPermission("qessentials.weather")) Util.sendMessage(sender, "&c  /weather <thunder/sun> &8- &7Zmiana pogody swiata"); 
			if(sender.hasPermission("qessentials.sethome")) Util.sendMessage(sender, "&c  /sethome &8- &7Ustawianie domu");
			if(sender.hasPermission("qessentials.home")) Util.sendMessage(sender, "&c  /home &8- &7Teleport do domu"); 
			if(sender.hasPermission("qessentials.teleport")) Util.sendMessage(sender, "&c  /tp <gracz[all]> [<gracz>] &8- &7Teleportowanie graczy"); 
			if(sender.hasPermission("qessentials.whois")) Util.sendMessage(sender, "&c  /whois [gracz] &8- &7Informacje na temat gracza"); 
			if(sender.hasPermission("qessentials.heal")) Util.sendMessage(sender, "&c  /heal [gracz] &8- &7Ulecza gracza");
			if(sender.hasPermission("qessentials.tppos")) Util.sendMessage(sender, "&c  /tppos [gracz] <x> <y> <z> &8- &7Teleportacja w okreslone koordynaty"); 
			Util.sendMessage(sender, "&7Strona &c2/4&7!");
		}else if (page == 3){
			Util.sendMessage(sender, "&7Twoje dostepne &ckomendy&7:");
			if(sender.hasPermission("qessentials.setspawn")) Util.sendMessage(sender, "&c  /setspawn &8- &7Ustawia globalny spawn");
			if(sender.hasPermission("qessentials.spawn")) Util.sendMessage(sender, "&c  /spawn &8- &7Teleportuje na spawn");
			if(sender.hasPermission("qessentials.msg")) Util.sendMessage(sender, "&c  /msg <gracz> <tekst> &8- &7Komunikacja z graczem");
			if(sender.hasPermission("qessentials.reply")) Util.sendMessage(sender, "&c  /reply <tekst> &8- &7Odpowiedz na wiadomosc");
			if(sender.hasPermission("qessentials.list")) Util.sendMessage(sender, "&c  /list &8- &7Lista graczy");
			if(sender.hasPermission("qessentials.chat")) Util.sendMessage(sender, "&c  /chat <off/on/clear>&8- &7Manipulacja czatem");
			if(sender.hasPermission("qessentials.fly")) Util.sendMessage(sender, "&c  /fly <on/off> <gracz> &8- &7Wlaczanie/wylaczanie fly");
			if(sender.hasPermission("qessentials.world")) Util.sendMessage(sender, "&c  /world <swiat> &8- &7Teleportacja na rozne swiaty");
			if(sender.hasPermission("qessentials.invsee")) Util.sendMessage(sender, "&c  /invsee <gracz> &8- &7Otwiera ekwipunek gracza");
			if(sender.hasPermission("qessentials.back")) Util.sendMessage(sender, "&c  /back &8- &7Teleportacja w ostatnie miejsce");
			Util.sendMessage(sender, "&7Strona &c3/3&7!");
		}else if (page == 4){
			Util.sendMessage(sender, "&7Twoje dostepne &ckomendy&7:");
			if(sender.hasPermission("qessentials.head")) Util.sendMessage(sender, "&c  /head <gracz> &8- &7Daje glowe gracza");
			if(sender.hasPermission("qessentials.kit")) Util.sendMessage(sender, "&c  /kit <zestaw[list]> &8- &7Daje zestaw");
			if(sender.hasPermission("qessentials.nick")) Util.sendMessage(sender, "&c  /nick <nowy nick> &8- &7Zmienia nick");
			if(sender.hasPermission("qessentials.repair")) Util.sendMessage(sender, "&c  /repair [all] &8- &7Naprawia itemy");
			if(sender.hasPermission("qessentials.tpa")) Util.sendMessage(sender, "&c  /tpa <gracz> &8- &7Teleportuje za prosba");
			if(sender.hasPermission("qessentials.tpaccept")) Util.sendMessage(sender, "&c  /tpaccept &8- &7Akceptuje teleport");
			if(sender.hasPermission("qessentials.tpdeny")) Util.sendMessage(sender, "&c  /tpdeny &8- &7Odrzuca teleport");
			if(sender.hasPermission("qessentials.give")) Util.sendMessage(sender, "&c  /give <item> <gracz> &8- &7Daje przedmioty");
			if(sender.hasPermission("qessentials.god")) Util.sendMessage(sender, "&c  /god <gracz> &8- &7Daje niezniszczalnosc");
			if(sender.hasPermission("qessentials.ban")) Util.sendMessage(sender, "&c  /ban <gracz> <powod> &8- &7Banuje gracza permamentnie");
			Util.sendMessage(sender, "&7Strona &c4/4&7!");
		}else if (page == 5){
			Util.sendMessage(sender, "&7Twoje dostepne &ckomendy&7:");
			if(sender.hasPermission("qessentials.unban")) Util.sendMessage(sender, "&c  /unban <gracz> &8- &7Odbanowywuje gracza");
			if(sender.hasPermission("qessentials.tempban")) Util.sendMessage(sender, "&c  /tempbane <gracz> <czas> <jednostka> <powod> &8- &7Banuje gracza na czas");
			if(sender.hasPermission("qessentials.mute")) Util.sendMessage(sender, "&c  /mute <gracz> <czas> <jednostka> <powod> &8- &7Wycisza gracza na czas");
			if(sender.hasPermission("qessentials.ender")) Util.sendMessage(sender, "&c  /ender <open/clear> <gracz> &8- &7Zarzadza enderchestem");
		}

	}

}
