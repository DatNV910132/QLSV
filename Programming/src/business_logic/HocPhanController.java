package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.ConnectHocPhan;

/**
 * @author Dom
 *
 */
public class HocPhanController {

	public ConnectHocPhan hocphan = new ConnectHocPhan();
	// load hoc phan vao bang
	/**
	 * @param rs
	 * @param table
	 * @param numrow
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public void LoaddataHPtotable(ResultSet rs, JTable table, int numrow) {
		((DefaultTableModel) table.getModel()).setNumRows(numrow);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			while (rs.next()) {
				Object row[] = new Object[6];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = java.time.LocalDate.now().toString();
				row[4] = rs.getObject(3);
				model.addRow(row);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HocPhanController.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Loadata function ERROR");
		}
	}

}
