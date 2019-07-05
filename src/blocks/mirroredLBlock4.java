package blocks;

public class mirroredLBlock4 extends mirroredLBlock {

	@Override
	public Block TurnRight() {
		return new mirroredLBlock();
	}

	@Override
	public Block TurnLeft() {
		return new mirroredLBlock3();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{ 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 }};
	}

	@Override
	public int GetID() {
		return 15;
	}

}
