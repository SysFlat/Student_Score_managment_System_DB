package system.db;

import java.sql.ResultSet;
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
	public static ResultSet set = null;
	

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
			set.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
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
	
	public static Connection dbConn()
	{
		Connection connection = null;
		
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(link,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void dbClose(Connection conn,ResultSet set, Statement stat)
	{
		try
		{
			if(stat != null)
			{
					stat.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try
		{
			if(set != null)
			{
				set.close();
			}
		}catch (SQLException e2 )
		{
			e2.printStackTrace();
		}
		
		try 
		{
			if(conn != null)
			{
					conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getQueryCount(Statement stat,String sql,ResultSet set)
	{
		int num = 0;
		try {
			set = stat.executeQuery(sql);
			if(set.next())
			{
				num = set.getInt("count(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
