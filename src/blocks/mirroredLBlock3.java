package blocks;

public class mirroredLBlock3 extends mirroredLBlock {

	@Override
	public Block TurnRight() {
		return new mirroredLBlock4();
	}

	@Override
	public Block TurnLeft() {
		return new mirroredLBlock2();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{ 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }};
	}

	@Override
	public int GetID() {
		return 14;
	}

}
