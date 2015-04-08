package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

import pl.za.xvacuum.qessentials.utils.HelpUtil;
import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Help extends QCommand{

	public Help() {
		super("help", "Pomoc", "/help", "help", Arrays.asList(new String[] { "qhelp", "qcommands", "commands", "pomoc", "qpomoc"}), false);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) 
	{
		if(args.length == 0){
			HelpUtil.sendHelp(1, sender);
		}else if (args.length == 1)
		{
			if(Util.isInteger(args[0])){
				if(args[0].equalsIgnoreCase("1"))
				{
					HelpUtil.sendHelp(1, sender);
					return;
				}
				if(args[0].equalsIgnoreCase("2"))
				{
					HelpUtil.sendHelp(2, sender);
					return;
				}
				if(args[0].equalsIgnoreCase("3"))
				{
					HelpUtil.sendHelp(3, sender);
					return;
				}
				if(args[0].equalsIgnoreCase("4"))
				{
					HelpUtil.sendHelp(4, sender);
					return;
				}
				else if ((!args[0].equalsIgnoreCase("1")) || (!args[0].equalsIgnoreCase("2") || (!args[0].equalsIgnoreCase("3"))))
				{
					Util.sendMessage(sender, "&cNie znaleziono strony o numerze &7" + args[0].toString() + "&c!");
					return;
				}
			}else{
				Util.sendMessage(sender, "&cStrona musi byc liczba!");
			}
		}
		
	}
	
	

}
