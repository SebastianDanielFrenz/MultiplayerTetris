package blocks;

import java.util.Random;

public class Blocks {

	public static Block[] blocks = new Block[] { new LBlock(), new LBlock2(), new LBlock3(), new LBlock4(),
			new OBlock(), new LongBlock(), new LongBlock2(), new TBlock(), new TBlock2(), new TBlock3(), new TBlock4(), 
			new mirroredLBlock(), new mirroredLBlock2(), new mirroredLBlock3(), new mirroredLBlock4() };

	public static float[] chances = new float[] { 1, 1, 1, 1, 4, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static Block GetBlock(int ID) {
		return blocks[ID - 1];
	}

	public static float GetTotalChance() {
		float total = 0;
		for (int i = 0; i < chances.length; i++) {
			total += chances[i];
		}
		return total;
	}

	public static Block GetRandomBlock(Random random) {
		float n = random.nextFloat() * GetTotalChance();

		int i;
		for (i = 0; n > chances[i]; i++) {
			n -= chances[i];
		}
		return blocks[i];
	}

}
