package pl.za.xvacuum.qessentials.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;

import pl.za.xvacuum.qessentials.Main;

public class QueryStream {

	/**
	 * Kod jest wielow¹tkowy. Pobiera po³¹czenie z poola ConnectionSource
	 * A nastepnie egzekwuje zahermetyzowane zapytanie uzywajac najmniej uzywanego watku z Thread Poola od Taskow.
	 * @author NTSW
	 */
	
	public static void sendQuery(final EncapsulatedQuery q) {
		Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),
				new Runnable() {
					public void run() {
						try {
							Connection c = ConnectionSource.getInstance().dataSource.getConnection();
							Statement s = c.createStatement();
							s.executeUpdate(q.getQuery());
							s.close();
							c.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				});

	}
	
	
	
}
