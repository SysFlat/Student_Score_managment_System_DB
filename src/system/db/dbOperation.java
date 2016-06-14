package system.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class dbOperation {
	private final static String user = "root";
	private final static String password = "2015216088";
	private final static String link = "jdbc:mysql://localhost/student";
	public final static String jdbcDriver = "com.mysql.jdbc.Driver";
	public static Connection conn = null;
	public static Statement stat = null;
	
	
	public static void createTable()
	{
		String newTable = "create table Student("+
						   "id varchar(10)," +
						   	"name varchar(10)," +
						    "sex varchar(5)," +
						   	"academy varchar(10)," + 
						    "score1 float," +
						   	"score2 float," +
						    "score3 float," +
						   	"averageScore float)";
		try {
			stat.execute(newTable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void dbConnection()
	{
		try 
		{
			Class.forName(jdbcDriver);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(link,user,password);
			stat = conn.createStatement();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public static void closeDb()
	{
		try {
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Statement getStatement()
	{
		return stat;
	}

}
