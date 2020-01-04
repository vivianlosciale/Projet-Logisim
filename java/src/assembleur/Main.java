package assembleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int pos=0;
		String result = "v2.0 raw" + System.getProperty("line.separator");
		List<Object> l = new ArrayList<Object>();
		List<String> register= new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			register.add(line);
		}
		CreateIns c = new CreateIns(register);
		for (String line : register) {
			if (!line.startsWith("	@") && !line.startsWith("	.") && !line.startsWith("	bx")) {
				Object code = c.create(line,pos);
				if (code != null) {
					l.add(Converter.binaryToHexa(code.toString()));
				}
			}
			pos++;
		}

		for (Object object : l) {
			result += object.toString() + " ";
		}
		System.out.println(result);
	}
}
