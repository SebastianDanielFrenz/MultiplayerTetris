package blocks;

import java.awt.Color;
import java.util.Random;

import exception.BlockEmptyException;

public abstract class Block {

	public Block(int[][] falling) {
		if (falling.length == 0) {
			try {
				throw new BlockEmptyException("No falling blocks given to constructor of " + GetID());
			} catch (BlockEmptyException e) {
				e.printStackTrace();
			}
		}

		smallestX = falling[0][0];
		biggestX = falling[0][0];
		smallestY = falling[0][1];
		biggestY = falling[0][1];

		for (int i = 1; i < falling.length; i++) {
			if (falling[i][0] < smallestX) {
				smallestX = falling[i][0];
			} else if (falling[i][0] > biggestX) {
				biggestX = falling[i][0];
			}
			if (falling[i][1] < smallestY) {
				smallestY = falling[i][1];
			} else if (falling[i][1] > biggestY) {
				biggestY = falling[i][1];
			}
		}
	}

	public Block() {
		int[][] falling = GetFallingBlocks();
		if (falling.length == 0) {
			try {
				throw new BlockEmptyException("No falling blocks given to constructor of " + GetID());
			} catch (BlockEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		smallestX = falling[0][0];
		biggestX = falling[0][0];
		smallestY = falling[0][1];
		biggestY = falling[0][1];

		for (int i = 1; i < falling.length; i++) {
			if (falling[i][0] < smallestX) {
				smallestX = falling[i][0];
			} else if (falling[i][0] > biggestX) {
				biggestX = falling[i][0];
			}
			if (falling[i][1] < smallestY) {
				smallestY = falling[i][1];
			} else if (falling[i][1] > biggestY) {
				biggestY = falling[i][1];
			}
		}
	}

	public static final int NONE = -1;

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int TOP = 2;
	public static final int BOTTOM = 3;

	public int smallestX;
	public int smallestY;
	public int biggestX;
	public int biggestY;

	public abstract Block TurnRight();

	public abstract Block TurnLeft();

	public abstract int[][] GetFallingBlocks();

	public abstract Color GetColor();

	public static int GenerateRandomBlockID(Random random) {
		return random.nextInt(Blocks.blocks.length) + 1;
	}

	/**
	 * This function does not copy the array! It edits it and returns it!<br>
	 * This is just for ease of use.
	 * 
	 * @param array
	 * @param x
	 * @param y
	 * @return array
	 */
	public static int[][] MoveFallingBlocks(int[][] array, int x, int y) {
		for (int i = 0; i < array.length; i++) {
			array[i][0] += x;
			array[i][1] += y;
		}
		return array;
	}

	public static int[][] MoveFallingBlocks(int[][] array, int[] center) {
		return MoveFallingBlocks(array, center[0], center[1]);
	}

	public abstract int GetID();

}
