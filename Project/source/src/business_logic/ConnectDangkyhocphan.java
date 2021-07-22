package business_logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.Dangkyhocphan;

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
	
	// load data dang ky hoc phan
	/**
	 * @param rs
	 * @param table
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public void LoaddataDKHPtotable(ResultSet rs, JTable table) {
		((DefaultTableModel) table.getModel()).setNumRows(0);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			while (rs.next()) {
				Object row[] = new Object[6];
				row[0] = rs.getString(1);
				row[2] = rs.getString(3);
				row[3] = rs.getObject(4);
				model.addRow(row);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectHocPhan.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Loadata function ERROR");
		}
	}
	
	/**
	 * @param Table
	 * @param row
	 * @param mssv
	 * @param Hocky
	 * @return
	 */
	public Dangkyhocphan ConverttoBook(JTable Table, int row, String mssv, String Hocky) {
		Dangkyhocphan hp = new Dangkyhocphan();
		hp.setMaHP((String) Table.getModel().getValueAt(row, 0));
		hp.setMSSV(mssv);
		hp.setNgaydangky((String) Table.getModel().getValueAt(row, 2));
		hp.setTrangthai("Thành công");
		hp.setHocky(Hocky);
		return hp;
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
			Logger.getLogger(ConnectHocPhan.class.getName()).log(Level.SEVERE, null, ex);
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
	public boolean checkDangKiHocPhan(ResultSet rs, String maHP) {
		try {
			System.out.println(maHP);
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(maHP);
				if(rs.getString(1).equals(maHP))
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//	public ResultSet getDataDKHocPhan() {
//		ResultSet result = null;
//		String sqlCommand = "select * from " + tableDKHocphan ;
//		System.out.println(sqlCommand);
//		Statement st;
//		try {
//			st = (Statement) connection.createStatement();
//			result = st.executeQuery(sqlCommand);
//			System.out.println("GetDataHocPhan Correct");
//		} catch (SQLException ex) {
//			Logger.getLogger(ConnectSV.class.getName()).log(Level.SEVERE, null, ex);
//			System.out.println("Select ERROR \n" + ex.toString());
//		}
//
//		return result;
//		
//	}
//	public boolean checkDKHocPhan(ResultSet rs, String mssv, String maHP, String hocKi) {
//		try {
//			while(rs.next()) {
//				if(mssv.equals(rs.getString(2)) && maHP.equals(rs.getString(1)) && hocKi.equals(rs.getString(5)))
//					return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
}
