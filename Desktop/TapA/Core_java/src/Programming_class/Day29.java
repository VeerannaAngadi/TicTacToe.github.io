package Programming_class;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Employee{
	private int id;
	private String name;
	private String emailId;
	private String dept;
	private int salary;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String emailId, String dept, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.dept = dept;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
//	poj= plain old java obeject
	
	
       
}
public class Day29 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("enter total number of employee");
        int n = scan.nextInt();
        ArrayList<Employee> list = new ArrayList<Employee>();
        scan.nextLine();
        for(int i=0; i<n;i++) {
        	String s = scan.nextLine();
        	int id=1001+i;
        	String[] ar = s.split(",");
        	String name=ar[0];
        	String emailId= ar[1];
        	String dept=ar[2];
        	int salary=Integer.parseInt(ar[3]);
        	Employee e = new Employee(id, name, emailId, dept, salary);
        	list.add(e);
        	
        }
        ListIterator<Employee> li = list.listIterator();
        
        while(li.hasNext()) {
        	Employee e = li.next();
//        	System.out.println(e.getName()+" "+e.getEmailId()+" "+e.getId());
        	System.out.println(e);
        }
             
	}

}
