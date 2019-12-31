package instructions.immediate;

import assembleur.Converter;
import instructions.AddSub;

public abstract class AddSubImmediate extends AddSub {
	public final int MAX_VALUE_IMM3 = 7;
	public final int MAX_VALUE_CODE = 3;
	public final int MIN_VALUE_CODE = 2;

	private final int IMM3;

	public AddSubImmediate(int imm3, int rn, int rd, int code) {
		super(rn, rd, code);
		if (code < 0 || code > MAX_VALUE_CODE || code < MIN_VALUE_CODE)
			throw new IllegalArgumentException("code: " + code);
		if (imm3 < 0 || imm3 > MAX_VALUE_IMM3)
			throw new IllegalArgumentException("imm3: " + imm3);

		IMM3 = imm3;
	}
	
	@Override
	public String toString() {
		return Converter.integerToBinary(code, 5) + Converter.integerToBinary(IMM3, 3) + Converter.integerToBinary(RN, 3)
				+ Converter.integerToBinary(RD, 3);
	}
}
