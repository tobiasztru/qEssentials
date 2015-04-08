package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class QReload extends QCommand{

	public QReload() {
		super("qreload", "Przeladowanie konfiguracji", "qreload", "qreload", Arrays.asList("qrl", "qreloadconfig", "reloadconfig", "rlconfig", "rlcfg", "reloadcfg"), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Util.sendMessage(sender, "&7Przeladowywanie konfiguracji pluginu &cqEssentials&7...");
		LogUtil.info("Reloading config...");
		Main.getInstance().reloadConfig();
		LogUtil.info("Reloaded!");
		Util.sendMessage(sender, "&7Przeladowano! Sprawdz w konsoli czy wystapily bledy!");
		
	}

}
