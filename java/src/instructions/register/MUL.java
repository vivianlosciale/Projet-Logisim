package instructions.register;

import assembleur.Converter;

public class MUL {
	
	private final int MAX_VALUE_RN = 7;
	private final int MAX_VALUE_RDM = 7;

	private final int RN;
	private final int RDM;

	private final int CODE = 269;

	protected MUL(int rn, int rdm) {
		if (rdm < 0 || rdm > MAX_VALUE_RDM) {
			throw new IllegalArgumentException();
		}
		if (rn < 0 || rn > MAX_VALUE_RN) {
			throw new IllegalArgumentException();
		}

		RDM = rdm;
		RN = rn;
	}

	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RN, 3)
				+ Converter.integerToBinary(RDM, 3);
	}
	
}
