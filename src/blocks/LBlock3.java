package blocks;

public class LBlock3 extends LBlock {

	@Override
	public Block TurnRight() {
		return new LBlock4();
	}

	@Override
	public Block TurnLeft() {
		return new LBlock2();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
	}

	@Override
	public int GetID() {
		return 3;
	}

}
