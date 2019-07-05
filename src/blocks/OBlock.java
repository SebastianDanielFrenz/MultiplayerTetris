package blocks;

import java.awt.Color;

public class OBlock extends Block {

	@Override
	public Block TurnRight() {
		return new OBlock();
	}

	@Override
	public Block TurnLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] GetFallingBlocks() {
		// TODO Auto-generated method stub
		return new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	}

	@Override
	public Color GetColor() {
		return Color.YELLOW;
	}

	@Override
	public int GetID() {
		return 5;
	}

}
