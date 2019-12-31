package instructions.immediate;

import assembleur.Converter;

public class AddSubSPImmediate {
	public final int MAX_VALUE_IMM7 = 127;

	private final int IMM7;

	private final int CODE;

	public AddSubSPImmediate(int imm7, int code) {
		if (imm7 < 0 || imm7 > MAX_VALUE_IMM7)
			throw new IllegalArgumentException("imm7: " + imm7);

		this.IMM7 = imm7;

		CODE = code;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 9) + Converter.integerToBinary(IMM7, 7);
	}
}
