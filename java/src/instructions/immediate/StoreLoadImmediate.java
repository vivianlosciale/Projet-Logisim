 package instructions.immediate;

import assembleur.Converter;

public abstract class StoreLoadImmediate {
	public final int MAX_VALUE_IMM8 = 255;
	public final int MAX_VALUE_RT = 7;

	private final int IMM8;
	private final int RT;

	private final int CODE;

	public StoreLoadImmediate(int rt, int imm8, int code) {
		if (rt < 0 || rt > MAX_VALUE_RT)
			throw new IllegalArgumentException("rt: " + rt);
		if (imm8 < 0 || imm8 > MAX_VALUE_IMM8)
			throw new IllegalArgumentException("imm8: " + imm8);

		this.IMM8 = imm8;
		RT = rt;

		CODE = code;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 5) + Converter.integerToBinary(RT, 3) + Converter.integerToBinary(IMM8, 8);
	}
}
