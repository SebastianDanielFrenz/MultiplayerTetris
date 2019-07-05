package blocks;

public class mirroredLBlock2 extends mirroredLBlock {

	@Override
	public Block TurnRight() {
		return new mirroredLBlock3();
	}

	@Override
	public Block TurnLeft() {
		return new mirroredLBlock();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{ 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 }};
	}

	@Override
	public int GetID() {
		return 13;
	}

}
