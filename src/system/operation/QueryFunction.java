package system.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import system.file.FileOperation;
import system.object.Student;

public final class QueryFunction {
	public static int num = FileOperation.getStudentNum();
	private static String matchEnd = "-1";
	/*
	 * �����������в�ѯ
	 */
	public static void queryByName()
	{
		int count;
		String queryName;
		ArrayList<Integer> nameNum = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		String matchString = "[a-z]*";
		while(true)
		{
			while(true)
			{
				System.out.println("\n\n������ѧ���������в�ѯ��(����-1�˳�) ");
				queryName = input.nextLine();
				
				if(queryName.matches(matchString)) break;
				else
				{
					if(queryName.matches(matchEnd)) break;
				}

			};
			
			if(queryName.equals("-1"))
			{
				System.out.println("�˳���ģ��..............\n");
				break;
			}
			
			for (count = 0; count < num; count++) 
			{
				if(queryName.equals(FileOperation.getStudent(count).getName()))
				{
					nameNum.add(new Integer(count));
				}
			}

			if(nameNum.size() != 0)
			{
				System.out.println("\n\n�ҵ�"+ nameNum.size() +"����ؼ�¼�����£�");
				System.out.println("\t**************************************************************");
				System.out.println("\tѧ��\t����\t�Ա�\tѧԺ\t��Ŀһ\t��Ŀ��\t��Ŀ��\tƽ����");
				for(int i = 0; i < nameNum.size(); i++)
				{
					showOneStudentInfo(FileOperation.getStudent(nameNum.get(i).intValue()));
				}

				System.out.println("\n\n\n");
				nameNum.clear();
			}
			else
			{
				System.out.println("û���ҵ���ؼ�¼��\n\n\n");
			}

		}
	}
	
	/*
	 * ����ѧ�Ž��в�ѯ
	 */
	public static void queryById()
	{
		int count;
		String queryId;
		Scanner input = new Scanner(System.in);
		String matchNum = "-?[0-9]+";
		
		while(true)
		{			
			while(true)
			{
				System.out.println("\n\n������ѧ�Ž��в�ѯ��(����-1�˳�) ");
				queryId = input.nextLine();
				
				if(queryId.matches(matchNum))
				{
					break;				
				}
				else 
				{
					System.out.println("�����ʽ�������������룺\n");
				}
			}
			if(queryId.equals("-1"))
			{
				System.out.println("�˳���ģ��.........\n");
				break;
			}
			for (count = 0; count < num; count++) 
			{
				if(queryId.equals(FileOperation.getStudent(count).getId()))
				{
					break;
				}
			}
			if(count != num)
			{
				System.out.println("\n\n�ҵ���ؼ�¼�����£�");
				System.out.println("\t**************************************************************");
				System.out.println("\tѧ��\t����\t�Ա�\tѧԺ\t��Ŀһ\t��Ŀ��\t��Ŀ��\tƽ����");
				showOneStudentInfo(FileOperation.getStudent(count));
				System.out.println("\n\n\n");
			}
			else
			{
				System.out.println("û���ҵ���ؼ�¼��\n\n\n");
			}

		}
	}
	/*
	 * ����ѧԺ���в�ѯ
	 */
	public static void  queryByAcademy()
	{
		int count;
		String queryAcademy;
		ArrayList<Integer> studentId = new ArrayList<Integer>();
		String matchString = "[A-G]";
		Scanner input = new Scanner(System.in);
		while(true)
		{
			while(true)
			{
				System.out.println("\n\n�ֱ��� A-G 7��ѧԺ��������ѧԺ���ƽ��в�ѯ��(����-1�˳�)");
				queryAcademy = input.next();
				if(queryAcademy.matches(matchString)) break;
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
			
			for (count = 0; count < num; count++) 
			{
				if(queryAcademy.equals(FileOperation.getStudent(count).getAcademy()))
				{
					studentId.add(new Integer(count));
				}
			}
			if(studentId.isEmpty())
			{
				System.out.println("û���ҵ���ؼ�¼��\n\n\n");
			}
			else
			{
				System.out.println("\n\n�ҵ�"+studentId.size()+"����ؼ�¼�����£�");
				System.out.println("\t**************************************************************");
				System.out.println("\tѧ��\t����\t�Ա�\tѧԺ\t��Ŀһ\t��Ŀ��\t��Ŀ��\tƽ����");
				for(int i = 0; i < studentId.size(); i++)
				{
					showOneStudentInfo(FileOperation.getStudent(studentId.get(i).intValue()));
				}
				studentId.clear();
				System.out.println("\n\n\n");
			}
			
			
		}
	}
	
	public static void showOneStudentInfo(Student student)
	{
		student.getOneStudentInfo();
	}
	
	public static void showAllStudentInfo()
	{
		for (int i = 0; i < FileOperation.getStudentNum(); i++) {
			showOneStudentInfo(FileOperation.getStudent(i));
		}
	}

}
