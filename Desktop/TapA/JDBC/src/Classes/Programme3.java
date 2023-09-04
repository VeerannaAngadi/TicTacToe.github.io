package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Programme3 {
	public static Connection myCon;
	public static Statement statement;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		String sql="Delete from `employee`  where `id`<=6";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 myCon = DriverManager.getConnection(url, username, password);
			 Class1.display(null, statement, myCon);
			 statement = myCon.createStatement();
			int res = statement.executeUpdate(sql);
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
