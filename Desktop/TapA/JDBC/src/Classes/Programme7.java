package Classes;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Programme7 {
	public static Connection myCon;
	public static PreparedStatement statement2; 
	public static Statement statement;
	private static final Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		String choice=null;
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		String sql="Insert into `employee`"
				+ "(`id`,`name`,`email`,`dept`,`salary`)"
				+ "values(?,?,?,?,?)";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 myCon = DriverManager.getConnection(url, username, password);
			 Class1.display(null, statement, myCon);
			 statement2 = myCon.prepareStatement(sql);

			 do {
					System.out.println("eneter the id");
					statement2.setInt(1, scn.nextInt());
					System.out.println("eneter the name");
					statement2.setString(2, scn.next());
					System.out.println("eneter the email");
					statement2.setString(3, scn.next());
					System.out.println("eneter the dpt");
					statement2.setString(4, scn.next());
					System.out.println("eneter the salary");
					statement2.setInt(5, scn.nextInt());
					int res = statement2.executeUpdate();
					System.out.println(res);
				 System.out.println("do you need to enter the one more empolyee?  yes/no");
				  choice = scn.next();
				
			} while (choice.equals("yes"));
	 
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









