import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBtrial {

	String dbStatement = null;
	String host = "jdbc:hsqldb:hsql://foood.servehttp.com/xdb:9001/xdb";
	String dbUserName = "SA";
	String dbUserPass = "22google";
	String sqlString = null;
	
	Person p = new Person();
	
	public Person dbConnection(String string) throws SQLException {
		
		Connection con = DriverManager.getConnection(host,  dbUserName,  dbUserPass);
		
		this.sqlString = string;
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);
		
		rs.next();
		
		p.setName(rs.getString("USERNAME"));
		p.setEmail(rs.getString("EMAIL"));
		p.setPassword("PASSWORD");
		
		return p;
	}
}
