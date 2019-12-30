package instructions.immediate;

public class ADD extends AddSubImmediate{
	public ADD(int imm3, int rn, int rd) {
		super(imm3, rn, rd, 2);
	}
}
