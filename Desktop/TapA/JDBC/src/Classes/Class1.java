package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		
		Connection myCon=null;
		Statement statement =null;
		ResultSet res =null;
		try {
			
			myCon = DriverManager.getConnection(url, username, password);
			
				display(res,statement,myCon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (myCon != null) {
					
					myCon.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement !=null) {
					statement.close();
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (res !=null) {
					
					res.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	public static void display(ResultSet res,Statement statement,Connection myCon) throws SQLException {
		String sql="select * from employee";
		statement = myCon.createStatement();
		res = statement.executeQuery(sql);
		System.out.println("________________________________________________");
		while(res.next()) {
			int id = res.getInt("id");
			String name = res.getString("name");
			String email = res.getString("email");
			String dept = res.getString("dept");
			int salary = res.getInt("salary");
			
			System.out.printf("|%-3d|%-8s|%-15s|%-8s|%-8d|\n",id,name,email,dept,salary);
			
		}
		System.out.println("________________________________________________");
	}

}
