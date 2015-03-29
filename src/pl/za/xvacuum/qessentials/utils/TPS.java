package pl.za.xvacuum.qessentials.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;

import org.bukkit.Bukkit;

import pl.za.xvacuum.qessentials.Main;

public class TPS implements Runnable {
	 /**
	  * Klasa zapo¿yczona od eastWestFM aka. Karolek, nie krzycz xD
	  */
	  private static DecimalFormat df = new DecimalFormat("#,###.##");
	  private transient long lastPoll = System.nanoTime();
	  private final LinkedList<Double> history = new LinkedList<Double>();
	  private static String result = "20.0";

	  public TPS() {
	    this.history.add(Double.valueOf(20.0D));
	  }

	  public void start() {
	    Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this, 1000L, 50L);
	  }

	  public void run()
	  {
		long startTime = System.nanoTime();
	    long timeSpent = (startTime - this.lastPoll) / 1000L;
	    if (timeSpent == 0L) timeSpent = 1L;
	    if (this.history.size() > 10) this.history.remove();
	    double tps = 50000000.0D / timeSpent;
	    if (tps <= 21.0D) this.history.add(Double.valueOf(tps));
	    this.lastPoll = startTime;
	    double avg = 0.0D;
	    for (Double f : this.history) if (f != null) avg += f.doubleValue();
	    df.setRoundingMode(RoundingMode.HALF_UP);
	    result = df.format(avg / this.history.size());
	  }

	  public static String getTPS() {
	      return result;
	  }

}
