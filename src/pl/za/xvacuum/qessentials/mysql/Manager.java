package pl.za.xvacuum.qessentials.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.objects.DataContainer;
import pl.za.xvacuum.qessentials.objects.QBan;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.LogUtil;

public class Manager {
	
	public static void loadPlayers() {
		if (pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			try {
				EncapsulatedQuery q = new EncapsulatedQuery("SELECT * FROM players");
				Connection c = ConnectionSource.getInstance().dataSource.getConnection();
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(q.getQuery());
			
				while(rs.next()) {
					QPlayer qp = new QPlayer(rs.getString(1));
					qp.setFly(rs.getInt(7) == 1 ? true : false);
					qp.setGod(rs.getInt(6) == 1 ? true : false);
					int hX = rs.getInt(2);
					int hY = rs.getInt(3);
					int hZ = rs.getInt(4);
					String hWorld = rs.getString(5);
					long mute = rs.getLong(8);
					qp.setHome(new Location(Bukkit.getWorld(hWorld), hX, hY, hZ));
					qp.setMute(mute);
					qp.setChanged(false);
					DataContainer.addQPlayer(qp);
				}
				LogUtil.info("Zaladowano " + DataContainer.getPlayers().size() + " graczy.");
				rs.close();
				st.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			for (File file : new File(Main.getInstance().getDataFolder(), "userdata").listFiles()) {
				
					YamlConfiguration fc = YamlConfiguration
							.loadConfiguration(file);
					QPlayer qp = new QPlayer(fc.getString("data.nick"));
					qp.setMute(fc.getLong("data.mute"));
					qp.setGod(fc.getBoolean("data.god"));
					qp.setFly(fc.getBoolean("data.fly"));
					qp.setHome(new Location(Bukkit.getWorld(fc
							.getString("data.hWorld")), fc.getInt("data.hX"),
							fc.getInt("data.hY"), fc.getInt("data.hZ")));
					qp.setChanged(false);
					DataContainer.addQPlayer(qp);
				
			}
			LogUtil.info("Zaladowano " + DataContainer.getPlayers().size() + " graczy.");
		}
	}
	
	public static void loadBans() {
		if (pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			try {
				EncapsulatedQuery q = new EncapsulatedQuery("SELECT * FROM `bans`");
				Connection c = ConnectionSource.getInstance().dataSource.getConnection();
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(q.getQuery());
				
				
				while(rs.next()) {
					QBan ban = new QBan(rs.getString(1), rs.getString(2));
					ban.setReason(rs.getString(3));
					ban.setBanTime(rs.getLong(4));
					ban.setValidateTill(rs.getLong(5));
					ban.setChanged(false);
					DataContainer.addBan(ban);
				}
				LogUtil.info("Zaladowano " + DataContainer.getBans().size() + " banow.");
				rs.close();
				st.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			for (File file : new File(Main.getInstance().getDataFolder(), "bandata").listFiles()) {
				YamlConfiguration fc = YamlConfiguration.loadConfiguration(file);
				String victim = fc.getName();
				String punisher = fc.getString("ban.punisher");
				QBan ban = new QBan(punisher, victim);
				ban.setReason(fc.getString("ban.reason"));
				ban.setValidateTill(fc.getLong("ban.deleteTime"));
				ban.setBanTime(fc.getLong("ban.banTime"));
				ban.setChanged(false);
				DataContainer.addBan(ban);
			}
			LogUtil.info("Zaladowano " + DataContainer.getBans().size() + " banow.");
		}
	}

	public static void createTables() {
		QueryStream.sendQuery(new EncapsulatedQuery("CREATE TABLE IF NOT EXISTS players (name VARCHAR(16), hX int, hY int, hZ int, hWorld VARCHAR(120), god int, fly int, mute bigint)"));
		QueryStream.sendQuery(new EncapsulatedQuery("CREATE TABLE IF NOT EXISTS bans (punisher VARCHAR(16), victim VARCHAR(16), reason VARCHAR(100), giveDate bigint, deleteDate bigint)"));
	}
	
	
	public static void saveAll() {
		for(QPlayer qp : DataContainer.getPlayers().values()) {
			qp.save();
		}
		for(QBan b : DataContainer.getBans()) {
			b.save();
		}
		
		
	}

}
