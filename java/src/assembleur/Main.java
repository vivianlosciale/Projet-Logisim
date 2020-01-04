package assembleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import instructions.register.ADD;
import instructions.register.CMP;
import instructions.register.SUB;

public class Main {
	public static void main(String[] args) {
		String result = "v2.0 raw" + System.getProperty("line.separator");
		System.out.println(Converter.binaryToHexa(new CMP(1, 0).toString()));
		System.out.println("-----");
		List<Object> l = new ArrayList<Object>();
		CreateIns c = new CreateIns();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.startsWith("	@") && !line.startsWith("	.") && !line.startsWith("	bx")) {
				Object code = c.create(line);
				if (code != null) {
					System.out.println(Converter.binaryToHexa(code.toString()));
					l.add(Converter.binaryToHexa(code.toString()));
				}
			}
		}
		for (Object object : l) {
			result += object.toString() + " ";
		}
		System.out.println(result);
	}
}
