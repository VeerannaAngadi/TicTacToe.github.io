package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Programme6 {
	public static Connection myCon;
	public static Statement statement;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		String sql="Update `employee` set `salary`=`salary`+ ? where `dept`=?";
		Scanner scn = new Scanner(System.in);
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 myCon = DriverManager.getConnection(url, username, password);
			 Class1.display(null, statement, myCon);
			 
			 
			 
			 PreparedStatement statement2 = myCon.prepareStatement(sql);
			 System.out.println("enter hike");
			 statement2.setInt(1, scn.nextInt() );
			 System.out.println("Dept");
			 statement2.setString(2, scn.next());
			 int res = statement2.executeUpdate();
			 	System.out.println(res);
			 
			 	
			 	
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
