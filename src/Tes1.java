import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Tes1 {
	public static void main(String[] args) throws InterruptedException {
		// List<String> list = List.of("laptop", "ram", "keyboard", "mouse", "ssd");
		// System.out.println(list);
		// task1(list);
		// task2();
		// task3();//write a java to print all even number from the list
		// task4();//Write a java program to print all product names in upper case
		task5();// Write a java program to print all sorted element on the console.
	}

	private static void task5() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);

		Collections.sort(list);
		System.out.println(list);

	}

	private static void task4() {
		// 1. Source
		List<String> list = List.of("laptop", "ram", "keyboard", "mouse", "ssd", "laptop");

		list.stream() // 2. Get the Stream object
				.distinct().map((item) -> item.toUpperCase()) // 3. Configuration
				.forEach((item) -> System.out.println(item));// 4. Processing

	}

	private static void task3() {
		// 1. Source
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/*
		 * //2. Get the Stream Object Stream<Integer> stream=list.stream();
		 * System.out.println(stream); //3. Configuration (filter) Stream<Integer>
		 * s=stream.filter((num)-> num%2==0); //4. Processing(forEach)
		 * s.forEach((num)->System.out.println(num));
		 */

		List<Integer> evenList = list.stream() // 2. Get the Stream Object
				.filter((num) -> num % 2 == 0) // 3. Configuration
				// .forEach((num)->System.out.println(num));//4. Processsing
				.collect(Collectors.toList());

		System.out.println(evenList);
	}

	private static void task2() throws InterruptedException {
		Supplier<Integer> supplier = () -> {
			// Write the code to generate the some random values
			Random r = new Random();
			int randomeValue = r.nextInt() * 10;
			return randomeValue;
		};

		for (int i = 1; i <= 5; i++) {
			System.out.println(supplier.get());
			Thread.sleep(2000);

		}

	}

	private static void task1(List<String> list) {
		Function<String, String> function = (input) -> input.toUpperCase();

		/*
		 * Consumer<String> consumer = (item) -> { String converted =
		 * function.apply(item); System.out.println(converted); };
		 */
		// Consumer<String> consumer = (item)
		// ->System.out.println(function.apply(item));
		// list.forEach((item)->System.out.println(function.apply(item)));

		list.forEach((item) -> System.out.println(function.apply(item)));
	}

}
