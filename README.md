-------------------------------------------------------------------------------------------------
Java 8 Features
---------------
1.  Functional Interface
2.  Lambda Expression
3.  Method References
4.  default method & static method
5.  Stream API
6.  Optional Class
7.  Collectors class
8.  ForEach method
et...
-------------------------------------------------------------------------------------------------
1. Functional Interface
------------------------

- Upto JDK 1.7 Interface contain the following things:
   interface interfaceName{
        public static final variable;
        public abstract method();
   }
- Since from JDK 1.8 version onwards there is some changes in an interface:
    interface interfaceName{
        public static final variable;
        public abstract method();
        default method
        static method
   }

- An interface does'nt contain any methods such type of interface is called as:
    Marker/tagged interface
   Ex:   Serializable


- An interface contain only single abstract method such type of interface is called

   as functional interface and which is declare with annotation i.e. @FunctionalInterface


Example1
--------
@FunctionalInterface
interface Interface1 {
void greetingMessage(String msg);//SAB
}

class MyImpl implements Interface1{
	
	@Override
	public void greetingMessage(String msg) {
		System.out.println(msg);
	}
}

public class Test {
	public static void main(String[] args) {
		Interface1 i=new MyImpl();
		i.greetingMessage("Welcome to Java Features Session");
	}

}
------------------------------------------------------------------------------------------------
Example2
--------
```
import java.util.function.Predicate;

class MyImpl implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		// Write a logic to check given number is even or not
		if (t.intValue() % 2 == 0)
			return true;
		else
			return false;
	}

}

public class Test {
	public static void main(String[] args) {
		Predicate<Integer> p = new MyImpl();
		int num = 2;
		if (p.test(num)) {
			System.out.println(num + " is a even number");
		} else {
			System.out.println(num + " is a odd number");
		}

	}

}
```
------------------------------------------------------------------------------------------------
4.  default method & static method
-----------------------------------

- Upto JDK 1.7 Interface contain the following things:
   interface interfaceName{
        public static final variable;
        public abstract method();
   }
- Since from JDK 1.8 version onwards there is some changes in an interface:
```
   interface interfaceName{
        public static final variable;
        public abstract method();
        default method
        static method
   }
```

- A method which is declare with default keyword and contain a body inside the interface.
- This default method is applicable to all the implemenation classes.
- A default method for backward comptablility.
- We can add any no of default methods inside the interface.
- Yes , we can override the default methods also.
- We can add any no of default methods in an interface.

ii. static method in an interface
----------------------------------
- In addition to default method in an interface , an interface contain static method also.
- This static method is added for defining a utility functions.
- static method in interface will not be applicable to the implemenation classes i.e. we can't use with the reference.
- static method in interface we can call or invoke with InterfaceName.staticMethod();

Example
------
```
DAO.java(interface)
public interface DAO {
	public void addEmployee();
	public void updateEmployee();
	public void deleteEmployee();
	public default String greetingMessage1() {
		return "Welcome to DAO operation....";
	}
	public static String greetingMessage2() {
		return "Welcome to CRUD Operations...";
	}
}

ClientApplication.java
------------------------
public class ClientApplication {
	public static void main(String[] args) {
		String msg=DAO.greetingMessage2();
		System.out.println(msg);
	}

}
```
------------------------------------------------------------------------------------------------
Nested Classes
---------------
- A nested class is nothing but a class which is declare inside the another class is called as nested class

Syntax:
------
```
    class OuterClass{
    		//members of a outer-class
           class InnerClass{
             // members of a inner-class
           }
    }
```
- In order to logically group the classes and interface in single file.
- It help us to optimized the code.
- We can access the private member of outer-class inside the inner-class.

-> Different types of inner classes
------------------------------------
1. Member inner class
	- A class which is created within the class and outside the method.
2. Anonymous inner class
    - A class which is created for implemenating an interface or abstract class by the java compiler.
3. Local inner class
    - A class which is created within the method.
--------------------------------------------------------------------------------------------
1. Member Inner class
----------------------
```
class A{
	//member
	int a; // member
	//member
	void show(){

	}
	//member of Class A
	class B{

	}
}
Example
--------
class OuterClass{
private int a=100;//member
	
	class InnerClass{  // member
		int b=200;
		void innerMethod() {
			System.out.println("a:"+a);
			System.out.println("b:"+b);
		}
	}//close inner class
	
	void outerMethod() { //member
		System.out.println("Inside the outer method");
	}
}//close outerclass

public class Test {
	public static void main(String[] args) {
		OuterClass outerClassRef = new OuterClass();
		outerClassRef.outerMethod();
	
		//Now create an object for the outerclass
		OuterClass.InnerClass innerClassRef =outerClassRef.new InnerClass();
		innerClassRef.innerMethod();
	
	}

}
```
-----------------------------------------------------------------------------------------------
Topic : Java 8 Features
-----------------------------------------------------------------------------------------------

2. Anonymous inner class
    - A class which is created for implemenating an interface or abstract class by the java compiler.


Example
-------
```
interface A{//A.class
	void message(String msg);
}


public class Test1 {//Test1.class
	public static void main(String[] args) {
		A aRef = new A() {
			
			@Override
			public void message(String msg) {
				System.out.println(msg);
				
			}
		};
		aRef.message("Good Morning....");
	}

}

- When the above classes have compiled the following are the .class files has generated.

A.class
Test1.class
Test1$1.class

>javap Test1$1.class
class Test1$1 implements A {
  Test1$1();
  public void message(java.lang.String);
}
```
---------------------------------------------------------------------------------------------------
1. Lambda Expression
2. Functional Interface
	- Predicate
	- Function
	- Consumer
	- Supplier
	etc....

3. Stream API
4. Optional class
5. Method Reference
----------------------------------------------------------------------------------------------------
1. Lambda Expression
--------------------
Since from JDK 8 version onwards the oracle people has added lambda expression, the author of java
tried to add the elements of functional programming in java.

- In case of functional programming , functions can exit outside the scope of an object when it's compare with object oriented programming lang.

- We can assign them toa reference variable and we can pass them to other methods as a parameter

- A lambda expression is just an anonymous function i.e. a function with following:
          -> No name
          -> No return type
          -> No Modifier

 Example
 --------
 ```
    ()->{
       System.out.println("Lambda Expression");
    }
```
Why to use labmda expression
----------------------------
- To write the functional programming in java
- To write more readable, manintalble and concice code
- In order to refer the functional interface.


Example1:
--------
```
@FunctionalInterface
interface A{//A.class
void message1();
}
public class Test1 {//Test1.class
	public static void main(String[] args) {
		A aref = ()->System.out.println("Lambda Expression");
	    aref.message1();
	}
}

Example2:
---------

@FunctionalInterface
interface A{//A.class
void message1(String msg);
}
public class Test1 {//Test1.class
	public static void main(String[] args) {
		A aref = (msg)->System.out.println(msg);
	    aref.message1("Lambda expression");
	}
}

Example3:
----------

@FunctionalInterface
interface A{//A.class
String message1();
}
public class Test1 {//Test1.class
	public static void main(String[] args) {
		A aref = ()->{
			return "Lambda expression";
		};
	    String result = aref.message1();
	    System.out.println(result);
	}
}

Example4:
--------

@FunctionalInterface
interface A{//A.class
String message1(String name);
}
public class Test1 {//Test1.class
	public static void main(String[] args) {
		A aref = (name)->{
			return "Good Morning: Mr"+ name;
		};
	    String result = aref.message1("Raju");
	    System.out.println(result);
	}
}
```
----------------------------------------------------------------------------------------------------
1. Predicate
   public boolean test(Object o);
```
import java.util.function.Predicate;
 
//Write a java code to find all the even number from 1 to 100
public class Test1 {//Test1.class
public static void main(String[] args) {
		Predicate<Integer> p=(input)->{
							    return (input%2==0?true:false);
							 };
		for(int i=1;i<=100;i++) {
			    if(p.test(i))
			    	System.out.println(i);
		}
		 
	}
}
```
-----------------------------------------------------------------------------------------------------
2. Function
 
   R apply(T t);
   -> This method take some input and generate some output.
```
import java.util.function.Function;
 
//Display all the names of items in upper case 
public class Test1 {//Test1.class
public static void main(String[] args) {
		Function<String,String> f=(item)->{
			return item.toUpperCase();
		}; 
	
	    String items[]= {"mango","orange","banana","pineapple"};
		for(String item:items) { 
			  System.out.println("Item: "+item+":has converted in upper case:"+f.apply(item));
			  
		}
		 
		 
	}
}
-----------------------------------------------------------------------------------------------------
3.Supplier
Represents a supplier of results.

	T get();


Example
-------
import java.util.function.Supplier;
 
//Display all the names of items in upper case 
public class Test1 {//Test1.class
public static void main(String[] args) {
		 Supplier<String> supplier=()->{
			 	return "Welcome to Home Page";
		 };
		 
		 for(int visitor=1;visitor<=10;visitor++) {
			     System.out.println(supplier.get());
		 }
		 
		 
	}
}
```
-----------------------------------------------------------------------------------------------------
4. Consumer
Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
void accept(T t);

Example
-------
```
import java.util.function.Consumer;
import java.util.function.Supplier;

//Display all the names of items in upper case 
public class Test1 {// Test1.class
	public static void main(String[] args) {
		Consumer<String> consumer = (msg) -> System.out.println(msg);

		Supplier<String> supplier = () -> {
			return "Welcome to Home Page";
		};

		for (int visitor = 1; visitor <= 10; visitor++) {
			consumer.accept(supplier.get());

		}

	}
}
------------------------------------------------------------------------------------------------------
5. BiFunction
   public R apply(T t,
        U u);

import java.util.function.BiFunction;
//Display all the names of items in upper case 
public class Test1 {// Test1.class
public static void main(String[] args) {
		BiFunction<String,String,String>
		biFunction=(t,u)->{//raju,kumar
			return t.concat(u);//raju.concat(kumar) -> raju kumar
		};
		
		System.out.println(biFunction.apply("raju", " kumar"));
		System.out.println(biFunction.apply("sunil", " kumar"));
		System.out.println(biFunction.apply("rahul", " reddy"));
		System.out.println(biFunction.apply("sudheer", " reddy"));
		
		
	}
}
```
------------------------------------------------------------------------------------------------------
Method Reference(::) Operator
------------------------------
- Method reference , as the name suggest are the references to a method.
- When we compare with lambda expression with method reference , the method reference is 
  a shortened version of labmda expression that will call a specific method.

Syntax:
-------

    objectRef::methodName;// If it is a instance method

    or

    className::methodName;//If it is a static method

Example
-------
```
@FunctionalInterface
interface A {// A.class
	void message1();
}
public class Test1 {// Test1.class
	//Instance method
	 void message1() {
		System.out.println("Good Morning...");
	}

	public static void main(String[] args) {
	    Test1 tref = new Test1();
		A aref=tref::message1;
		aref.message1();
	 }
}

Example2:
---------
@FunctionalInterface
interface A {// A.class
	void message1();
}
public class Test1 {// Test1.class
	//static method
	 static void message1() {
		System.out.println("Good Morning...");
	}

	public static void main(String[] args) {
	    A aref=Test1::message1;
		aref.message1();
	 
	}
}
```
-----------------------------------------------------------------------------------------------
Stream
-------
- If we want to represent a group of individual objects as a single entity then we should go 
  for collections(List,Set,Map,Queue)
- If we want to process a group of objects from the collection then we should go for streams.
- We can create a stream object to the collection by using the stream() method of Collection interface which is added since from jdk 1.8version onwards.

Collection(I)- since from jdk 1.8 version onwards.
default Stream stream();

Syntax:
--------
             Stream stream = ref.stream();



Example
-------
```
import java.util.ArrayList;
import java.util.stream.Stream;

public class Test1 {// Test1.class
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		 
		 Stream<Integer> s=list.stream()//Step1: Getting the Stream object
		 	 .filter(element->element%2==0);//Step2: Configuration 1. Filtering
		 s.forEach(e->System.out.println(e));//Step3: Processing forEach()
		 

	}
}
```
----------------------------------------------------------------------------------------------------
Topic: Java 8 
```
package com.iits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Entity: Employee
class Employee implements Comparable<Employee> {
	private Integer id;
	private String name;
	private double salary;
	private boolean isActive;
	private String department;

	public Employee(Integer id, String name, double salary, boolean isActive, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.isActive = isActive;
		this.department = department;
	}

	public Integer getId() {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", isActive=" + isActive
				+ ", department=" + department + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if (this.id > o.getId())
			return 1;
		else if (this.id < o.getId())
			return -1;
		else
			return 0;
	}

}

public class Test {
	public static void main(String[] args) {
		List<Employee> list = generateEmployee();
		System.out.println("-- Display All Employees Details--");
		displayEmployees(list);
		System.out.println("--Display All Employee Details whose Name is start with 'S'--");
		displayAllEmployeesStartWith(list);// start with letter 'S'
		System.out.println("--Count No of Employee whose Name letter start with 'S'--");
		countEmployee(list);
		System.out.println("--Display All Employee whose is Active , working in IT and Salary is less then 50k--");
		displayAllEmployeeIsActive(list);
		System.out.println("--Display All Employee whose working in IT department and names should print in uppercase");
		displayEmployeeNameInUpperCase(list);
		System.out.println("--Sort all the Employee Based on Id and Display on console--");
		sortAndDisplayAllEmployee(list);
		System.out.println("-- Display all the sum of salary which paid to all employee-");
		displaySumOfAllSalariesOfEmployee(list);
	}

	private static void displaySumOfAllSalariesOfEmployee(List<Employee> list) {
		  double sumOfSalary=list.stream()
		  	  .map(e->e.getSalary())
		  	  .reduce(0.0, Double::sum)
		  	  .doubleValue();
		  System.out.println(sumOfSalary);
		
	}

	private static void sortAndDisplayAllEmployee(List<Employee> list) {

		/*
		 * list.stream() .sorted() .forEach(System.out::println);
		 */

		list.stream()
				// .sorted((e1,e2)->e2.getId().compareTo(e1.getId()))
				.sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).forEach(System.out::println);
	}

	private static void displayEmployeeNameInUpperCase(List<Employee> list) {
		list.stream().filter(e -> e.getDepartment().equals("IT")).map(ee -> ee.getName().toUpperCase())
				.forEach(System.out::println);

	}

	private static void displayAllEmployeeIsActive(List<Employee> list) {
		list.stream().filter(e -> (e.isActive() && e.getDepartment().equals("IT") && e.getSalary() < 50000.00))
				.forEach(System.out::println);

	}

	private static void countEmployee(List<Employee> list) {

		long count = list.stream().filter(e -> e.getName().startsWith("S")).count();
		System.out.println("Count:" + count);

	}

	private static void displayAllEmployeesStartWith(List<Employee> list) {

		list.stream().filter(e -> e.getName().startsWith("S")).forEach(System.out::println);
	}

	private static void displayEmployees(List<Employee> list) {
		// Consumer<Employee> consumer=;
		// list.forEach((e)->System.out.println(e));
		list.forEach(System.out::println);
	}

	private static List<Employee> generateEmployee() {
		// Create 5 Employee object with different data
		Employee emp1 = new Employee(1001, "raju", 30000.00, true, "IT");
		Employee emp2 = new Employee(1003, "Sunil", 40000.00, false, "HR");
		Employee emp3 = new Employee(1002, "ramesh", 50000.00, true, "OP");
		Employee emp4 = new Employee(1005, "ADIL", 70000.00, false, "PLC");
		Employee emp5 = new Employee(1004, "sudheer", 90000.00, true, "IT");

		// Store into a List and return the List
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);

		return list;
	}

}
```
------------------------------------------------------------------------------------
Features : Java 9

Optional
--------
-> The Optional class in java is a container object that may or may not contain a non-null value.
->If a value is present, isPresent() will return true and get() will return the value.
-> It was added since from jdk 1.8v onwards, it has added in java.util.*; package

Example
--------
```
package com.iits;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Product {
	private int pid;
	private String pname;
	private double price;

	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}

}

public class Test3 {
	public static void main(String[] args) {
		/*Product p1=new Product(101, null, 0.0);
		Product p2=new Product(102,"Mobile",10000.0);
		Product p3=new Product(103,"Keyboard",1400.00);
		List<Product> list =  Arrays.asList(p1,p2,p3);
		 */
	    String str = "mango";
	    Optional<String> op=Optional.ofNullable(str);
	    if(op.isPresent()) {
	    	System.out.println("yes");
	    	System.out.println(op.get());
	    }else {
	    	System.out.println("no");
	    }
		
	   /*List<String> list=null;
	   Optional<List<String>> op1=Optional.ofNullable(list);
	   if(op1.isPresent()) {
		   System.out.println(op1.get());
	   }else {
		   System.out.println("No");
	   }*/
	   
	    //List<String> list=Arrays.asList("Mobile","Laptop","Keyboard");
	    List<String> list=null;
	    Optional<List<String>> op2=Optional.ofNullable(list);
	    if(op2.isPresent()) {
	    	   List<String> items=op2.get();
	    	   items.forEach(System.out::println);
	    }else {
	    	//op2.orElseThrow();
	    	try {
	    	op2.orElseThrow(()->new RuntimeException("No Elements available"));
	    	}catch(RuntimeException re) {
	    		System.err.println(re.getMessage());
	    	}
	    }
	    
	    
	}

}
```
----------------------------------------------------------------------------------------
Java 9
------
1. JShell
----------
- It is a REPL( R-Read, E-Eval, P-Print , L-Loop)
- It is a tool which is added from jdk 1.8v onwards.
- It is used to allows the user to test the code very quickly without creating the entire
  application.
- It is helping for the user to learn and define the snippets code to test it.

-> In order to use the jshell following steps:

Stpe1: Open the command prompt
> jshell
 - Here we can define variables, methods , loops, ect..

jshell> int x=10;
x ==> 10

jshell> int y=20;
y ==> 20

jshell> int res=x+y;
res ==> 30

jshell> System.out.println(res);
30
jshell> int sum(int a,int b){return a+b;}
|  created method sum(int,int)

jshell> int sumOfTwoVar=sum(10,20);
sumOfTwoVar ==> 30

jshell> System.out.println("Sum is:"+sumOfTwoVar);
Sum is:30

jshell> for(int i=1;i<=10;i++){if(i%2==0){System.out.println(i);}}
2
4
6
8
10
========================================================================================
Private Method in interface
----------------------------
```
interface InterfaceName{
	//upto jdk 1.8v 
	//public static final variables
    //public abstrac method
    // default 
    // static 
    // since from jdk 9 version onwards
    // private
}

- It is added since from jdk 1.9 version onwards.
- It is used to define the common code which we are writing inside the default method.
  i.e. the duplicate code we can avoid.
- The scope of a private method is within the interface we cannot use outside.


Example
-------
package com.iits;

interface I{

	default void m1() {
		 greetingMessage();
	}
	default void m2() {
		 greetingMessage();
	}
	private void greetingMessage() {
		System.out.println("Hi Everyone");
	}
	void add(int a,int b);
}

public class Test4 {
	public static void main(String[] args) {
		I i=(a,b)->{
			System.out.println(a+b);
			
		};
		i.m1();
		i.m2();
		i.add(10,20);
	}

}
```
--------------------------------------------------------------------------------------
Try With Resource
-----------------
-> This feature is added from jdk 1.7 version onwards.

//Upto JDK 1.6  try-catch-finally
```
package com.iits;

import java.io.FileInputStream;
import java.io.IOException;

//try with resource
public class Test5 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("abc.txt");
			// logic to read the data
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

	}

}


//since from jdk 1.7 version try-with-resource
package com.iits;

import java.io.FileInputStream;

//try with resource
public class Test5 {
	public static void main(String[] args){
		
		try(FileInputStream fis=new FileInputStream("abc.txt")){
			//write the code to read the 
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
```
-------------------------------------------------------------------------------------
- In JDK 1.7v we cannot declare the resource outside the try block , in order to
overcome this issued since from jdk 1.9v onwards they have introduced to declare
the resource inside the try block:
```
package com.iits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//try with resource
public class Test5 {
	public static void main(String[] args) throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("abc.txt");
		try(fis){
			//write the code to read the 
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
```
-------------------------------------------------------------------------------------
Collection Factory Method
-------------------------
- Since from jdk 9version the following methods are added:
 Before jdk 1.9
 Collections.unmodifiable(list);
 Collections.unmodifiable(set);
 Collections.unmodifiable(map);

 Since from JDK 1.9 onwards we use the following methods:
   List.of();
   List.of(E e);
   List.of(E... element);

Example
-------
```
package com.iits;

import java.util.List;

public class Test6 {
	public static void main(String[] args) {
		/*ArrayList<Integer>
		list=new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    System.out.println(list);
	    List<Integer> newList=Collections.unmodifiableList(list);
	    newList.add(3);
	    System.err.println(list);*/
	    
		List<Integer> list=List.of(1,2,3,4,5);
		System.out.println(list);
		list.add(6);
		System.out.println(list);
		 
	}

}
```
---------------------------------------------------------------------------------------
Stream API  Methods added
---------------------------
1. Stream iterate();
2. Stream takeWhile();
3. Stream dropWhile();
etc......
Example;
----------
2. Stream takeWhile();
- When compare with filter method it will stop execute once it found false or fail.
```
List<Integer> list=List.of(1,3,5);
	    list.stream()
	    	//.filter(element->element%2==0)
	    	 .takeWhile(element->element%2==0)
	    	 .forEach(System.out::println);
```
--------------------------------------------------------------------------------------
Java Fetaures: 10,11,12,13,14,15
Java 10 Features
----------------

1. Local-variable type inference
---------------------------------
- Since from JDK 10 version we can declare the variable without any type, and it's type is identify based on value which we store in a variable is called as Type Inference.

- Since from JDK 10 version if we want to declare variables with type inference we must use 'var' just before the variable

Syntax:
------
        var varName = value;

Rules :
- We can declare only inside the block.
- We cannot declare as below:
  - As a method argument
  - As a array declaration
  - As a instance variable

Example:
-------
```
package com.iits;

import java.util.ArrayList;

public class Test7 {
	public static void main(String[] args) {
		var id=1001;
		var name="RAJU";
		var salary=30000.00;
		var status = true;
		
		System.out.println(id+","+name+","+salary+","+status);
		for(var i=1;i<=10;i++) {
			System.out.println(i);
		}
		
		//Collections & Threads
		
		var list =new ArrayList<Integer>();
		list.add(10);list.add(2);list.add(3);
		System.out.println(list);
		
		var myThread=new Runnable() {
			@Override
			public void run() {
				System.out.println("inside the run");
			}
		};
		var t1=new Thread(myThread);
		t1.start();
		
		
		
	}
}
```
===================================================================================
//Since from JDK 11 we can use var to a lambda parameter
		Message m=(var msg)->{
			System.out.println(msg);
		};
		m.message("Good Evening...");

====================================================================================
Switch Statement
-----------------
- Since from JDK 1.0v to JDK 1.6 version the following type of vlaue will support by
  the switch block:
   byte, short, int ,char only
- Since from JDK 1.7v onwards it also support String as value.

Example:
----------
```
package com.iits;

public class SwitchChangesWIthVersion {
	public static void main(String[] args) {
		// JDk 1.0v to JDK 6
		String key = "1";
		switch (key) {
		case "1":
			System.out.println("one");
			break;
		case "2":
			System.out.println("two");
			break;
		default:
			break;
		}

	}

}
```
- Since from JDK 12v onwards oracle people has released the switch as expression(preview)
- That is we can use switch as an expression , and it return a value and it is possible to assign that value to any variable.

- Generally the switch expression we can use in two ways:
        1. By using break statement.
        2. By using lambda style syntax
```
 package com.iits;

public class SwitchChangesWIthVersion {
	public static void main(String[] args) {
		// JDK 12 Preview Version, but since from jdk 14 version it's standard.
		int key = 1;
		var result=switch (key) {
		case 1 -> "one";
		case 2 -> "two";
		default->"Not match";
		}
		

	}

}
```
-In order to compile the above code we need to use the following command:
  >javac --enable-preview -source 12 SwitchChangesWIthVersion.java
  >java --enable-prview SwitchChangesWIthVersion

- Since from JDk 14 version switch expression is as standar feature.
- The switch statement become more refined, including the use of the yield keyword.

Example
--------
```
package com.iits;

public class SwitchChangesWIthVersion {
	public static void main(String[] args) {
		// JDK 12 Preview Version
		String key = "Foo";
		int result = switch(key) {
	    case "Foo": 
	        yield 1;
	    case "Bar":
	        yield 2;
	    default:
	        System.out.println("Neither Foo nor Bar, hmmm...");
	        yield 0;
	};
		System.out.println(result);
		

	}

}
```
---------------------------------------------------------------------------------------
- Since from JDK 17version onwards there is quite changes in switch statement i.e. 
 Pattern Matching for switch (Preview)
 -------------------------------------
 - Before JDK 17 we can use downcasting , since from JDK 21 they have made standard.
```
 package com.iits;

interface Bank{
	double ROI();
}

class ICICIBank implements Bank{
	@Override
	public double ROI() {
		return 11.0;
	}
}
class SBIBank implements Bank{
	
	@Override
	public double ROI() {
		return 9.0;
	}
}

class GetROI{
	 
	static void roi(Bank bank) {
		if(bank instanceof ICICIBank icic) {
			System.out.println(icic.ROI());
		}else if(bank instanceof SBIBank sbi) {
			System.out.println(sbi.ROI());
		}
		
	}
}

public class Test8 {
	public static void main(String[] args) {
		GetROI.roi(new ICICIBank());
		GetROI.roi(new SBIBank());
		
		
	}

}
```
=======================================================================================
Example
-------
```
package com.iits;
 
public class Test8 {
	public static void main(String[] args) {
		 Object o="Hi";
		 
		  if(o instanceof String s) {
			  System.out.println(s);
		  }else {
			  System.out.println("invalid");
		  }
		
	}

}
```
--------------------------------------------------------------------------------------
- Since from JDK17 vresion pattern matching in switch(preview) has introduced for 
  matching instanceof in switch statement , but since from JDK 21 version they have made it standard.
```
 package com.iits;

public class Test8 {
	public static void main(String[] args) {
		Object o = 10.0;
		String res=formatter(o);
		System.out.println(res);
	}

	static String formatter(Object o) {
		String formatted = "unknown";
		if (o instanceof Integer i) {
			formatted = String.format("int %d", i);
		} else if (o instanceof Long l) {
			formatted = String.format("long %d", l);
		} else if (o instanceof Double d) {
			formatted = String.format("double %f", d);
		} else if (o instanceof String s) {
			formatted = String.format("String %s", s);
		}
		return formatted;
	}

}
```
--------------------------------------------------------------------------------------
```
package com.iits;
public class Test8 {
	public static void main(String[] args) {
		Object o = 10.0;
		String res = formatterWithLambda(o);
		System.out.println(res);
	}

	static String formatter(Object o) {
		String formatted = "unknown";
		if (o instanceof Integer i) {
			formatted = String.format("int %d", i);
		} else if (o instanceof Long l) {
			formatted = String.format("long %d", l);
		} else if (o instanceof Double d) {
			formatted = String.format("double %f", d);
		} else if (o instanceof String s) {
			formatted = String.format("String %s", s);
		}
		return formatted;
	}
	//Since from 21version it's standard and we can use a lambda
	static String formatterWithLambda(Object o) {
		return switch (o) {
		case Integer i -> String.format("int %d", i);
		case Long l -> String.format("long %d", l);
		case Double d -> String.format("double %f", d);
		case String s -> String.format("String %s", s);
		default -> o.toString();
		};

	}
}
```
======================================================================================
3. Compact Number Formatting
----------------------------

1000 -> 1k
1k   -> 1000

```
package com.iits;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Test8 {
	public static void main(String[] args) throws ParseException {
		 
		NumberFormat nf=NumberFormat.getCompactNumberInstance(new Locale("en","US"), 
				 NumberFormat.Style.SHORT);
		 
		System.out.println(1000+"-"+nf.format(1000));
		System.out.println("1K"+"-"+nf.parse("100k"));
	}

	 
}
```
---------------------------------------------------------------------------------------
JDK 13 version
---------------
1. Text Block(preview) but since from JDK 15 version they have made it standard
```
package com.iits;

public class Test9 {
	public static void main(String[] args) {
		String template=""" 
					  First Line,
					  Second Line,
					  Third Line
				
				""";

		System.out.println(template);
	}
	

}
```
---------------------------------------------------------------------------------------
Example2:
--------
- Using with format specifier like %d for integer, %s for string and %f for float value
```
package com.iits;

public class Test9 {
	public static void main(String[] args) {
		String template = """
					Product ID:%d
					Product Name:%s
					Product Price:%.2f
				""";

		String productDetails = template.formatted(1001, "Mobile", 10000.0f);
		System.out.println(productDetails);

	}

}
```
----------------------------------------------------------------------------------------




