package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Info extends QCommand{

	public Info() {
		super("qinfo", "Informacje na temat pluginu", "/qinfo", "info", Arrays.asList(new String[] { "qinfo", "qversion", "qver", "informacje", "wersja" }), false);
	}
 
	private static PluginDescriptionFile desc = Main.getInstance().getDescription();
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Util.sendMessage(sender, "&7Informacje na temat &cqEssentials&7:");
		Util.sendMessage(sender, "&7  Wersja: &c" + desc.getVersion());
		Util.sendMessage(sender, "&7  Autorzy: &cxVacuum(Dev), NTSW (Dev), Kresrek007 (Dev), cubeman (mini-dev), xSmokBezioxKox (tester)");
		Util.sendMessage(sender, "&7  Strona: &c" + desc.getWebsite());
		Util.sendMessage(sender, "&7Lubisz plugin? Daj znac na &chttp://mpcforum.pl&7!");
	}
}
		

