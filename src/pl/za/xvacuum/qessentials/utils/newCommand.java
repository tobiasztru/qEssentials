package pl.za.xvacuum.qessentials.utils;


import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class newCommand extends Command{
	
	  private String uprawnienie;

	  public newCommand(String nazwa, String opis, String uzycie, String uprawnienie, List<String> aliasy)
	  {
	    super(nazwa, opis, uzycie, aliasy);
	    this.uprawnienie = ("qessentials." + uprawnienie);
	  }

	  public final boolean execute(CommandSender sender, String s, String[] args)
	  {
	    if (!sender.hasPermission(this.uprawnienie)) {
	      sender.sendMessage(ChatColor.RED + "Brak uprawnien do wykonania tej czynnosci! " + ChatColor.GRAY + "("+this.uprawnienie+")");
	      return true;
	    }
	    onExecute(sender, args);
	    return true;
	  }
	  public abstract void onExecute(CommandSender sender, String[] args);

}
