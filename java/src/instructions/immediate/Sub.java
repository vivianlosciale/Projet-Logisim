package instructions.immediate;

public class Sub extends AddSubImmediate {
	public Sub(int imm3, int rn, int rd) {
		super(imm3, rn, rd, 3);
	}
}
