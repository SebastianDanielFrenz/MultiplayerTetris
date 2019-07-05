package blocks;

import java.awt.Color;

public class TBlock extends Block {

	@Override
	public Block TurnRight() {
		// TODO Auto-generated method stub
		return new TBlock2();
	}

	@Override
	public Block TurnLeft() {
		// TODO Auto-generated method stub
		return new TBlock4();
	}

	@Override
	public int[][] GetFallingBlocks() {
		return new int[][] {{0,0},{0,1},{1,1},{0,2}};
	}
	@Override
	public Color GetColor() {
		return Color.green;
	}

	@Override
	public int GetID() {
		return 8;
	}

}
