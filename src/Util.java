
public class Util {

	public static int[][] Copy(int[][] array) {
		int[][] output = new int[array.length][];

		for (int x = 0; x < array.length; x++) {
			output[x] = new int[array[x].length];
			for (int y = 0; y < array[x].length; y++) {
				output[x][y] = array[x][y];
			}
		}

		return output;
	}

	public static int[] Copy(int[] array) {
		int[] out = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			out[i] = array[i];
		}
		return out;
	}

}
