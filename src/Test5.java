import java.util.function.IntBinaryOperator;
@FunctionalInterface
interface Operation1{
	int add(int a,int b);
}
class CalcOperation{
	public static int add(int a,int b) {
		return a+b;
	}
}
public class Test5 {
	public static void main(String[] args) {
		
		IntBinaryOperator i=CalcOperation::add;
		
		int sum=i.applyAsInt(10, 20);
		System.out.println(sum);
		 
	}

	
}
