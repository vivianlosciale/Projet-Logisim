package instructions.immediate;

import assembleur.Converter;

public class MOV {
	public final int MAX_VALUE_RD = 7;
	public final int MAX_VALUE_IMM8 = 255;

	private final int CODE = 4;

	private final int RD;
	private final int IMM8;

	public MOV(int rd, int imm8) {
		if (imm8 < 0 || imm8 > MAX_VALUE_IMM8)
			throw new IllegalArgumentException("imm8: " + imm8);
		if (rd < 0 || rd > MAX_VALUE_RD)
			throw new IllegalArgumentException("rd: " + rd);

		RD = rd;
		IMM8 = imm8;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 5) + Converter.integerToBinary(RD, 3)
				+ Converter.integerToBinary(IMM8, 8);

	}
}
