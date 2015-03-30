package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class Helpop extends QCommand{

	private Map<CommandSender, Long> time = new WeakHashMap<CommandSender, Long>();
	
	public Helpop() {
		super("helpop", "Szybki kontakt z administratorem", "/helpop [tekst]", "helpop", Arrays.asList(new String[] { }));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onExecute(CommandSender sender, String[] args) {
	    Long t = (Long)this.time.get(sender);
	    long delay = Main.getInstance().getConfig().getLong("helpop-delay");
	    if ((t != null) && (System.currentTimeMillis() - t.longValue() < delay * 1000)) {
	    	Util.sendMessage((Player)sender, "&7Musisz poczekac &c"+delay+"s &7aby ponownie wyslac helpop!".replace("L", "s"));
	        return;
	    }
	    if (args.length == 0) {
	    	Util.sendMessage((Player)sender, "&cPoprawne uzycie: /helpop <tekst>");
	        return;
	    }
	    this.time.put(sender, Long.valueOf(System.currentTimeMillis()));
	    StringBuilder mb = new StringBuilder();
	    for (String a : args) {
	        if (mb.length() > 0) {
	            mb.append(" ");
	        }
	        mb.append(a);
	    }
	    String message = Main.getInstance().getConfig().getString("helpop-format").replace("{MESSAGE}", mb.toString()).replace("{PLAYER}", sender.getName());
	    Bukkit.getConsoleSender().sendMessage(Util.setHEX(message));
	    for (Player p : Bukkit.getOnlinePlayers())
	        if (p.hasPermission("qessentials.helpop.see"))
	          p.sendMessage(Util.setHEX(message));
	  }
	

}
