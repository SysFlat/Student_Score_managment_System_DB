package system.operation;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import system.db.dbOperation;
import system.file.FileOperation;
import system.object.Student;

public final class QueryFunction {
	 Connection conn = null;
	 Statement stat = null;
	 ResultSet set = null;
	 String matchEnd = "-1";
	 int num = 0;
	/*
	 * �����������в�ѯ
	 */
	public  void queryByName()
	{

		String name;
		Scanner input = new Scanner(System.in);
		String matchString = "[a-z]*";
		String queryByName = "select * from student  where name = '%s'";
		String queryCount = "select count(*) from student  where name = '%s'";
				
		
		try {
				//database connection
				conn = dbOperation.dbConn();
				stat = (Statement) conn.createStatement();
			
				while(true)
				{
					while(true)
					{
						System.out.println("\n\n������ѧ���������в�ѯ��(����-1�˳�) ");
						name = input.nextLine();
						
						 if(name.matches(matchString))
						 {
							 num = dbOperation.getQueryCount(stat, String.format(queryCount,name),set);
							 set = stat.executeQuery(String.format(queryByName, name));
							 break;
						 }
						 else
						 {
							 if(name.matches(matchEnd)) break;
							 System.out.println("�����ʽ�������������룺\n");
						 }
					}
					
					if(name.equals("-1"))
					{
						System.out.println("�˳���ģ��..............\n");
						break;
					}
		
					if(num != 0)
					{
						showStudentInfo(num,set);
					}
					else
					{
						System.out.println("û���ҵ���ؼ�¼��\n\n\n");
					}
					
				}
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			finally
			{
				dbOperation.dbClose(conn, set, stat);
			}
	}

	/*
	 * ����ѧ�Ž��в�ѯ
	 */
	public  void queryById()
	{
		int count;
		String id;
		String queryDbById = "select * from student  where id = '%s'";
		String queryCount = "select count(*) from student  where id = '%s'";
		Scanner input = new Scanner(System.in);
		String matchNum = "-?[0-9]+";
		try
		{
			conn = dbOperation.dbConn();
			stat = (Statement) conn.createStatement();
			
			while(true)
			{			
				while(true)
				{
					System.out.println("\n\n������ѧ�Ž��в�ѯ��(����-1�˳�) ");
					id = input.nextLine();
					
					if(id.matches(matchNum))
					{
						num = dbOperation.getQueryCount(stat, String.format(queryCount,id),set);
						set = stat.executeQuery(String.format(queryDbById,id));
						break;				
					}
					else 
					{
						System.out.println("�����ʽ�������������룺\n");
					}
				}
				if(id.equals("-1"))
				{
					System.out.println("�˳���ģ��.........\n");
					break;
				}

				if(num != 0)
				{
					showStudentInfo(num, set);
				}
				else
				{
					System.out.println("û���ҵ���ؼ�¼��\n\n\n");
				}
	
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}
	}
	/*
	 * ����ѧԺ���в�ѯ
	 */
	public  void  queryByAcademy()
	{
		int count;
		String queryAcademy;
		String queryDbByAcademy = "select * from student  where academy = '%s'";
		String queryCount = "select count(*) from student  where academy = '%s'";
		String matchString = "[A-G]";
		Scanner input = new Scanner(System.in);
		try
		{
			//database connection
			conn = dbOperation.dbConn();
			stat = (Statement) conn.createStatement();

			while(true)
			{
				while(true)
				{
					System.out.println("\n\n�ֱ��� A-G 7��ѧԺ��������ѧԺ���ƽ��в�ѯ��(����-1�˳�)");
					queryAcademy = input.next();
					if(queryAcademy.matches(matchString)) 
					{
						num = dbOperation.getQueryCount(stat, String.format(queryCount, queryAcademy), set);
						set = stat.executeQuery(String.format(queryDbByAcademy, queryAcademy));
						break;
					}
					else 
					{
						if(queryAcademy.matches(matchEnd)) break;
						System.out.println("û�и�ѧԺ�����������룡");
					}
				};
				
				if(queryAcademy.equals("-1"))
				{
					System.out.println("�˳���ģ��..........\n");
					break;
				}
				
				if(num != 0)
				{
					showStudentInfo(num, set);
				}
				else
				{
					System.out.println("û���ҵ���ؼ�¼��\n\n\n");
				}			
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}
		
	}
	
	public  void showStudentInfo(int num,ResultSet set)
	{
		StringBuffer buffer = new StringBuffer();
		System.out.println("\n\n�ҵ� "+ num +" ����ؼ�¼�����£�");
		System.out.println("\t**************************************************************");
		System.out.println("\tѧ��\t����\t�Ա�\tѧԺ\t��Ŀһ\t��Ŀ��\t��Ŀ��\tƽ����");
			try {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}

		System.out.println(buffer.toString());
		System.out.println("\n\n\n");
		buffer.setLength(0);
	}


}
