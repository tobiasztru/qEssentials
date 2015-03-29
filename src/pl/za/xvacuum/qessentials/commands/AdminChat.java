package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class AdminChat extends newCommand{

	public AdminChat() {
		super("adminchat", "Chat administratorow", "/adminchat [tekst]", "adminchat", Arrays.asList(new String[] { "qadminchat", "qac", "ac", "adminc", "achat"}));
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		
	    if (args.length > 0) {
	        String message = new StringBuilder().append(ChatColor.RED).append(Main.getInstance().getConfig().getString("adminchat-format")).toString();

	        message = message.replace("{PLAYER}", sender.getName());
	        

	        StringBuilder msg = new StringBuilder();
	        msg.append(args[0]);
	        for (int i = 1; i < args.length; i++) {
	          msg.append(" ").append(args[i]);
	        }

	        message = message.replace("{MESSAGE}", msg.toString());

	        message = Util.setHEX(message);
	        for (Player p : Bukkit.getOnlinePlayers()) {
	          if (p.hasPermission("qessentials.adminchat.see")){
	        	  p.sendMessage(message);
	          }
	        Bukkit.getConsoleSender().sendMessage(message);
	        return;
	      }


	    }else{
	    	Util.sendMessage((Player)sender, "&cPoprawne uzycie: /adminchat <tekst>");
	    }
	}

}
