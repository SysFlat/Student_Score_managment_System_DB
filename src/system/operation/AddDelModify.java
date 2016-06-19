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
				System.out.println("添加学生:\n\n\n请输入学生信息:\n\n");
				System.out.println("请输入学号:\n\n");
				id = add.nextLine();
				System.out.println("请输入姓名:\n\n");
				name = add.nextLine();
				System.out.println("请输入性别:\n\n");
				sex = add.nextLine();
				System.out.println("请输入学院:\n\n");
				academy = add.nextLine();
				System.out.println("请输入科目一分数:\n\n");
				score1 = add.nextLine();
				System.out.println("请输入科目二分数:\n\n");
				score2 = add.nextLine();
				System.out.println("请输入科目三分数:\n\n");
				score3 = add.nextLine();
				
				averageScore = String.format("%.2f",(Float.parseFloat(score1) + Float.parseFloat(score2) + Float.parseFloat(score3)) / 3.0) ;
				
					stat.executeUpdate(
							String.format(insert, id,name,sex,academy,
						 							score1,score2,score3,
						 							//averageScore
						 							averageScore)
							);
	
				
				System.out.println("退出？（Y/N）");
				quit = add.nextLine();
				if(quit.equals("y") || quit.equals("Y")) 
					{
						System.out.println("退出当前页面.........\n\n\n");
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
		System.out.println("删除学生： \n\n\n");
		try
		{
			
			conn = dbOperation.dbConn();
			stat = conn.createStatement();
			while(true)
			{
				System.out.println("请输入待删除的学生学号：\n\n");
				
				while(true)
				{
					id = input.nextLine();
					if(id.matches(match)) break;
					else System.out.println("输入格式错误，请重新输入！");
				};
				
				stat.executeUpdate(String.format(delete,id));
				System.out.println("退出？（Y/N）");
				
				quit = input.nextLine();
				
				if(quit.equals("Y") || quit.equals("y")) 
				{
					System.out.println("退出删除页面.........\n\n\n");
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
		System.out.println("修改学生信息：\n\n\n");
		Scanner modify = new Scanner(System.in);
		
		try
		{
			conn = dbOperation.dbConn();
			stat = conn.createStatement();
			
			while(true)
			{
				System.out.println("请输入待修改学生的学号:\n\n");
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
						System.out.println("没有该学生的信息，请重新输入！\n\n");
					}
				}
				
				System.out.println("请输入姓名:\n\n");
				name = modify.nextLine();
				System.out.println("请输入性别:\n\n");
				sex = modify.nextLine();
				System.out.println("请输入学院:\n\n");
				academy = modify.nextLine();
				System.out.println("请输入科目一分数:\n\n");
				score1 = modify.nextLine();
				System.out.println("请输入科目二分数:\n\n");
				score2 = modify.nextLine();
				System.out.println("请输入科目三分数:\n\n");
				score3 = modify.nextLine();
				
				averageScore = String.format("%.2f",(Float.parseFloat(score1) + Float.parseFloat(score2) + Float.parseFloat(score3)) / 3.0) ;
					stat.executeUpdate(String.format(delete, id));
					stat.executeUpdate(
							String.format(insert, id,name,sex,academy,
							 							score1,score2,score3,
							 							//averageScore
							 							averageScore)
							);

				System.out.println("退出？（Y/N）");
				quit = modify.nextLine();
				if(quit.equals("y") || quit.equals("Y")) 
				{
					System.out.println("退出修改页面.........\n\n\n");
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
