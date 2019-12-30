package instructions.register;

import assembleur.Converter;

public class MVN {
	private final int MAX_VALUE_RM = 7;
	private final int MAX_VALUE_RD = 7;

	private final int RM;
	private final int RD;

	private final int CODE = 271;

	protected MVN (int rm, int rd) {
		if (rm < 0 || rm > MAX_VALUE_RM) {
			throw new IllegalArgumentException();
		}
		if (rd < 0 || rd > MAX_VALUE_RD) {
			throw new IllegalArgumentException();
		}

		RM = rm;
		RD = rd;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RM, 3)
				+ Converter.integerToBinary(RD, 3);
	}
}
