package system.operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import system.db.dbOperation;
import system.file.FileOperation;
import system.object.Student;

public final class AddDelModify {
	 public  String id;
	 public  String name;
	 public  String sex;
	 public  String academy;
	 public  String score1;
	 public  String score2;
	 public  String score3;
	 public  String averageScore;
	 public  String quit;
	 
	 public Connection conn = null;
	 public Statement stat = null;
	 public ResultSet set = null;
	 String queryId = "select * from student where id = '%s'";
	 String insert = "insert into student values('%s','%s','%s','%s',%s,%s,%s,%s)";
	 String delete = "delete from student where id = '%s'";
	public  void addStudent()
	{
		
		Scanner add = new Scanner(System.in);
		try
		{
			conn = dbOperation.dbConn();
			stat = conn.createStatement();
		
			while(true)
			{
				System.out.println("���ѧ��:\n\n\n������ѧ����Ϣ:\n\n");
				System.out.println("������ѧ��:\n\n");
				id = add.nextLine();
				System.out.println("����������:\n\n");
				name = add.nextLine();
				System.out.println("�������Ա�:\n\n");
				sex = add.nextLine();
				System.out.println("������ѧԺ:\n\n");
				academy = add.nextLine();
				System.out.println("�������Ŀһ����:\n\n");
				score1 = add.nextLine();
				System.out.println("�������Ŀ������:\n\n");
				score2 = add.nextLine();
				System.out.println("�������Ŀ������:\n\n");
				score3 = add.nextLine();
				
				averageScore = String.format("%.2f",(Float.parseFloat(score1) + Float.parseFloat(score2) + Float.parseFloat(score3)) / 3.0) ;
				
					stat.executeUpdate(
							String.format(insert, id,name,sex,academy,
						 							score1,score2,score3,
						 							//averageScore
						 							averageScore)
							);
	
				
				System.out.println("�˳�����Y/N��");
				quit = add.nextLine();
				if(quit.equals("y") || quit.equals("Y")) 
					{
						System.out.println("�˳���ǰҳ��.........\n\n\n");
						break;
					}
			};	
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, null, stat);
		}
	}
	
	public  void delStudent()
	{
		
		String match = "[0-9]+";
		Scanner input = new Scanner(System.in);
		System.out.println("ɾ��ѧ���� \n\n\n");
		try
		{
			
			conn = dbOperation.dbConn();
			stat = conn.createStatement();
			while(true)
			{
				System.out.println("�������ɾ����ѧ��ѧ�ţ�\n\n");
				
				while(true)
				{
					id = input.nextLine();
					if(id.matches(match)) break;
					else System.out.println("�����ʽ�������������룡");
				};
				
				stat.executeUpdate(String.format(delete,id));
				System.out.println("�˳�����Y/N��");
				
				quit = input.nextLine();
				
				if(quit.equals("Y") || quit.equals("y")) 
				{
					System.out.println("�˳�ɾ��ҳ��.........\n\n\n");
					break;
				}
			};
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, null, stat);
		}
		
	}
	
	public  void modifyStudent()
	{
		System.out.println("�޸�ѧ����Ϣ��\n\n\n");
		Scanner modify = new Scanner(System.in);
		
		try
		{
			conn = dbOperation.dbConn();
			stat = conn.createStatement();
			
			while(true)
			{
				System.out.println("��������޸�ѧ����ѧ��:\n\n");
				while(true)
				{
					id = modify.nextLine();
					set = stat.executeQuery(String.format(queryId, id));
	
					if(set.next() != false)
					{
						break;
					}					
					else
					{
						System.out.println("û�и�ѧ������Ϣ�����������룡\n\n");
					}
				}
				
				System.out.println("����������:\n\n");
				name = modify.nextLine();
				System.out.println("�������Ա�:\n\n");
				sex = modify.nextLine();
				System.out.println("������ѧԺ:\n\n");
				academy = modify.nextLine();
				System.out.println("�������Ŀһ����:\n\n");
				score1 = modify.nextLine();
				System.out.println("�������Ŀ������:\n\n");
				score2 = modify.nextLine();
				System.out.println("�������Ŀ������:\n\n");
				score3 = modify.nextLine();
				
				averageScore = String.format("%.2f",(Float.parseFloat(score1) + Float.parseFloat(score2) + Float.parseFloat(score3)) / 3.0) ;
					stat.executeUpdate(String.format(delete, id));
					stat.executeUpdate(
							String.format(insert, id,name,sex,academy,
							 							score1,score2,score3,
							 							//averageScore
							 							averageScore)
							);

				System.out.println("�˳�����Y/N��");
				quit = modify.nextLine();
				if(quit.equals("y") || quit.equals("Y")) 
				{
					System.out.println("�˳��޸�ҳ��.........\n\n\n");
					break;
				}
			};
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}
	}
}
