package instructions.immediate;

public class LDR extends StoreLoadImmediate{

	public LDR(int rt, int imm8) {
		super(rt, imm8, 19);
	}
}
