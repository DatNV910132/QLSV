package data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business_logic.HocPhanController;
import value_object.Dangkyhocphan;

/**
 * @author Dom
 *
 */
public class ConnectDangkyhocphan extends ConnectMysql{
	private String tableDKHocphan = "sis.dangkihocphan";

	/**
	 * @param mssv
	 * @param hocky
	 * @return
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_DangkyHocphan(String mssv, String hocky) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableDKHocphan + " where MSSV = '" + mssv + "'" + " && hocky = '" + hocky
				+ "'";
		System.out.println(sqlCommand);
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
	
	/**
	 * @param dkhp
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public void insertDB_DangkyHP(Dangkyhocphan dkhp) {
		String sqlCommand = "insert into " + tableDKHocphan + " value(? ,? ,? ,? ,?)";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(sqlCommand);
			pst.setString(1, dkhp.getMaHP());
			pst.setString(2, dkhp.getMSSV());
			pst.setString(3, dkhp.getNgaydangky());
			pst.setString(4, dkhp.getTrangthai());
			pst.setString(5, dkhp.getHocky());
			int row = pst.executeUpdate();
			if (row > 0) {
				System.out.println("Inserted to DataBase");
			} else {
				System.out.println("Insert Error");
			}
		} catch (SQLException ex) {
			Logger.getLogger(HocPhanController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/**
	 * @param table
	 * @param hocky
	 * @param mssv
	 */
	public void deleteDKHP(JTable table, String hocky, String mssv) {
		PreparedStatement pst = null;
		int rc = table.getRowCount();
		boolean tich = false;
		Object[] options = { "Yes", "No" };
		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) // Confirm Delete = Yes
		{
			for (int i = 0; i < rc; i++) {
				Boolean chkDel;
				if(table.getValueAt(i, 5) == null) {
					chkDel = false;
				}else {chkDel = (Boolean) table.getValueAt(i, 5);}
				 // Checked
				System.out.println(chkDel);
				if (chkDel) // Checked to Delete
				{
					if (table.getValueAt(i, 3).toString().equals("")) {
						((DefaultTableModel) table.getModel()).removeRow(i);
					} else {
						// Delete Data
						String sql = "DELETE FROM "+tableDKHocphan+"  WHERE MaHP = ?  && hocky = '" + hocky +"' && MSSV = '"+mssv+"'";
						try {
							pst = connection.prepareStatement(sql);
							pst.setString(1, table.getValueAt(i, 0).toString());
							pst.executeUpdate();
							tich = true;
						} catch (Exception ed) {
							JOptionPane.showMessageDialog(null, "Không thể xóa id " + table.getValueAt(i, 1).toString()
									+ " vui lòng xem lại bảng điểm");
							tich = false;
						}
					}

				}
			}
			if (tich) {
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
			}
		}
	}

}
