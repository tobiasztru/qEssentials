package pl.za.xvacuum.qessentials.objects;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.flatfile.Flat;
import pl.za.xvacuum.qessentials.mysql.Data;
import pl.za.xvacuum.qessentials.mysql.EncapsulatedQuery;

public class QBan implements Data{

	private boolean changed;
	private String punisher;
	private String victim;
	private String reason;
	private long banTime;
	private long validateTill;

	public QBan(String punisher, String victim) {
		this.punisher = punisher;
		this.victim = victim;
	}
	
	@Override
	public boolean wasChanged() {
		return changed;
	}

	@Override
	public void setChanged(boolean changed) {
		this.changed = changed;
		
	}

	@Override
	public void save() {
		if (!wasChanged()) {
			return;
		}
		if (pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			new EncapsulatedQuery(String.format("UPDATE bans SET `punisher`='%s' WHERE `victim`='%s'",punisher, victim)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE bans SET `reason`='%s' WHERE `victim`='%s'",reason, victim)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE bans SET `giveDate`='%d' WHERE `victim`='%s'",banTime, victim)).sendNow();
			new EncapsulatedQuery(String.format("UPDATE bans SET `deleteDate`='%d' WHERE `victim`='%s'",validateTill, victim)).sendNow();
		} else {
			YamlConfiguration c = Flat.createBanData(this);
			c.set("ban.punisher", punisher);
			c.set("ban.giveDate", banTime);
			c.set("ban.victim", victim);
			c.set("ban.deleteDate", validateTill);
			c.set("ban.reason", reason);
			
			try {
				
				c.save(new File(Main.getInstance().getDataFolder(), "/bandata/" + victim + ".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	public String getPunisher() {
		return punisher;
	}

	public String getVictim() {
		return victim;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
		setChanged(true);
	}

	public long getBanTime() {
		return banTime;
	}

	public void setBanTime(long banTime) {
		this.banTime = banTime;
		setChanged(true);
	}

	public long getValidateTill() {
		return validateTill;
	}

	public void setValidateTill(long validateTill) {
		this.validateTill = validateTill;
		setChanged(true);
	}

	
}
