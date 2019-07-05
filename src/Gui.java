import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.youtube.crash_games_cr_mc.simpleDB.DataBase;
import com.youtube.crash_games_cr_mc.simpleDB.DataBaseHandler;
import com.youtube.crash_games_cr_mc.simpleDB.Table;
import com.youtube.crash_games_cr_mc.simpleDB.expandable.FullValueManager;
import com.youtube.crash_games_cr_mc.simpleDB.expandable.ValueManager;
import com.youtube.crash_games_cr_mc.simpleDB.varTypes.DBint;
import com.youtube.crash_games_cr_mc.simpleDB.varTypes.DBvalue;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ValueManager valueManager = new FullValueManager();

	DataBaseHandler dbh = new DataBaseHandler(valueManager);

	Toolkit toolbox = Toolkit.getDefaultToolkit();

	Dimension screenSize = toolbox.getScreenSize();

	controls controls = new controls();

	GameField gf = new GameField(controls);

	public RendererSettings rendererSettings;

	Renderer renderer;

	public Gui() throws InterruptedException {

		super("Tetris Game");

		DataBase mpt;
		try {
			dbh.addDataBase("mpt.db");
			mpt = dbh.getDataBase("MPT");
		} catch (IOException e) {
			dbh.createDataBase("MPT");
			mpt = dbh.getDataBase("MPT");
		}

		Table settings;

		try {
			settings = mpt.getTable("settings");
		} catch (ArrayIndexOutOfBoundsException e) {
			mpt.createTable("settings");
			settings = mpt.getTable("settings");
			settings.addColumn("rowColor");
			settings.addColumn("columnColor");
			settings.addColumn("rowSeperatorSize");
			settings.addColumn("columnSeperatorSize");

			ArrayList<DBvalue> values = new ArrayList<DBvalue>();
			values.add(new DBint(Color.black.getRGB()));
			values.add(new DBint(Color.black.getRGB()));
			values.add(new DBint(1));
			values.add(new DBint(1));

			settings.addRow(values);
		}

		rendererSettings = new RendererSettings(settings);

		renderer = new Renderer(gf, new Dimension(8, 16), rendererSettings);

		getContentPane().setLayout(null);

		setSize(screenSize);

		add(renderer);

		addKeyListener(controls);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);

		int fps = 4;
		int res_fps;
		int draw_count;

		while (!renderer.gameField.isGameOver()) {
			renderer.setBounds(0, 0, getBounds().width, getBounds().height);
			draw_count = 1;
			if (controls.down) {
				draw_count = 4;
			}

			res_fps = fps * draw_count;
			Thread.sleep(1000 / res_fps);
			renderer.repaint();

		}

		rendererSettings.SaveSettings(settings);

		try {
			dbh.saveDataBase("MPT", "mpt.db");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
