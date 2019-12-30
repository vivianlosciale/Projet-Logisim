package instructions.immediate;

public class ASR extends ShiftImmediate {

	public ASR(int imm5, int rm, int rd) {
		super(imm5, rm, rd, 2);
	}

}
