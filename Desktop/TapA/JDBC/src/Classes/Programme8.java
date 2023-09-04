package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.midi.Receiver;

public class Programme8 {
	public static Connection myCon;
	public static PreparedStatement statement2; 
	public static Statement statement;
	private static final Scanner scn = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		
		try {
			 myCon = DriverManager.getConnection(url, username, password);
			
			Class1.display(null, statement, myCon);
			
			transaction();
			System.out.println("/n");
			Class1.display(null, statement, myCon);
	
			
		} catch (SQLException e) {
						e.printStackTrace();
		}
		
	}


	private static void transaction() throws SQLException{
		
		myCon.setAutoCommit(false);
		System.out.println("Enter the sender name");
		String sender=scn.next();
		System.out.println("Enter the reciever name");		
		String reciever=scn.next();
		System.out.println("Enter the amount");
		int amount=scn.nextInt();
		
				int i = updateAmount(sender,-amount);
				int j = updateAmount(reciever,amount);
				if (isConfirm(i ,j)){
					myCon.commit();
					System.out.println("Payment Successful...");
					
				}
				else {
					myCon.rollback();
					System.out.println("Payment failed");
				}
	}


	private static boolean isConfirm(int i , int j) {
		System.out.println("Comfirm before trancation yes/no ");
		String choice=scn.next();
		return choice.equalsIgnoreCase("yes")&& i==1 && j==1;
		
	}


	private static int updateAmount( int amount,String reciever) throws SQLException {
		String sql="Update `employee` set `salary`=`salary`+? where `name`=?";
		 statement2 = myCon.prepareStatement(sql);
		 statement2.setInt(1,amount);
		 statement2.setString(2, reciever);
		 int res = statement2.executeUpdate();
		 return res;
		
	}


	private static int updateAmount(String sender,int amount) throws SQLException{
		String sql="Update `employee` set `salary`=`salary`+? where `name`=?";
			 statement2 = myCon.prepareStatement(sql);
			 statement2.setInt(1,amount);
			 statement2.setString(2, sender);
			 int res = statement2.executeUpdate();
			 return res;
			 
		
		
	}

}
