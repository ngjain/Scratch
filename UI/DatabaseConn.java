package UI;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConn {

	private String connUrl;
	private String username;
	private String password;
	public DatabaseConn(Properties property) {
		connUrl = property.getProperty("jdbcUrl");
		username   = property.getProperty("jdbcUser");
		password = property.getProperty("jdbcPasswd");
		property.getProperty("jdbcDriver");
	}
	public DatabaseConn(String url, String usrname, String pwd) {
		this.connUrl = url;
		this.username = usrname;
		this.password = pwd;
	}
	@SuppressWarnings("finally")
	public  Connection getMySqlConnection() {

		/* Declare and initialize a sql Connection variable. */
		Connection ret = null;	
		try
		{
			/* Register for jdbc driver class. */
			Class.forName("com.mysql.jdbc.Driver");
			ret = DriverManager.getConnection(connUrl, username , password);
			
			DatabaseMetaData dbmd = ret.getMetaData();
			
			String dbName = dbmd.getDatabaseProductName();
			
			String dbVersion = dbmd.getDatabaseProductVersion();
			
			String dbUrl = dbmd.getURL();
			
			String userName = dbmd.getUserName();
			
			String driverName = dbmd.getDriverName();
			
			System.out.println("Database Name is " + dbName);
			
			System.out.println("Database Version is " + dbVersion);
			
			System.out.println("Database Connection Url is " + dbUrl);
			
			System.out.println("Database User Name is " + userName);
			
			System.out.println("Database Driver Name is " + driverName);
						
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			return ret;
		}

	}
}
