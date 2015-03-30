package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;




import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.QCommand;

public class ChangeName extends QCommand{

	public ChangeName() {
		super("changename", "Zmiana nazwy przedmiotu", "/changename <tekst>", "changename", Arrays.asList(new String[] { "qchangename", "qcn", "cn", "setname", "sn", "qsetname", "qsn"}));

	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0)
		{
			Util.sendMessage(p, "&cPoprawne uzycie: /changename <tekst>");
			return;
		}
		if(p.getInventory().getItemInHand().getType() == Material.AIR)
		{
			Util.sendMessage(p, "&cMusisz trzymac przedmiot aby zmienic mu nazwe!");
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
		    if (mb.toString().equalsIgnoreCase(Main.getInstance().getConfig().getString("changeitem-remove"))){
		    	meta.setDisplayName(null);
		    }else{
		    	meta.setDisplayName(Util.setHEX(mb.toString()));
		    }
		    item.setItemMeta(meta);
		    Util.sendMessage(p, "&7Poprawnie zmieniono nazwe na: &c" + Util.setHEX(mb.toString().replace(Main.getInstance().getConfig().getString("changeitem-remove"), "&cwyczyszczono nazwe!")));
		}
	}

}
