package instructions.register;

import assembleur.Converter;

public class TST {
	private final int MAX_VALUE_RM = 7;
	private final int MAX_VALUE_RN = 7;

	private final int RM;
	private final int RN;

	private final int CODE = 264;

	public TST(int rm, int rn) {
		if (rm < 0 || rm > MAX_VALUE_RM)
			throw new IllegalArgumentException("rm: " + rm);
		if (rn < 0 || rn > MAX_VALUE_RN)
			throw new IllegalArgumentException("rn: " + rn);

		RM = rm;
		RN = rn;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RM, 3)
				+ Converter.integerToBinary(RN, 3);
	}
}
