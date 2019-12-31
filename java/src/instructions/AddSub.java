package instructions;

public abstract class AddSub {
	public final int MAX_VALUE_RN = 7;
	public final int MAX_VALUE_RD = 7;
	public final int MAX_VALUE_CODE = 3;

	protected final int RN;
	protected final int RD;

	protected int code = 12;
	
	public AddSub(int rn, int rd, int code) {
		if (rn < 0 || rn > MAX_VALUE_RN)
			throw new IllegalArgumentException("rn: " + rn);
		if (rd < 0 || rd > MAX_VALUE_RD)
			throw new IllegalArgumentException("rd: " + rd);
		if (code < 0 || code > MAX_VALUE_CODE)
			throw new IllegalArgumentException("code: " + code);
		
		RN = rn;
		RD = rd;
		
		code+=code;
	}
}
