import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Ex4 {
	public static class Student {
		private int id;
		private String name;
		private LocalDate birth;
		private String className;

		public Student(int id, String name, LocalDate birth, String className) {
			this.id = id;
			this.name = name;
			this.birth = birth;
			this.className = className;
		}

		public Student() {
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

		public LocalDate getBirth() {
			return birth;
		}

		public void setBirth(LocalDate birth) {
			this.birth = birth;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("id: " + id);
			sb.append(" name: " + name);
			sb.append(" birth: " + birth);
			sb.append(" class name: " + className + ";");
			return sb.toString();
		}

	}

	public void storeStudentProgram() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1-Student list");
		System.out.println("2-Add student");
		System.out.println("3-Remove student");
		System.out.println("4-Search student");
		System.out.println("5-Exit");
		handleStudent();
	}

	private void handleStudent() {
		List<Student> studentList = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		while (input < 5) {
			switch (input) {
			case 1: {
				if (studentList.size() == 0)
					System.out.println("Student list is empty");
				else {
					studentList.forEach(s -> System.out.println(s.toString()));
				}
				break;
			}
			case 2:
				try {
					System.out.println("Enter student id: ");
					int id = scanner.nextInt();
					System.out.println("Enter student name");
					String name = scanner.next();
					System.out.println("Enter student birth (dd/MM/yyy)");
					String birthStr = scanner.next();
					DateTimeFormatter dateFomatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
					LocalDate birthDate = LocalDate.parse(birthStr, dateFomatter);
					System.out.println("Enter you class name");
					String className = scanner.next();
					studentList.add(new Student(id, name, birthDate, className));
				} catch (Exception e) {
					System.out.println("Opps! Something wrong");
				}
				break;
			case 3:
				if (studentList.size() == 0)
					System.out.println("The student list is empty");
				else {
					System.out.println("Enter student name to delete: ");
					studentList.stream().filter(s -> !s.getName().equals(scanner.nextLine()));
				}
				break;
			case 4:
				if (studentList.size() == 0)
					System.out.println("The student list is empty");
				else {
					System.out.println("Enter student name to delete: ");
					Optional<Student> student = studentList.stream().filter(s -> s.getName().equals(scanner.nextLine()))
							.findAny();
					if (!student.isPresent())
						System.out.println("No student in list");
					else {
						student.get().toString();
					}
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + input);
			}

			input = scanner.nextInt();
		}
	}

	public static class MathUtils {
		public static int sum(int n) {
			if (n <= 1)
				return n;
			else
				return n + sum(n - 1);
		}

		public static void quadraticEquations(int a, int b, int c) {
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

		public static double cicle(double r) {
			return Math.PI * r * r;
		}
		
		public static double rectangle(double h, double w) {
			return h*w;
		}
		
		public static double triangle(double h, double b) {
			return (h*b)/2;
		}
		
		public static double pentagon(double h, double b) {
			return 5*(h*b)/2;
		}
	}
}
