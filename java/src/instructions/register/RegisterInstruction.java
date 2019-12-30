package instructions.register;

import assembleur.Converter;

public abstract class RegisterInstruction {
	public final int MAX_VALUE_RM = 7;
	public final int MAX_VALUE_RDN = 7;

	private final int CODE;

	private final int RM;
	private final int RDN;
	
	public RegisterInstruction(int rm, int rdn, int code) {
		if (rm < 0 || rm > MAX_VALUE_RM)
			throw new IllegalArgumentException("rm: " + rm);
		if (rdn < 0 || rdn > MAX_VALUE_RDN)
			throw new IllegalArgumentException("rdn: " + rdn);
		

		RM = rm;
		RDN = rdn;
		
		CODE = code;
	}
	
	@Override
	public String toString() {
		return Converter.integerToBinary(CODE, 10) + Converter.integerToBinary(RM, 3)
		+ Converter.integerToBinary(RDN, 3);
	}
}
