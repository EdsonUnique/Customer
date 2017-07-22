package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.DefaultButtonModel;



public class JdbcUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		
		try{
			Properties pros=new Properties();
			pros.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			
			driver=pros.getProperty("driver");
			url=pros.getProperty("url");
			username=pros.getProperty("username");
			password=pros.getProperty("password");
			
			Class.forName(driver);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static Connection getCon(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(Connection con, Statement st, ResultSet rs){
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

















