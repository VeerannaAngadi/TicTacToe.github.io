package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Programme5 {
	public static Connection myCon;
	public static Statement statement;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		String sql="Insert into `employee`(`id`,`name`,`email`,`dept`,`salary`) values(12,'loby','loby@gmail.com','finance',30000)";
		String sq2="Insert into `employee`(`id`,`name`,`email`,`dept`,`salary`) values(13,'voby','voby@gmail.com','IT',20000)";
		String sq3="Insert into `employee`(`id`,`name`,`email`,`dept`,`salary`) values(14,'poby','poby@gmail.com','HR',150000)";
		String sq4="Insert into `employee`(`id`,`name`,`email`,`dept`,`salary`) values(15,'coby','coby@gmail.com','IT',300000)";
		
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 myCon = DriverManager.getConnection(url, username, password);
			 Class1.display(null, statement, myCon);
			 statement = myCon.createStatement();
			statement.addBatch(sql);
			statement.addBatch(sq2);
			statement.addBatch(sq3);
			statement.addBatch(sq4);
			
			
			int[] res = statement.executeBatch();
			for(int i=0;i<res.length;i++) {
				System.out.println(res[i]);
				
			}
			System.out.println();
			Class1.display(null, statement, myCon);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

}
