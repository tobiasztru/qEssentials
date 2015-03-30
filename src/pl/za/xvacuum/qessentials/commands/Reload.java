package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.LogUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Reload extends QCommand{

	public Reload() {
		super("qreload", "Przeladowanie konfiguracji", "qreload", "reload", Arrays.asList(new String[] { "qrl", "qreloadconfig", "reloadconfig", "rlconfig", "rlcfg", "reloadcfg" }));
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		Util.sendMessage(p, "&7Przeladowywanie konfiguracji pluginu &cqEssentials&7...");
		LogUtil.info("Reloading config...");
		Main.getInstance().reloadConfig();
		LogUtil.info("Reloaded!");
		Util.sendMessage(p, "&7Przeladowano! Sprawdz w konsoli czy wystapily bledy!");
		
	}

}
