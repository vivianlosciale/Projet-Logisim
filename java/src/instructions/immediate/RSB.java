package instructions.immediate;

import assembleur.Converter;

public class RSB {
	private final int MAX_VALUE_RD = 7;
	private final int MAX_VALUE_RN = 7;

	private final int RN;
	private final int RD;

	private final int CODE = 265;

	public RSB(int rn, int rd) {
		if (rd < 0 || rd > MAX_VALUE_RD)
			throw new IllegalArgumentException("rd: " + rd);
		if (rn < 0 || rn > MAX_VALUE_RN)
			throw new IllegalArgumentException("rn: " + rn);

		RN = rn;
		RD = rd;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RN, 3)
				+ Converter.integerToBinary(RD, 3);
	}

}
