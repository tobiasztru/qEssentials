package pl.za.xvacuum.qessentials.utils;

import org.apache.commons.lang.StringUtils;
import org.bukkit.GameMode;

public class GmUtil {

	private static GameMode getGameMode(int tryb) {
		switch(tryb) {
		case 1: return GameMode.CREATIVE;
		case 2: return GameMode.ADVENTURE;
		case 0: return GameMode.SURVIVAL;
		default: return null;
		}
	}
	
	private static GameMode getGameMode(String name) {
		switch(name) {
		case "c": return GameMode.CREATIVE;
		case "creative": return GameMode.CREATIVE;
		case "surv": return GameMode.SURVIVAL;
		case "s": return GameMode.SURVIVAL;
		case "survival": return GameMode.SURVIVAL;
		case "adv": return GameMode.ADVENTURE;
		case "adventure": return GameMode.ADVENTURE;
		case "a": return GameMode.ADVENTURE;
		default: return null;
		}
	}
	
	public static GameMode parseGameName(String name) {
		if(StringUtils.isNumeric(name)) {
			return getGameMode(Integer.parseInt(name));
		} else {
			return getGameMode(name);
		}
	}
}
