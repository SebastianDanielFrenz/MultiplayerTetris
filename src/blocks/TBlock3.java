package blocks;

public class TBlock3 extends TBlock {

	@Override
	public Block TurnRight() {
		return new TBlock4();
	}

	@Override
	public Block TurnLeft() {
		return new TBlock2();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{0,0},{0,1},{-1,1},{0,2}};
	}

	@Override
	public int GetID() {
		return 10;
	}

}
