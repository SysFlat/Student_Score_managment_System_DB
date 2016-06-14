package system.menu;

import java.util.Scanner;

import system.db.dbOperation;
import system.file.FileOperation;
import system.operation.AddDelModify;
import system.operation.QueryFunction;
import system.operation.SortFunction;
import system.operation.Statistic;

public class Menu {

	public static void main(String[] args) {
		
		dbOperation.dbConnection();
		dbOperation.createTable();
		dbOperation.closeDb();
		//mainMenu();
	}
	
	public static void mainMenu(){
		Scanner input = new Scanner(System.in);
		/*
		 * ϵͳ������
		 */
		while(true)
		{
			System.out.println("****************************************");
			System.out.println("\t��ӭʹ�ò�ѯϵͳ\n\n");
			System.out.println("\t1:���ѧ����Ϣ");
			System.out.println("\t2:ɾ��ѧ����Ϣ");
			System.out.println("\t3:�޸�ѧ����Ϣ");
			System.out.println("\t4:����ƽ���ɼ��Ľ�������");
			System.out.println("\t5:������������������");
			System.out.println("\t6:����ѧ�Ž��в�ѯ");
			System.out.println("\t7:�����������в�ѯ");
			System.out.println("\t8:����ѧԺ���в�ѯ");
			System.out.println("\t9:ƽ���ɼ�ͳ��");
			System.out.println("\t10:�˳�");
			System.out.println("****************************************");
			System.out.println("�������ѡ����Ӧ�Ĺ��ܣ�");
			
			FileOperation.readFile();
			int choice = input.nextInt();
			//Integer.parseInt(s)
			switch(choice)
			{
				case 1: AddDelModify.addStudent();
				break;
				
				case 2: AddDelModify.delStudent();
				break;
				
				case 3: AddDelModify.modifyStudent();
				break;
			
				case 4: SortFunction.descendByAverage();	
				break;
				
				case 5: SortFunction.ascendByName();	
				break;
				
				case 6: QueryFunction.queryById();
				break;
				
				case 7: QueryFunction.queryByName();
				break;
				
				case 8: QueryFunction.queryByAcademy();
				break;
				
				case 9: Statistic.statisticScore();
				break;
				
				case 10: 
					{
						input.close();
						exit();						
					}
				break;
				
			}
			
			/*
			 * ������޸ģ����˳�ʱ��д���޸�
			 */
			if(FileOperation.getModifyFlag()) FileOperation.saveStudentInfo();
		}

	}
	public static void exit()
	{
		System.out.println("�˳�ϵͳ.........");
		System.exit(0);
	}
	
}
