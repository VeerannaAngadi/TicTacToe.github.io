package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class programme2 {
	public static Connection myCon;
	public static Statement statement;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		String sql="Update `employee` set `salary`=`salary`+5000 where `dept`='HR'";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 myCon = DriverManager.getConnection(url, username, password);
			 statement = myCon.createStatement();
			int res = statement.executeUpdate(sql);
			System.out.println(res);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

}
