package blocks;

public class TBlock4 extends TBlock {

	@Override
	public Block TurnRight() {
		// TODO Auto-generated method stub
		return new TBlock();
	}

	@Override
	public Block TurnLeft() {
		// TODO Auto-generated method stub
		return new TBlock3();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{-1,0},{0,0},{0,-1},{1,0}};
	}

	@Override
	public int GetID() {
		return 11;
	}

}
