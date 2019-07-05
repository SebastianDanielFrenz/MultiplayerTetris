import java.awt.Color;

import com.youtube.crash_games_cr_mc.simpleDB.Table;
import com.youtube.crash_games_cr_mc.simpleDB.varTypes.DBint;

public class RendererSettings {

	public RendererSettings(Table table) {
		rowColor = new Color(((DBint) table.getValue("rowColor", 0)).getValue());
		columnColor = new Color(((DBint) table.getValue("columnColor", 0)).getValue());
		rowSeperatorSize = ((DBint) table.getValue("rowSeperatorSize", 0)).getValue();
		columnSeperatorSize = ((DBint) table.getValue("columnSeperatorSize", 0)).getValue();
	}

	public void SaveSettings(Table table) {

		((DBint) table.getValue("rowColor", 0)).setValue(rowColor.getRGB());
		((DBint) table.getValue("columnColor", 0)).setValue(columnColor.getRGB());
		((DBint) table.getValue("rowSeperatorSize", 0)).setValue(rowSeperatorSize);
		((DBint) table.getValue("columnSeperatorSize", 0)).setValue(columnSeperatorSize);
	}

	public Color rowColor = Color.blue;
	public Color columnColor = Color.blue;
	public int rowSeperatorSize = 1;
	public int columnSeperatorSize = 1;

}
