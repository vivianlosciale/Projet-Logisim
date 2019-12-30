package instructions.immediate;

/**
 * 
 * @author Thomas
 *
 */
public class LSL extends ShiftImmediate {
	public LSL(int imm5, int rm, int rd) {
		super(imm5, rm, rd, 0);
	}
}
