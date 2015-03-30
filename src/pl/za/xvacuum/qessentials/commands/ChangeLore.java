package pl.za.xvacuum.qessentials.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class ChangeLore extends QCommand{

	public ChangeLore() {
		super("changelore", "Zmienia opis przedmiotu", "/changelore <lore>", "changelore", Arrays.asList(new String[] { "qchangelore", "qcl", "cl", "setlore", "sl", "qsetlore", "qsl"}));
		
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0)
		{
			Util.sendMessage(p, "&cPoprawne uzycie: /changelore <tekst>");
			return;
		}
		if(p.getInventory().getItemInHand().getType() == Material.AIR)
		{
			Util.sendMessage(p, "&cMusisz trzymac przedmiot aby dodac mu opis!");
			return;
		}else{
		    StringBuilder mb = new StringBuilder();
		    for (String a : args) {
		        if (mb.length() > 0) {
		            mb.append(" ");
		        }
		        mb.append(a);
		    }
		    ItemStack item = p.getInventory().getItemInHand();
		    ItemMeta meta = item.getItemMeta();
		    ArrayList<String> lore = new ArrayList<String>();
		    if (mb.toString().equalsIgnoreCase(Main.getInstance().getConfig().getString("changeitem-remove"))){
		    	meta.setLore(null);
		    }else{
		    	lore.add(Util.setHEX(mb.toString()));
		    	meta.setLore(lore);
		    }
		    item.setItemMeta(meta);
		    Util.sendMessage(p, "&7Poprawnie ustawiono opis: &c" + Util.setHEX(mb.toString().replace(Main.getInstance().getConfig().getString("changeitem-remove"), "&cwyczyszczono opis!")));
		}
	}

}
