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
	 * ����ƽ���ɼ���������
	 */
	public  void descendByAverage()
	{
		String orderSql = "select * from student order by averageScore desc";

		System.out.println("\n\n����ƽ���ɼ���������Ϊ��\n\n");		
		
		try {
			conn = (Connection) dbOperation.dbConn();
			stat = conn.createStatement();
			set = stat.executeQuery(orderSql);
			showStudentInfo(set);
			System.out.println("\n\n���»س����˳�..........\n\n");
			new Scanner(System.in).nextLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}
	}
	
	/*
	 * ����������������
	 */
	public  void ascendByName()
	{

		String orderNameSql = "select * from student order by name asc";
		System.out.println("\n\n����������������Ϊ: \n");
		
		try {
			conn = (Connection) dbOperation.dbConn();
			stat = conn.createStatement();
			set = stat.executeQuery(orderNameSql);
			showStudentInfo(set);
			System.out.println("\n\n���»س����˳�..........\n\n");
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
			System.out.println("\tѧ��\t����\t�Ա�\tѧԺ\t��Ŀһ\t��Ŀ��\t��Ŀ��\tƽ����");
		
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
