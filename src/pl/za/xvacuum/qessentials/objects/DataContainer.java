package pl.za.xvacuum.qessentials.objects;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DataContainer {

	private static List<QBan> bans = Lists.newArrayList();
	private static Map<String, QPlayer> players = Maps.newHashMap();
	
	
	public static void addBan(QBan b) {
		bans.add(b);
	}
	
	public static QBan getBan(String victim) {
		for(QBan qb : bans) {
			if(qb.getVictim().equalsIgnoreCase(victim)) {
				return qb;
			}
		}
		return null;
	}
	
	public static boolean containsBan(QBan b) {
		return bans.contains(b);
	}
	
	public static void removeBan(QBan b) {
		bans.remove(b);
	}
	
	public static List<QBan> getBans() {
		return bans;
	}
	
	public static QPlayer getQPlayer(String name) {
		return players.get(name);
	}
	
	public static void addQPlayer(QPlayer q) {
		players.put(q.getName(), q);
	}
	
	public static Map<String, QPlayer> getPlayers() {
		return players;
	}
	
	
	
	
	
}
