package blocks;

import java.awt.Color;

public class LongBlock extends Block {

	@Override
	public Block TurnRight() {
		return new LongBlock2();
	}

	@Override
	public Block TurnLeft() {
		// TODO Auto-generated method stub
		return new LongBlock2();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
	}

	@Override
	public Color GetColor() {
		return Color.BLUE;
	}

	@Override
	public int GetID() {
		return 6;
	}

}
