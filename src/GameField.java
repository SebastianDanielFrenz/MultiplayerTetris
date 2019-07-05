import java.util.Random;

import blocks.Block;
import blocks.Blocks;

public class GameField {

	public GameField(controls controls) {
		this.controls = controls;
	}

	controls controls;

	Random random = new Random();

	int[][] field = new int[16][8];
	int fallingBlockID = Block.GenerateRandomBlockID(random);

	Block block = Blocks.GetBlock(fallingBlockID);
	int[][] falling = Block.MoveFallingBlocks(block.GetFallingBlocks(),
			-block.smallestX + random.nextInt(7 - block.biggestX), -block.smallestY);

	int[] center = new int[] { -block.smallestX + random.nextInt(7 - block.biggestX), -block.smallestY };

	int[][] fieldFalling = new int[16][8];

	boolean floor = false;

	boolean gameOver = false;

	public boolean isGameOver() {
		return gameOver;
	}

	int[][] fallingOld;
	int[] centerOld;

	/**
	 * lässt Blöcke herunterfallen und schaut, ob die unteren Reihen voll sind (bei
	 * Bedarf werden diese geleert), <br>
	 * außerdem werden duch "controls" die Blöcke bewegt.
	 */
	public void Update() {

		if (controls.up) {// bei pfeiltaste-hoch wird der block im Uhrzeigersinn um 90° gedreht
			fallingOld = Util.Copy(falling);
			int fallingBlockIDOld = fallingBlockID;

			System.out.println(Blocks.GetBlock(fallingBlockID).TurnRight().GetID());
			falling = Block.MoveFallingBlocks(Blocks.GetBlock(fallingBlockID).TurnRight().GetFallingBlocks(), center);
			fallingBlockID = Blocks.GetBlock(fallingBlockID).TurnRight().GetID();
			for (int i = 0; i < falling.length; i++) {
				if (falling[i][0] >= 8 || falling[i][1] >= 16 || falling[i][0] < 0 || falling[i][1] < 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					break;
				} else if (field[falling[i][1]][falling[i][0]] != 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					break;
				}
			}
		}
		if (controls.right) {
			centerOld = Util.Copy(center);
			center[0]++;
			fallingOld = Util.Copy(falling);
			int fallingBlockIDOld = fallingBlockID;

			falling = Block.MoveFallingBlocks(Blocks.GetBlock(fallingBlockID).GetFallingBlocks(), center);
			for (int i = 0; i < falling.length; i++) {
				if (falling[i][1] >= 16 || falling[i][0] >= 8 || falling[i][0] < 0 || falling[i][1] < 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					center = centerOld;
					break;
				} else if (field[falling[i][1]][falling[i][0]] != 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					center = centerOld;
					break;
				}
			}
		}
		if (controls.left) {
			centerOld = Util.Copy(center);
			center[0]--;
			fallingOld = Util.Copy(falling);
			int fallingBlockIDOld = fallingBlockID;

			falling = Block.MoveFallingBlocks(Blocks.GetBlock(fallingBlockID).GetFallingBlocks(), center);
			for (int i = 0; i < falling.length; i++) {
				if (falling[i][1] >= 16 || falling[i][0] >= 8 || falling[i][0] < 0 || falling[i][1] < 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					center = centerOld;
					break;
				} else if (field[falling[i][1]][falling[i][0]] != 0) {
					falling = fallingOld;
					fallingBlockID = fallingBlockIDOld;
					center = centerOld;
					break;
				}
			}
		}

		floor = false;
		for (int i = 0; i < falling.length; i++) {
			if (falling[i][1] <= 14 && field[falling[i][1] + 1][falling[i][0]] == 0) {

			} else {
				floor = true;
				break;
			}
		}

		for (int i = 0; i < falling.length; i++) {
			if (floor) {
				int[] stonePosition = falling[i];
				field[stonePosition[1]][stonePosition[0]] = fallingBlockID;
			} else {
				falling[i][1]++;
			}
		}

		center[1]++;

		if (floor) {
			if (falling[falling.length - 1][1] == 0) {
				gameOver = true;
				return;
			} else {
				fallingBlockID = Block.GenerateRandomBlockID(random);

				Block block = Blocks.GetBlock(fallingBlockID);

				int x = random.nextInt(7 - block.biggestX) - block.smallestX;

				falling = Block.MoveFallingBlocks(block.GetFallingBlocks(), x, -block.smallestY);

				center = new int[] { x, -block.smallestY };
			}
		}

		// check for full lines

		boolean line_full;

		line_full = false;
		for (int x = 0; x < 8; x++) {
			if (field[0][x] != 0) {
				line_full = true;
			}
		}
		if (line_full) {
			gameOver = true;
			return;
		}

		for (int y = 1; y < 16; y++) {
			line_full = true;
			for (int x = 0; x < 8; x++) {
				if (field[y][x] == 0) {
					line_full = false;
				}
			}
			if (line_full) {
				for (int y2 = y - 1; y2 >= 0; y2--) {
					field[y2 + 1] = Util.Copy(field[y2]);
					field[y2] = new int[8];
				}
			}
		}

		fieldFalling = GetRenderedBlocks();

		// showFields();
	}

	// public boolean testFallingBlock() {

	// }

	@SuppressWarnings("unused")
	/**
	 * zeigt das feld
	 * 
	 */
	private void showFields() {
		int i = 0;
		while (i <= 15) {

			int i2 = 0;
			while (i2 <= 7) {
				System.out.print(fieldFalling[i][i2]);
				i2++;
			}
			System.out.println("");
			i++;
		}
		System.out.println("");
		System.out.println("");
	}

	/**
	 * @return Die Blöcke die gerendert werden
	 */
	public int[][] GetRenderedBlocks() {
		int[][] output = new int[16][8];
		for (int y = 0; y < output.length; y++) {
			for (int x = 0; x < output[y].length; x++) {
				output[y][x] = field[y][x];
			}
		}

		for (int i = 0; i < falling.length; i++) {
			int[] stonePosition = falling[i];
			output[stonePosition[1]][stonePosition[0]] = fallingBlockID;
		}

		return output;
	}

	public int[][] GetBlocks() {
		return null;
	}

}
