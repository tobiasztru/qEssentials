package pl.za.xvacuum.qessentials.utils;


import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class QCommand extends Command{
	
	  private String uprawnienie;

	  public QCommand(String name, String description, String usage, String permission, List<String> aliases)
	  {
	    super(name, description, usage, aliases);
	    this.uprawnienie = ("qessentials." + uprawnienie);
	  }

	  public final boolean execute(CommandSender sender, String s, String[] args)
	  {
	    if (!sender.hasPermission(this.uprawnienie)) {
	      sender.sendMessage(ChatColor.RED + "Brak uprawnien do wykonania tej czynnosci! " + ChatColor.GRAY + "("+this.uprawnienie+")");
	      return true;
	    }
	    try {
	        onExecute(sender, args);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        Util.sendMessage(sender, "Wykryto naganny blad podczas wykonywania tej komendy. Zobacz logi konsoli po tresc bledu.");
	    }
	    return true;
	  }
	  public abstract void onExecute(CommandSender sender, String[] args);

}
