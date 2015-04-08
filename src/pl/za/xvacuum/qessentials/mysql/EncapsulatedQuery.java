package pl.za.xvacuum.qessentials.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EncapsulatedQuery {

	private String syntax;
	
	public EncapsulatedQuery(String syntax) {
		this.syntax = syntax;
	}
	
	public String getQuery() {
		return syntax;
	}
	
	public void sendNow() {
		try {
			Connection c = ConnectionSource.getInstance().dataSource.getConnection();
			Statement s = c.createStatement();
			s.executeUpdate(this.getQuery());
			s.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
}
