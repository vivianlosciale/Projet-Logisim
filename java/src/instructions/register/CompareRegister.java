package instructions.register;

import assembleur.Converter;

public abstract class CompareRegister {
	private final int MAX_VALUE_RM = 7;
	private final int MAX_VALUE_RN = 7;

	private final int RM;
	private final int RN;

	private final int CODE;

	protected CompareRegister(int rm, int rn, int code) {
		if (rm < 0 || rm > MAX_VALUE_RM) {
			throw new IllegalArgumentException();
		}
		if (rn < 0 || rn > MAX_VALUE_RN) {
			throw new IllegalArgumentException();
		}

		RM = rm;
		RN = rn;

		CODE = code;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RM, 3)
				+ Converter.integerToBinary(RN, 3);
	}
}
