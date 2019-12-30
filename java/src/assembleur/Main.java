package assembleur;

import instructions.immediate.LSR;

public class Main {
	public static void main(String[] args) {
		LSR lsr = new LSR(4, 3, 5);
		System.out.println(lsr);
		System.out.println(Converter.binaryToHexa(lsr.toString()));
	}
}