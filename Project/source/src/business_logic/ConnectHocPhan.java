package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Dom
 *
 */
public class ConnectHocPhan extends ConnectMysql {
	private String tableHocphan = "sis.hocphan";

	/**
	 * @param mahp Mã học phần
	 * @return Trả về danh sách dữ liệu học phần theo mã học phần cần tìm.
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_Hocphan(String mahp) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableHocphan + " where MaHP = '" + mahp + "'";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			result = st.executeQuery(sqlCommand);
			System.out.println("GetDataHocPhan Correct");
		} catch (SQLException ex) {
			Logger.getLogger(ConnectSV.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Select ERROR \n" + ex.toString());
		}

		return result;
	}


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
			Logger.getLogger(ConnectHocPhan.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Loadata function ERROR");
		}
	}

}
