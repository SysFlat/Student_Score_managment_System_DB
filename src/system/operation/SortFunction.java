package system.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

import system.db.dbOperation;
import system.file.FileOperation;
import system.object.Student;



public final class SortFunction {
	public Connection conn = null;
	public Statement stat = null;
	ResultSet set = null;
	/*
	 * 按照平均成绩降序排列
	 */
	public  void descendByAverage()
	{
		String orderSql = "select * from student order by averageScore desc";

		System.out.println("\n\n按照平均成绩降序排列为：\n\n");		
		
		try {
			conn = (Connection) dbOperation.dbConn();
			stat = conn.createStatement();
			set = stat.executeQuery(orderSql);
			showStudentInfo(set);
			System.out.println("\n\n按下回车键退出..........\n\n");
			new Scanner(System.in).nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}
	}
	
	/*
	 * 按照姓名升序排列
	 */
	public  void ascendByName()
	{

		String orderNameSql = "select * from student order by name asc";
		System.out.println("\n\n按照姓名升序排列为: \n");
		
		try {
			conn = (Connection) dbOperation.dbConn();
			stat = conn.createStatement();
			set = stat.executeQuery(orderNameSql);
			showStudentInfo(set);
			System.out.println("\n\n按下回车键退出..........\n\n");
			new Scanner(System.in).nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}

	}
	
	public void showStudentInfo(ResultSet set)
	{
		StringBuffer buffer = new StringBuffer();
		try {
			System.out.println("\t**************************************************************");
			System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
		
			while(set.next())
			{
				buffer.append("\t");
				buffer.append(set.getString("id") + "\t");
				buffer.append(set.getString("name") + "\t");
				buffer.append(set.getString("sex") + "\t");
				buffer.append(set.getString("academy") + "\t");
				buffer.append(set.getFloat("score1") + "\t");
				buffer.append(set.getFloat("score2") + "\t");
				buffer.append(set.getFloat("score3") + "\t");
				buffer.append(set.getFloat("averageScore") + "\n");
			}
			System.out.println(buffer.toString());
			System.out.println("\n\n\n");
			buffer.setLength(0);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
