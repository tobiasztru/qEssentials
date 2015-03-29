package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Message extends newCommand{

	public Message() {
		super("msg", "Komunikacja miedzy graczami", "/msg <player> <text>", "msg", Arrays.asList(new String[] { "qmsg", "message", "m", "qm", "tell", "t", "echo" }));
		
	}
	private static final HashMap<Player, Player> lastPlayer = new HashMap<Player, Player>();
	public static HashMap<Player, Player> getLastPlayer()
	{
	    return lastPlayer;
	}
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
	    if (args.length < 2) 
	    {
	        Util.sendMessage(p, "&cPrawidlowe uzycie: /msg <player> <text>");
	        return;
	    }
	    Player msgTo = Bukkit.getPlayerExact(args[0]);
	    if(msgTo == null)
	    {
	    	Util.sendMessage(p, "&cTaki gracz nie jest online!");
	    	return;
	    }
	    String message = ChatColor.stripColor(Util.setHEX(StringUtils.join(args, " ", 1, args.length)));
	    lastPlayer.put(p, msgTo);
	    lastPlayer.put(msgTo, p);
	    Util.sendMessage(p, "&7[&cJa &7-> &c" + msgTo.getName() + "&7] &f" + message);
	    Util.sendMessage(msgTo, "&7[&c" + p.getName() + "&7-> &cJa&7] &f" + message);
	    
	    
	    
		
	}

}
