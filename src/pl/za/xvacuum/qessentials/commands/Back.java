package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.BackUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

public class Back extends QCommand{

	public Back() {
		super("back", "Teleportuje w ostatnie miejsce", "/back", "back", Arrays.asList(new String[] { "qback", "qb", "powrot" } ));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(BackUtil.getLastLocation(p) == null)
		{
			Util.sendMessage(p, "&cNie znaleziono poprzedniego miejsca!");
			return;
		}
		TimeUtil.teleportDelay(p, BackUtil.getLastLocation(p));
		
	}

}
