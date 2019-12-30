package instructions.register;

import assembleur.Converter;
import instructions.AddSub;

public abstract class AddSubRegister extends AddSub {
	public final int MAX_VALUE_RM = 7;
	public final int MAX_VALUE_CODE = 2;

	private final int RM;

	protected AddSubRegister(int rm, int rn, int rd, int code) {
		super(rn, rd, code);
		if (code < 0 || code > MAX_VALUE_CODE)
			throw new IllegalArgumentException("code: " + code);
		if (rm < 0 || rm > MAX_VALUE_RM)
			throw new IllegalArgumentException("rm: " + rm);

		RM = rm;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(code, 5) + Converter.integerToBinary(RM, 3) + Converter.integerToBinary(RN, 3)
				+ Converter.integerToBinary(RD, 3);
	}
}
