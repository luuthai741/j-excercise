import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Ex3 {
	public void createFile(String filename, String content) {
		FileOutputStream fos = null;
		String filePath = System.getProperty("user.dir") + "\\files\\" + filename + ".txt";
		File file = new File(filePath);
		byte[] bytes = content.getBytes();
		try {
			fos = new FileOutputStream(file);
			fos.write(bytes);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fos.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public void readFile(String path) {
		File file = new File(path);
		if (!file.canRead()) {
			System.out.println("Cannot find file with path " + path);
			return;
		}
		FileInputStream fis = null;
		BufferedReader bufferedReader = null;
		try {
			fis = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				fis.close();
				bufferedReader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void showSelect() {
		System.out.println("Choose your choice");
		System.out.println("1. Add classmate");
		System.out.println("2. Classmate list");
		System.out.println("3. Write CSV file");
		System.out.println("4. Read CSV file");
		System.out.println("5. Exit");
	}

	public void classmateProgram() {
		Scanner scanner = new Scanner(System.in);
		showSelect();
		int input = scanner.nextInt();
		List<Classmate> classmateList = new ArrayList<Classmate>();
		String filePath = System.getProperty("user.dir") + "\\files\\classmate.csv";
		File file = new File(filePath);
		
		try {
			FileReader fileReader = new FileReader(file);
			CSVReader reader = new CSVReader(fileReader);
			List<String[]> list = reader.readAll();
			for(int i=1;i<list.size();i++) {
				String[] arrStr = list.get(i);
				classmateList.add(new Classmate(arrStr[0], arrStr[1], arrStr[2]));
			}
			fileReader.close();
			reader.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		};
		
		while (input < 5) {
			switch (input) {
			case 1: {
				System.out.println("Enter classmate name: ");
				String name = validateName(scanner);
				System.out.println("Enter classmate email: ");
				String email = validateEmail(scanner);
				System.out.println("Enter classmate birth by format dd/MM/yyyy: ");
				String birth = validateDate(scanner);
				classmateList.add(new Classmate(name, email, birth));
				break;
			}
			case 2: {
				classmateList.forEach(c -> System.out.println(c.toString()));
				break;
			}
			case 3: {
				List<String[]> list = new ArrayList<String[]>();
				String[] header = { "Name", "Email", "Birth" };
				list.add(header);
				for (Classmate classmate : classmateList) {
					String[] arrStr = { classmate.getName(), classmate.getEmail(), classmate.getBirthDay() };
					list.add(arrStr);
				}
				try {
					FileWriter outputfile = new FileWriter(file);
					CSVWriter writer = new CSVWriter(outputfile);
					writer.writeAll(list);
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				
				try {
					FileReader fileReader = new FileReader(file);
					CSVReader reader = new CSVReader(fileReader);
					List<String[]> list = reader.readAll();
					list.forEach(arrStr -> {
						System.out.print("| ");
						for (String string : arrStr) {
							System.out.print("| " + string);
						}
						System.out.println();
					});
					fileReader.close();
					reader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + input);
			}
			showSelect();
			input = scanner.nextInt();
		}
	}

	public static class Classmate implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;
		private String email;
		private String birthDay;

		public Classmate(String name, String email, String birthDay) {
			this.name = name;
			this.email = email;
			this.birthDay = birthDay;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBirthDay() {
			return birthDay;
		}

		public void setBirthDay(String birthDay) {
			this.birthDay = birthDay;
		}

		@Override
		public String toString() {
			return "Classmate [name=" + name + ", email=" + email + ", birthDay=" + birthDay + "]";
		}

	}

	private String validateName(Scanner scanner) {
		String name = null;
		while (true) {
			name = scanner.next();
			if (name.length() < 8) {
				System.out.println("Your name to short. Please try agaisnt!");
				continue;
			}
			if (name.length() > 30) {
				System.out.println("Your name to long. Please try against!");
				continue;
			} else {
				break;
			}
		}
		return name;
	}
	
	private String validateEmail(Scanner scanner) {
		String email = null;
		Pattern p = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");		
		while (true) {
			email = scanner.next();
			Matcher m = p.matcher(email);
			if(!m.matches()) {
				System.out.println("Your email not valid. Enter your email agaisnt!");
				continue;
			}else {
				break;
			}
		}
		return email;
	}
	
	private String validateDate(Scanner scanner) {
		String date = null;
		Pattern p = Pattern.compile("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
		while (true) {
			date = scanner.next();
			Matcher m = p.matcher(date);
			if(!m.matches()) {
				System.out.println("Your email not valid");
				continue;
			}else {
				break;
			}
		}
		return date;
	}
}
