package blocks;

public class LBlock4 extends LBlock {

	@Override
	public Block TurnRight() {
		return new LBlock();
	}

	@Override
	public Block TurnLeft() {
		return new LBlock3();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
	}

	@Override
	public int GetID() {
		return 4;
	}

}
