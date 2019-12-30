package instructions.immediate;

import assembleur.Converter;

/**
 * Classe représentant une instruction Shift
 * 
 * @author Thomas
 *
 */
public abstract class ShiftImmediate {
	public final int MAX_VALUE_IMM5 = 31;
	public final int MAX_VALUE_RM = 7;
	public final int MAX_VALUE_RD = 7;
	public final int MAX_VALUE_CODE = 2;

	private final int IMM5;
	private final int RM;
	private final int RD;

	private final String CODE;

	protected ShiftImmediate(int imm5, int rm, int rd, int code) {
		if (imm5 < 0 || imm5 > MAX_VALUE_IMM5)
			throw new IllegalArgumentException("imm5: " + imm5);
		if (rm < 0 || rm > MAX_VALUE_RM)
			throw new IllegalArgumentException("rm: " + rm);
		if (rd < 0 || rd > MAX_VALUE_RD)
			throw new IllegalArgumentException("rd: " + rd);
		if (code < 0 || code > MAX_VALUE_CODE)
			throw new IllegalArgumentException("code: " + code);

		this.IMM5 = imm5;
		this.RM = rm;
		this.RD = rd;

		CODE = Converter.integerToBinary(code, 5);
	}

	@Override
	public String toString() {
		return CODE + Converter.integerToBinary(IMM5, 5) + Converter.integerToBinary(RM, 3)
				+ Converter.integerToBinary(RD, 3);
	}
}
