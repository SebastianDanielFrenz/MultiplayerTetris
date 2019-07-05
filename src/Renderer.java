import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import blocks.Blocks;

public class Renderer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Renderer() {
		setBackground(Color.green);
	}

	GameField gameField;
	Dimension gameSize;
	RendererSettings settings;
	int gameFieldOffset;

	public Renderer(GameField gameField, Dimension gameSize, RendererSettings settings, int gameFieldOffset) {
		this.gameField = gameField;
		this.gameSize = gameSize;
		this.settings = settings;
		this.gameFieldOffset = gameFieldOffset;
	}

	public Renderer(GameField gameField, Dimension gameSize, RendererSettings settings) {
		this(gameField, gameSize, settings, 0);
	}

	public void repaint() {
		Graphics g = getGraphics();

		if (gameField == null) { // wenn der Konstrukter durch Multithreading noch läuft
			return;
		}

		gameField.Update();

		Rectangle displaySize = getBounds();

		if (!gameField.isGameOver()) {

			int[][] blocks = gameField.GetRenderedBlocks();
			int[] zeile;
			int block;

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, displaySize.width, displaySize.height);

			for (int x = 0; x < blocks[0].length; x++) {
				g.setColor(settings.columnColor);
				g.fillRect(displaySize.width / gameSize.width * x, 0, settings.columnSeperatorSize, displaySize.height);
			}

			for (int y = 0; y < blocks.length - gameFieldOffset; y++) {
				zeile = blocks[y];

				g.setColor(settings.rowColor);
				g.fillRect(0, displaySize.height / gameSize.height * y, displaySize.width, settings.rowSeperatorSize);

				for (int x = 0; x < zeile.length; x++) {
					block = zeile[x];

					if (block != 0) {
						g.setColor(Blocks.blocks[block - 1].GetColor());
						g.fillRect(displaySize.width / gameSize.width * x, displaySize.height / gameSize.height * y,
								displaySize.width / gameSize.width, displaySize.height / gameSize.height);
					}
				}
			}
		}

		else {
			int fontsize = getBounds().height / 3;
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 0, fontsize));
			g.drawString("Game Over", 0, fontsize);
			System.out.println("Game Over!");
		}

	}

}
