package blocks;

public class TBlock2 extends TBlock {

	@Override
	public Block TurnRight() {
		return new TBlock3();
	}

	@Override
	public Block TurnLeft() {
		return new TBlock();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{-1,0},{0,0},{0,1},{1,0}};
	}

	@Override
	public int GetID() {
		return 9;
	}

}
