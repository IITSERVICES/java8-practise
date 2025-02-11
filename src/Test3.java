import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Customer implements Comparable<Customer>{
	int id;
	String name;
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Customer() {
		super();
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
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Customer o) {
		 if(this.id>o.id)
			 return 1;
		 else if(this.id<o.id)
			 return -1;
		 else
		return 0;
	}
	
}

public class Test3 {
	public static void main(String[] args) {
		ArrayList<Customer> list
		=new ArrayList<>();
	
		Customer c1=new Customer(1,"RAJU");
		Customer c2=new Customer(3,"SUNIL");
		Customer c3=new Customer(5,"Mahesh");
		Customer c4=new Customer(6,"John");
		Customer c5=new Customer(4,"Sudheer");
		/*
		list.add(c1);list.add(c5);list.add(c3);list.add(c4);list.add(c2);
		//System.out.println(list);
		
	     Collections.sort(list);
		 list.forEach((customer)->System.out.println(customer));*/
		//list.add(c1);list.add(c5);list.add(c3);list.add(c4);list.add(c2);
		/*Comparator<Customer> comparator=new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o2.compareTo(o1);
			}
		};
		Collections.sort(list, comparator);		

		list.forEach((customer)->System.out.println(customer));*/
		
		
		
		list.add(c1);list.add(c5);list.add(c3);list.add(c4);list.add(c2);
		
		//Collections.sort(list, (o1,o2)->o2.compareTo(o1));
		//list.forEach((customer)->System.out.println(customer));
		
		//Method Reference
		Collections.sort(list, Customer::compareTo);
		
		System.out.println(list);

		
	}

}
