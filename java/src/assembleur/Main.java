package assembleur;

import java.util.Scanner;

import instructions.immediate.ADDSP;
import instructions.immediate.LDR;
import instructions.immediate.MOV;
import instructions.immediate.STR;
import instructions.immediate.SUBSP;


public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line =sc.nextLine();
			if(!line.startsWith("	@") &&!line.startsWith("	.")&&!line.startsWith("	bx")) {
				Object code = create(line);
				if(code!=null)
					System.out.println(Converter.binaryToHexa(code.toString()));
			}
		}
	}

	private static Object create(String line) {
		if(!line.startsWith("	")) {
			return null;
		}
		line=line.substring(1, line.length());
		switch (line.split("	")[0]) {
		case "sub":
			return sub(line.substring(4, line.length()));
		case "movs":
			return movs(line.substring(5, line.length()));
		case "str":
			return str(line.substring(4, line.length()));
		case "ldr":
			return ldr(line.substring(4, line.length()));
		case "adds":
			return adds(line.substring(5, line.length()));
		case "add":
			return add(line.substring(4, line.length()));
		case "mov":
			return mov(line.substring(4, line.length()));
		case "cmp":
			return cmp(line.substring(4, line.length()));
		case "lsl":
			return lsl(line.substring(4, line.length()));
		case "mul":
			return mul(line.substring(4, line.length()));
		case "b":
			return b(line.substring(2, line.length()));
		case "blt":
			return blt(line.substring(4, line.length()));
		case "bne":
			return bne(line.substring(4, line.length()));
		default:
			System.out.println("rip:"+line.split("	")[0]);
			return null;
		}
	}

	private static Object bne(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object blt(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object b(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object mul(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object lsl(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object cmp(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object mov(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object adds(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object str(String phrase) {
		int rd=Integer.parseInt(phrase.substring(1, 2));
		if(phrase.contains("#")) {
			int imm8=Integer.parseInt(phrase.split("#")[1].split("]")[0]);
			return new STR(rd, imm8);
		}
		return new STR(rd, 0);
	}

	private static Object movs(String phrase) {
		int rd=Integer.parseInt(phrase.substring(1, 2));
		int imm8=Integer.parseInt(phrase.substring(5, 6));
		return new MOV(rd, imm8);
	}

	private static Object ldr(String phrase) {
		int rd=Integer.parseInt(phrase.substring(1, 2));
		if(phrase.contains("#")) {
			int imm8=Integer.parseInt(phrase.split("#")[1].split("]")[0]);
			return new LDR(rd, imm8);
		}
		return new LDR(rd, 0);
	}

	private static Object add(String phrase) {
		int rd=Integer.parseInt(phrase.split("#")[1]);
		return new ADDSP(rd);
	}

	private static Object sub(String phrase) {
		int rd=Integer.parseInt(phrase.split("#")[1]);
		return new SUBSP(rd);
	}
}