package pl.za.xvacuum.qessentials.utils;


import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class QCommand extends Command{
	
	  private String uprawnienie;
	  private boolean playerOnly = true;
	  
	  public QCommand(String name, String description, String usage, String permission, List<String> aliases)
	  {
	    super(name, description, usage, aliases);
	   
	    this.uprawnienie = ("qessentials." + permission);
	  }

	  public QCommand(String name, String description, String usage, String permission, List<String> aliases, boolean playerOnly)
	  {
	    super(name, description, usage, aliases);
	    this.playerOnly = playerOnly;
	    this.uprawnienie = ("qessentials." + permission);
	  }
	  

	  
	  public final boolean execute(CommandSender sender, String s, String[] args)
	  {
	    if (!sender.hasPermission(this.uprawnienie)) {
	      Util.sendMessage(sender, "&cBrak uprawnien do wykonania tej czynnosci!");
	      return true;
	    }
	    if(this.playerOnly) {
	    if(!(sender instanceof Player)){
	    	Util.sendMessage(sender, "&cKonsola nie moze uzywac tych komend!");
	    	return true;
	    }
	    }
	    try {
	        onExecute(sender, args);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        Util.sendMessage(sender, "&4Blad krytyczny: &cWykryto naganny blad podczas wykonywania tej komendy. Zobacz logi konsoli po tresc bledu.");
	    }
	    return true;
	  }
	  public abstract void onExecute(CommandSender sender, String[] args);

}
