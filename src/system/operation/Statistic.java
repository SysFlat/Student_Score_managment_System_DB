package system.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import system.db.dbOperation;
import system.file.FileOperation;

public final class Statistic {
	public int studentNum;
	public Connection conn = null;
	public  Statement stat = null;
	public ResultSet set = null;
	/*
	 * 学生成绩统计函数
	 */

	public  void statisticScore()
	{
		String statisticSql = "select count(*) from student where averageScore ";		
		System.out.println("\n\n统计平均成绩情况如下：");
		int statistic[] = {0,0,0,0,0};

		/*
		 * 查询符合条件的记录数目
		 */
		try {
			conn = (Connection) dbOperation.dbConn();
			stat = conn.createStatement();
			// all student number			
			set = stat.executeQuery("select count(*) from student");
			if(set.next())
			{
				studentNum = set.getInt("count(*)");
			}
			//System.out.println(studentNum);
			
			//<60
			set = stat.executeQuery(statisticSql + " < 60");
			if(set.next())
			{
				statistic[0] = set.getInt("count(*)");
			}
			//60~69
			
			set = stat.executeQuery(statisticSql + " between 60 and 69 ");
			if(set.next())
			{
				statistic[1] = set.getInt("count(*)");
			}
			
			//70~79
			set = stat.executeQuery(statisticSql + " between 70 and 79 ");
			if(set.next())
			{
				statistic[2] = set.getInt("count(*)");
			}
			//80~89
			set = stat.executeQuery(statisticSql + " between 80 and 89");
			if(set.next())
			{
				statistic[3] = set.getInt("count(*)");
			}
			//>= 90
			
			set = stat.executeQuery(statisticSql + " >= 90 ");
			if(set.next())
			{
				statistic[4] = set.getInt("count(*)");
			}/*
			*/
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			dbOperation.dbClose(conn, set, stat);
		}


		
		System.out.println("\t分段\t人数\t图形");
		System.out.println("\t<60\t" + statistic[0] + "\t"   + putGraph(statistic[0]));
		System.out.println("\t60-69\t" + statistic[1] + "\t" + putGraph(statistic[1]));
		System.out.println("\t70-79\t" + statistic[2] + "\t" + putGraph(statistic[2]));
		System.out.println("\t80-89\t" + statistic[3] + "\t" + putGraph(statistic[3]));
		System.out.println("\t>90\t" + statistic[4] + "\t"   + putGraph(statistic[4]));
	
		
		System.out.println("\n\n按回车键退出.........");
		new Scanner(System.in).nextLine();
	}

	/*
	 * 生成统计图*
	 */
	public  String putGraph(int num)
	{
		StringBuffer outBuffer = new StringBuffer();
		outBuffer.setLength(0);
		for (int i = 0; i < num * 100 / studentNum / 2; i++) 
		{
			outBuffer.append("*");
		}
		return outBuffer.toString();
	}

		

}
