package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.ChatUtil;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class ChatManager extends QCommand{

	public ChatManager() {
		super("chat", "Manipulacja chatem", "/chat <on/off/clear>", "chat", Arrays.asList(new String[] { "czat", "qchat", "qczat", "qc", "c"}));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if((args.length == 0) || (args.length >= 2)){
			Util.sendMessage(p, "&cPoprawne uzycie: /chat <on/off/clear>");
			return;
		}else if (args.length == 1){
			if(args[0].equalsIgnoreCase("on")){
				if(ChatUtil.getChat() == false){
					ChatUtil.setChat("on");
					Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("chat-on")));
					return;
				}else{
					Util.sendMessage(p, "&cChat jest juz wlaczony!");
					return;
				}
			}
			if(args[0].equalsIgnoreCase("off")){
				if(ChatUtil.getChat() == true){
					ChatUtil.setChat("off");
					Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("chat-off")));
					return;
				}else{
					Util.sendMessage(p, "&cChat jest juz wylaczony!");
					return;
				}
			}
			if(args[0].equalsIgnoreCase("clear")){
				ChatUtil.clearChat();
				Bukkit.broadcastMessage(Util.setHEX(Main.getInstance().getConfig().getString("chat-clear")));
				return;
			}else{
				Util.sendMessage(p, "&cPoprawne uzycie: /chat <on/off/clear>");
				return;
			}
		}
		
	}

}
