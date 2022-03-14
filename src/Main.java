import java.io.IOException;
import java.time.LocalTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		//EX1
//		List<String> string = List.of("Hello", "Goodbye", "Hi", "Good morning", "Burh", "Z");
//		List<Integer> listNumber = new ArrayList<>();
//		String s = "abba";
//		listNumber.add(123123);
//		listNumber.add(9999);
//		listNumber.add(22);
//		listNumber.add(454);
//		listNumber.add(1);j
		
		//EX2
		Ex2<Integer> ex2 = new Ex2<Integer>();
//		System.out.println(ex2.findMaxIndex(listNumber));
//		ex2.reverse(listNumber).forEach(System.out::println);
//		System.out.println(ex2.checkElementOccurs(listNumber, 1));
//		ex2.oddPositions(listNumber).forEach(System.out::println);
//		ex2.runningTotal(listNumber).forEach(System.out::println);
//		System.out.println(ex2.palindrome(s));

//		System.out.println(ex2.sumRecursion(listNumber));
//		ex2.perfectSquare(100).forEach(System.out::println);
//		ex2.concat(string, listNumber).forEach(System.out::println);

		//EX3
		Ex3 ex3 = new Ex3();
//		ex3.createFile("Hello", "LMAO");
//		ex3.readFile("C:\\Users\\Thai Luu\\Desktop\\JavaTesting\\Ex\\files\\Hello.txt");
		ex3.classmateProgram();
	}
}
