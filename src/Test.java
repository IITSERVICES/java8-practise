import java.util.ArrayList;
import java.util.Iterator;

class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Employee emp1=new Employee(1001,"RAJU",30000.0);
		Employee emp2=new Employee(1003,"JOHN",50000.0);
		Employee emp3=new Employee(1002,"RAISHAB",80000.0);
		Employee emp4=new Employee(1005,"ARYAN",90000.0);
		Employee emp5=new Employee(1004,"SUNIL",100000.0);
		
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		task1(list);//Display All the Employee Details from the list
		
		
	}

	private static void task1(ArrayList<Employee> list) throws InterruptedException {
		   
		  list.forEach((employee)->System.out.println(employee));
		
	}

}
