package blocks;

public class LongBlock2 extends LongBlock {

	@Override
	public Block TurnRight() {
		return new LongBlock();
	}

	@Override
	public Block TurnLeft() {
		return new LongBlock();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] { { -2, 1 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
	}

	@Override
	public int GetID() {
		return 7;
	}

}
