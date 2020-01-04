package assembleur;


import instructions.immediate.ADDSP;
import instructions.immediate.LDR;
import instructions.immediate.LSL;
import instructions.immediate.MOV;
import instructions.immediate.STR;
import instructions.immediate.SUBSP;
import instructions.register.ADD;
import instructions.register.CMP;
import instructions.register.MUL;
import instructions.register.SUB;

public class CreateIns {

	public Object create(String line) {
		if (!line.startsWith("	")) {
			return null;
		}
		line = line.substring(1, line.length());
		if (line.startsWith("b") && !line.equals("bics"))
			return b(line);
		switch (line.split("	")[0]) {
		case "sub":
			return sub(line.substring(4, line.length()));
		case "subs":
			return subs(line.substring(5, line.length()));
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
		case "lsls":
			return lsls(line.substring(5, line.length()));
		case "mul":
			return mul(line.substring(4, line.length()));
		case "muls":
			return muls(line.substring(5, line.length()));
		default:
			System.out.println(line);
			return null;
		}
	}

	private Object lsls(String phrase) {
		int rm=Integer.parseInt(phrase.split(",")[1].substring(2));;
		int rdn=Integer.parseInt(phrase.split(",")[0].substring(1));;
		return new instructions.register.LSL(rm, rdn);
	}

	private Object muls(String phrase) {
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		int rdm = Integer.parseInt(phrase.split(",")[0].substring(1));
		return new MUL(rn, rdm);
	}

	private Object subs(String phrase) {
		int rd = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		int rm = Integer.parseInt(phrase.split(",")[2].substring(2));
		System.out.println(new SUB(1, 0, 0).toString()+"----------------");
		return new SUB(rm, rn, rd);
	}

	private Object b(String phrase) {
		System.out.println("b");
		return null;
	}

	private Object mul(String phrase) {
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		int rdm = Integer.parseInt(phrase.split(",")[0].substring(1));
		return new MUL(rn, rdm);
	}

	private Object lsl(String phrase) {
		int rd = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rm = Integer.parseInt(phrase.split(",")[1].substring(2));
		int imm5 = Integer.parseInt(phrase.split(",")[2].substring(2));
		return new LSL(imm5, rm, rd);
	}

	private Object cmp(String phrase) {
		int rn = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rm = Integer.parseInt(phrase.split(",")[1].substring(2));
		return new CMP(rm, rn);
	}

	private static Object mov(String phrase) {
		System.out.println("mov");
		return null;
	}

	private Object adds(String phrase) {
		int rd = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		int rm = Integer.parseInt(phrase.split(",")[2].substring(2));
		return new ADD(rm, rn, rd);
	}

	private Object str(String phrase) {
		int rd = Integer.parseInt(phrase.substring(1, 2));
		if (phrase.contains("#")) {
			int imm8 = Integer.parseInt(phrase.split("#")[1].split("]")[0]);
			return new STR(rd, imm8);
		}
		return new STR(rd, 0);
	}

	private Object movs(String phrase) {
		int rd = Integer.parseInt(phrase.split(",")[0].substring(1));
		int imm8 = Integer.parseInt(phrase.substring(5, 6));
		return new MOV(rd, imm8);
	}

	private Object ldr(String phrase) {
		int rd = Integer.parseInt(phrase.substring(1, 2));
		if (phrase.contains("#")) {
			int imm8 = Integer.parseInt(phrase.split("#")[1].split("]")[0]);
			return new LDR(rd, imm8);
		}
		return new LDR(rd, 0);
	}

	private Object add(String phrase) {
		int rd = Integer.parseInt(phrase.split("#")[1]);
		return new ADDSP(rd);
	}

	private Object sub(String phrase) {
		int rd = Integer.parseInt(phrase.split("#")[1]);
		return new SUBSP(rd);
	}
}
