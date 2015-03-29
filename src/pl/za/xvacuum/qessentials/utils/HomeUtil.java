package pl.za.xvacuum.qessentials.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class HomeUtil {
	
	  private String name;

	  public HomeUtil(String name)
	  {
	    this.name = name;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public Player getPlayer()
	  {
	    return Bukkit.getPlayer(this.name);
	  }

	  public boolean hasHome()
	  {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (file.exists()) {
	      return true;
	    }

	    return false;
	  }

	  public World getHomeWorld() {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return Bukkit.getWorld(config.getString("location.w"));
	  }

	  public double getHomeX() {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return config.getDouble("location.x");
	  }

	  public double getHomeY()
	  {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return config.getDouble("location.y");
	  }

	  public double getHomeZ()
	  {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return config.getDouble("location.z");
	  }

	  public float getHomePitch()
	  {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return (float)config.getDouble("location.pitch");
	  }

	  public float getHomeYaw() {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      throw new NullPointerException("Gracz " + this.name + " nie posiada domu!");
	    }
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    return (float)config.getDouble("location.pitch");
	  }

	  public Location getHomeLocation() {
	    World w = getHomeWorld();
	    double x = getHomeX();
	    double y = getHomeY();
	    double z = getHomeZ();
	    float pitch = getHomePitch();
	    float yaw = getHomeYaw();

	    Location loc = new Location(w, x, y, z);
	    loc.setPitch(pitch);
	    loc.setYaw(yaw);

	    return loc;
	  }

	  public void setHome(Location loc) {
	    File file = new File("plugins/qEssentials/homes/" + this.name + ".yml");

	    if (!file.exists()) {
	      try {
	        file.createNewFile();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }

	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	    config.set("location.w", loc.getWorld().getName());
	    config.set("location.x", Double.valueOf(loc.getX()));
	    config.set("location.y", Double.valueOf(loc.getY()));
	    config.set("location.z", Double.valueOf(loc.getZ()));
	    config.set("location.pitch", Float.valueOf(loc.getPitch()));
	    config.set("location.yaw", Float.valueOf(loc.getYaw()));
	    try
	    {
	      config.save(file);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

}
