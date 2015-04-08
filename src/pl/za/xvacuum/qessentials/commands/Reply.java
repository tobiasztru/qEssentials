package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Reply extends QCommand{

	public Reply() {
		super("reply", "Odpowiedz na wiadomosc", "/reply <text>", "reply", Arrays.asList(new String[] { "r", "rtell", "qr", "qreply" }), true);
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
	    if (args.length < 1) 
	    {
	        Util.sendMessage(p, "&cPrawidlowe uzycie: /reply <text>");
	        return;
	    }
	    Player msgLast = Message.getLastPlayer().get(p);
	    if (msgLast == null)
	    {
	    	Util.sendMessage(p, "&cNie masz komu odpisac!");
	    	return;
	    }
	    Player lastPlayer = Bukkit.getPlayerExact(msgLast.getName());
	    if (lastPlayer == null)
	    {
	    	Util.sendMessage(p, "&cGracz nie jest online!");
	    	return;
	    }
	    StringBuilder message = new StringBuilder();
	    for (String a : args) {
	        if (message.length() > 0) {
	            message.append(" ");
	        }
	        message.append(a);
	    }
	    Message.getLastPlayer().put(p, lastPlayer);
	    Message.getLastPlayer().put(lastPlayer, p);
	    Util.sendMessage(p, "&7[&cJa &7-> &c" + lastPlayer.getName() + "&7] &f" + message);
	    Util.sendMessage(lastPlayer, "&7[&c" + p.getName() + "&7-> &cJa&7] &f" + message);
		
	}

}
