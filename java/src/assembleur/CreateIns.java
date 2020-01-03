package assembleur;

import instructions.immediate.ADD;
import instructions.immediate.ADDSP;
import instructions.immediate.LDR;
import instructions.immediate.LSL;
import instructions.immediate.MOV;
import instructions.immediate.STR;
import instructions.immediate.SUBSP;
import instructions.register.CMP;
import instructions.register.MUL;

public class CreateIns {

	public Object create(String line) {
		if (!line.startsWith("	")) {
			return null;
		}
		line = line.substring(1, line.length());
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
			return b(line);
		case "blt":
			return blt(line);
		case "bne":
			return bne(line);
		default:
			return null;
		}
	}

	private Object bne(String phrase) {
		throw new NullPointerException("une des instructions ne peut pas etre traduite:"+phrase);
	}

	private Object blt(String phrase) {
		throw new NullPointerException("une des instructions ne peut pas etre traduite:"+phrase);
	}

	private Object b(String phrase) {
		throw new NullPointerException("une des instructions ne peut pas etre traduite:"+phrase);
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
		int rm = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		return new CMP(rm, rn);
	}

	private static Object mov(String phrase) {
		// System.out.println("mov");
		return null;
	}

	private Object adds(String phrase) {
		int rd = Integer.parseInt(phrase.split(",")[0].substring(1));
		int rn = Integer.parseInt(phrase.split(",")[1].substring(2));
		int imm3 = Integer.parseInt(phrase.split(",")[2].substring(2));
		return new ADD(imm3, rn, rd);
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
