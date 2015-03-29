package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.za.xvacuum.qessentials.utils.TPS;
import pl.za.xvacuum.qessentials.utils.Util;
import pl.za.xvacuum.qessentials.utils.newCommand;

public class Gc extends newCommand{

	public Gc() {
		super("gc", "Garbage collector", "/gc", "gc", Arrays.asList(new String[] { "qgc", "qsystem", "tps", "qtps", "qgarbagecollector", "garbagecollector" }));
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		Util.sendMessage(p, "&7Informacje na temat &cserwera&7:");
		Util.sendMessage(p, "&7  TPS: &c" + TPS.getTPS());
		Util.sendMessage(p, "&7  Ilosc pamieci: &c" + Runtime.getRuntime().maxMemory() / 1024L / 1024L + " MB");
		Util.sendMessage(p, "&7  Lokowana pamiec: &c" + Runtime.getRuntime().totalMemory() / 1024L / 1024L + " MB");
		Util.sendMessage(p, "&7  Wolna pamiec: &c" + Runtime.getRuntime().freeMemory() / 1024L / 1024L + " MB");
		Util.sendMessage(p, "&7  Swiaty:");
		List<World> worlds = Bukkit.getWorlds();
		for (World w : worlds) {
			@SuppressWarnings("unused")
			int tile = 0;
		      for (Chunk chunk : w.getLoadedChunks()) {
		         tile += chunk.getTileEntities().length;
		      }
		      Util.sendMessage(p, " &7    '" + w.getName() + "' -> &c" + w.getLoadedChunks().length + " chunkow, " + w.getEntities().size() + " obiektow.");
		}
	}

}
