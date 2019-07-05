package blocks;

public class LBlock2 extends LBlock {

	@Override
	public Block TurnRight() {
		return new LBlock3();
	}

	@Override
	public Block TurnLeft() {
		return new LBlock();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { -1, 1 } };
	}

	@Override
	public int GetID() {
		return 2;
	}

}
