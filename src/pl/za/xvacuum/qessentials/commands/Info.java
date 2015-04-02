package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Info extends QCommand{

	public Info() {
		super("qinfo", "Informacje na temat pluginu", "/qinfo", "info", Arrays.asList(new String[] { "qinfo", "qversion", "qver", "informacje", "wersja" }));
	}
 
	private static PluginDescriptionFile desc = Main.getInstance().getDescription();
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		Util.sendMessage(p, "&7Informacje na temat &cqEssentials&7:");
		Util.sendMessage(p, "&7  Wersja: &c" + desc.getVersion());
		Util.sendMessage(p, "&7  Autorzy: &cxVacuum (dev), xSmokBezioxKox (tester)");
		Util.sendMessage(p, "&7  Strona: &c" + desc.getWebsite());
		Util.sendMessage(p, "&7Lubisz plugin? Daj znac na &chttp://mpcforum.pl&7!");
	}

}
