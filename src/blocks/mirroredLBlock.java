package blocks;

import java.awt.Color;

public class mirroredLBlock extends Block {

	@Override
	public Block TurnRight() {
		return new mirroredLBlock2();
	}

	@Override
	public Block TurnLeft() {
		return new mirroredLBlock4();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{ 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 }};
	}

	@Override
	public Color GetColor() {
		return Color.magenta;
	}

	@Override
	public int GetID() {
		return 12;
	}

}
