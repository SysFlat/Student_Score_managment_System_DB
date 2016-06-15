package system.operation;

import java.sql.SQLException;
import java.util.Scanner;

import system.db.dbOperation;
import system.file.FileOperation;
import system.object.Student;

public final class AddDelModify {
	
	public static void addStudent()
	{
		 String id;
		 String name;
		 String sex;
		 String academy;
		 String score1;
		 String score2;
		 String score3;
		 String averageScore;
		 String quit;
		Scanner add = new Scanner(System.in);
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
			
			try {
				dbOperation.getStatement().executeUpdate(
						String.format(dbOperation.insert, id,name,sex,academy,
						 							score1,score2,score3,
						 							//averageScore
						 							averageScore)
						);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			System.out.println("退出？（Y/N）");
			quit = add.nextLine();
			if(quit.equals("y") || quit.equals("Y")) 
				{
					System.out.println("退出当前页面.........\n\n\n");
					break;
				}
		};		
	}
	
	public static void delStudent()
	{
		String id;
		String quit;
		String match = "[0-9]+";
		Scanner input = new Scanner(System.in);
		System.out.println("删除学生： \n\n\n");
		while(true)
		{
			System.out.println("请输入待删除的学生学号：\n\n");
			
			while(true)
			{
				id = input.nextLine();
				if(id.matches(match)) break;
				else System.out.println("输入格式错误，请重新输入！");
			};
			
			try {
				dbOperation.getStatement().executeUpdate(String.format(dbOperation.delete,id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("退出？（Y/N）");
			
			quit = input.nextLine();
			
			if(quit.equals("Y") || quit.equals("y")) 
			{
				System.out.println("退出删除页面.........\n\n\n");
				break;
			}
		};
		
		
	}
	
	public static void modifyStudent()
	{
		System.out.println("修改学生信息：\n\n\n");
		String id;
		String name;
		String sex;
		String academy;
		String score1;
		String score2;
		String score3;
		String quiet;
		int modifyIndex = 0;
		Scanner modify = new Scanner(System.in);
		while(true)
		{
			System.out.println("请输入待修改学生的学号:\n\n");
			while(true)
			{
				id = modify.nextLine();
				for(int i = 0; i < FileOperation.getStudentNum(); i++)
				{
					if(id.equals(FileOperation.getStudent(i).getId()))
					{
						modifyIndex = i;
						break;
					}
				}
				
				if(id.equals(FileOperation.getStudent(modifyIndex).getId()))
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
			System.out.println("请输入科目一分数:\n\n");
			score2 = modify.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score3 = modify.nextLine();
			
			FileOperation.studentArray.get(modifyIndex).setStudentInfo(
					id,
					name,
					sex,
					academy,
					Float.parseFloat(score1),
					Float.parseFloat(score2),
					Float.parseFloat(score3)					
					);
			FileOperation.isModify = true;
			
			System.out.println("退出？（Y/N）");
			quiet = modify.nextLine();
			if(quiet.equals("y") || quiet.equals("Y")) break;
		};
	}
}
