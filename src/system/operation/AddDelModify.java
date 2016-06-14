package system.operation;

import java.util.Scanner;

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
		String quiet;
		Scanner add = new Scanner(System.in);
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
			System.out.println("�������Ŀһ����:\n\n");
			score2 = add.nextLine();
			System.out.println("�������Ŀһ����:\n\n");
			score3 = add.nextLine();
			
			FileOperation.studentArray.add(new Student(
					id,
					name,
					sex,
					academy,
					Float.parseFloat(score1),
					Float.parseFloat(score2),
					Float.parseFloat(score3)					
					));
			FileOperation.isModify = true;
			
			System.out.println("�˳�����Y/N��");
			quiet = add.nextLine();
			if(quiet.equals("y") || quiet.equals("Y")) break;
		};		
	}
	
	public static void delStudent()
	{
		String id;
		String match = "[0-9]+";
		Scanner input = new Scanner(System.in);
		System.out.println("ɾ��ѧ���� \n\n\n");
		while(true)
		{
			System.out.println("�������ɾ����ѧ��ѧ�ţ�\n\n");
			
			while(true)
			{
				id = input.nextLine();
				if(id.matches(match)) break;
				else System.out.println("�����ʽ�������������룡");
			};
			
			for(int i = 0; i < FileOperation.getStudentNum(); i++)
			{
				if(id.equals(FileOperation.getStudent(i).getId()))
				{
					FileOperation.studentArray.remove(i);
					FileOperation.isModify = true;
				}
			}
			
			if (!FileOperation.isModify)
				System.out.println("û�������Ϣ��");
			System.out.println("�˳�����Y/N��");
			
			id = input.nextLine();
			
			if(id.equals("Y") || id.equals("y")) 
			{
				System.out.println("�˳�ɾ��ҳ��.........\n\n\n");
				//input.close();
				break;
			}
		};
		
		
	}
	
	public static void modifyStudent()
	{
		System.out.println("�޸�ѧ����Ϣ��\n\n\n");
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
			System.out.println("��������޸�ѧ����ѧ��:\n\n");
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
			System.out.println("�������Ŀһ����:\n\n");
			score2 = modify.nextLine();
			System.out.println("�������Ŀһ����:\n\n");
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
			
			System.out.println("�˳�����Y/N��");
			quiet = modify.nextLine();
			if(quiet.equals("y") || quiet.equals("Y")) break;
		};
	}
}
