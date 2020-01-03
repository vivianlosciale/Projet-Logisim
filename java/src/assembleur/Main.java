package assembleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String result = "v2.0 raw" + System.getProperty("line.separator");
		List<Object> l = new ArrayList<Object>();
		CreateIns c = new CreateIns();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.startsWith("	@") && !line.startsWith("	.") && !line.startsWith("	bx")) {
				Object code = c.create(line);
				if (code != null)
					l.add(Converter.binaryToHexa(code.toString()));
			}
		}
		for (Object object : l) {
			result += object.toString() + " ";
		}
		System.out.println(result);
	}
}
