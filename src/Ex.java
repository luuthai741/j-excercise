import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

public class Ex {

	public static void ex2(String name) {
		System.out.println("Hello " + name);
	}

	public static void ex3(String name) {
		if (name.equals("Alice") || name.equals("Bob")) {
			System.out.println("Hello " + name);
		} else {
			System.out.println("Get out");
		}
	}

	public static void ex4(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("Sum from 1 to " + n + " : " + sum);
	}

	public static void ex5(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sb.append(i + " ");
			}
		}
		sb.append(".");
		System.out.println(sb.toString());
	}

	public static void ex6(int A) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("User B plz enter you value: ");
		int B = scanner.nextInt();
		int count = 1;
		while (B != A) {
			if (B > A)
				System.out.println("Your value larger than user A");
			if (B < A)
				System.out.println("Your value smaller than user A");
			System.out.println("Enter you value against: ");
			B = scanner.nextInt();
			++count;
		}

		System.out.println("Value is " + B + " and guesses time is :" + count);
	}

	public static void ex7(String input) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(input);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			for(int j=i+1;j<sb.length();j++) {
				if(sb.charAt(j)<sb.charAt(i)) {
					char swap = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(j));
					sb.setCharAt(j, swap);
				}
			}
			result.append(sb.charAt(i));
		}
		System.out.println(result.toString());
	}

	public static void ex9(String input) {
		int year = 0;
		if (input.isEmpty() || input.isBlank()) {
			year = Calendar.getInstance().get(Calendar.YEAR);
		} else {
			year = Integer.valueOf(input);
		}
		int result = year + 20;
		System.out.println("The next 20 leap year: " + result);
	}

	public static void ex10(float a, float b, float c) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("No solution");
			} else {
				float result = -c / b;
				System.out.println("x= " + result);
			}
		}

		float delta = b * b - 4 * a * c;
		float x1, x2;
		if (delta > 0) {
			x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
			x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));

			System.out.println("x1 = " + x1 + " x2 = " + x2);
		}
		if (delta == 0) {
			x1 = (-b / (2 * a));
			System.out.println("x1 = x2 = " + x1);
		}
		if (delta < 0) {
			System.out.println("No solution");
		}
	}
}
