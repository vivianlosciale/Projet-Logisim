package instructions.immediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import assembleur.Converter;

public class B {
	private final int MAX_VALUE_COND = 15;
	private final int MAX_VALUE_IMM8 = 255;

	public static final List<String> SYMBOLES = Collections.unmodifiableList(
			Arrays.asList("EQ", "NE", "CS", "CC", "MI", "PL", "VS", "VC", "HI", "LS", "GE", "LT", "GT", "LE", "AL"));

	private final int COND;
	private final int IMM8;

	private final int CODE = 13;

	public B(int cond, int imm8) {
		if (cond < 0 || cond > MAX_VALUE_COND)
			throw new IllegalArgumentException("cond: " + cond);
		if (imm8 < 0 || imm8 > MAX_VALUE_IMM8)
			throw new IllegalArgumentException("imm8: " + imm8);

		COND = cond;
		IMM8 = imm8;
	}

	public B(String cond, int imm8) {
		this(getCodeFromString(cond), imm8);
	}
	
	public static int getCodeFromString(String cond) {
		if(cond.isBlank()) return SYMBOLES.indexOf("AL");
		if(SYMBOLES.contains(cond)) return SYMBOLES.indexOf(cond);
		return -1;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 4) + Converter.integerToBinary(COND, 4)
				+ Converter.integerToBinary(IMM8, 8);
	}
}
