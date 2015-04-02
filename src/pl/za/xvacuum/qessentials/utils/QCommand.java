package pl.za.xvacuum.qessentials.utils;


import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
	      Util.sendMessage(sender, "&cBrak uprawnien do wykonania tej czynnosci! &7("+this.uprawnienie+")");
	      return true;
	    }
	    if(!(sender instanceof Player)){
	    	Util.sendMessage(sender, "&cKonsola nie moze uzywac tych komend!");
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
