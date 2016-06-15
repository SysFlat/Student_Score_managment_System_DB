package system.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import system.db.dbOperation;
import system.object.Student;

public class FileOperation {
	public static String insertString = "insert into student values('%s','%s','%s','%s',%s,%s,%s,%s)";
	/*
	 * 读取数据文件
	 */
	public static void readFileIntoDb( )
	{
		String dataLineString;
		StringBuffer buff = new StringBuffer();
		/*
		 * 总共有7列
		 */
		String array[] = null;
		String averageScore ;


		try {
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
			while((dataLineString = reader.readLine()) != null)
			{
				array = dataLineString.split("\\s+");
				averageScore = String.format("%.2f", (Float.parseFloat(array[4]) +
													  Float.parseFloat(array[5]) + 
													  Float.parseFloat(array[6]))/3.0);
				try {
					dbOperation.getStatement().executeUpdate(
							String.format(insertString, array[0],array[1],array[2],array[3],
							 							array[4],array[5],array[6],
							 							//averageScore
							 							averageScore)
							);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
