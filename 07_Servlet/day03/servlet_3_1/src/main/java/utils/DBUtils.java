
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource ds;
	static {
	
				Properties p = new Properties();
		
				InputStream ips = DBUtils.class.getClassLoader()
						.getResourceAsStream("jdbc.properties");
				
				try {
					p.load(ips);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				String driver = p.getProperty("driver");
				String url = p.getProperty("url");
				String username = p.getProperty("username");
				String password = p.getProperty("password");

				ds = new BasicDataSource();
				
				ds.setDriverClassName(driver);
				ds.setUrl(url);
				ds.setUsername(username);
				ds.setPassword(password);
				
				ds.setInitialSize(3);

				ds.setMaxActive(5);
	}
	
	public static Connection getConn() throws Exception {
		Connection conn = ds.getConnection();
		System.out.println(conn);
		return conn;
	}
}
