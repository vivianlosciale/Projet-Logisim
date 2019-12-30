package instructions.immediate;

/**
 * 
 * @author Thomas
 *
 */
public class LSR extends ShiftImmediate {
	public LSR(int imm5, int rm, int rd) {
		super(imm5, rm, rd, 1);
	}
}
