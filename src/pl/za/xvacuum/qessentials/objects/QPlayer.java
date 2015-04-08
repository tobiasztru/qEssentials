package pl.za.xvacuum.qessentials.objects;

import java.io.File;
import java.io.IOException;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.flatfile.Flat;
import pl.za.xvacuum.qessentials.mysql.Data;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;


public class QPlayer implements Data{

	
	private String name;
	private long mute = 0;
	private Location home;
	private boolean god;
	private boolean fly;
	private Location location;
	private GameMode gm;
	private boolean changed;
	
	
	public QPlayer(String name) {
		this.name = name;
	}

	
	@Override
	public boolean wasChanged() {
		return changed;
	}

	@Override
	public void setChanged(boolean changed) {
		this.changed = changed;
	}


	public String getName() {
		return name;
	}


	public long getMute() {
		return mute;
	}


	public void setMute(long mute) {
		this.mute = mute;
	}


	public Location getHome() {
		return home;
	}


	public void setHome(Location home) {
		this.home = home;
	}


	public boolean isFly() {
		return fly;
	}


	public void setFly(boolean fly) {
		this.fly = fly;
	}


	public boolean isGod() {
		return god;
	}


	public void setGod(boolean god) {
		this.god = god;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public GameMode getGm() {
		return gm;
	}


	public void setGm(GameMode gm) {
		this.gm = gm;
	}


	@Override
	public void save() {
		if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			new EncapsulatedQuery(String.format("UPDATE players SET `mute`='%d' WHERE `name`='%s'", mute, name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `fly`='%d' WHERE `name`='%s'", fly == true ? 1 : 0, name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `hWorld`='%s' WHERE `name`='%s'", home.getWorld().getName(), name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `hX`='%d' WHERE `name`='%s'", home.getBlockX(), name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `hZ`='%d' WHERE `name`='%s'", home.getBlockZ(), name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `hY`='%d' WHERE `name`='%s'", home.getBlockY(), name)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE players SET `god`='%d' WHERE `name`='%s'", god == true ? 1 : 0, name)).sendNow();
		} else {
			YamlConfiguration c = Flat.getData(name);
			c.set("data.mute", mute);
			c.set("data.god", god);
			c.set("data.hX", home.getBlockX());
			c.set("data.hY", home.getBlockY());
			c.set("data.hZ", home.getBlockZ());
			c.set("data.fly", fly);
			c.set("data.hWorld", home.getWorld().getName());
			c.set("data.nick", name);
			
			try {
				File folder = new File(Main.getInstance().getDataFolder(), "userdata");
				c.save(new File(folder, name + ".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
