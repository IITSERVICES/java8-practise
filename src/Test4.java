import java.util.function.BiFunction;

public class Test4 {
	public static void main(String[] args) {
		 BiFunction<String, String, String>
		 b=(arg1,arg2)->arg1.concat(arg2);
		 
		 String firstName="Raju ";
		 String lastName="Kumar";
		 
		 String fullName=b.apply(firstName, lastName);
		 System.out.println(fullName);
	}

}
