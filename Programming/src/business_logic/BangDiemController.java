package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import data_access.ConnectBangdiem;
import value_object.Sinhvien;

/**
 * @author Dom
 *
 */
public class BangDiemController{

	public ConnectBangdiem bangdiem = new ConnectBangdiem();
	
	// load bang diem vao bang
		/**
		 * Đưa dữ liệu vào bảng trong view
		 * @param rs Danh sách dữ liệu truyền vào
		 * @param table Bảng hiển thị dữ liệu
		 * @throws SQLException nếu không truy vấn được dữ liệu
		 */
		public void LoaddataBDtotable(ResultSet rs, JTable table) {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			try {
				while (rs.next()) {
					Object row[] = new Object[8];
					row[0] = rs.getString(3);
					row[4] = rs.getString(1);
					row[5] = rs.getFloat(4);
					row[6] = rs.getFloat(5);
					row[7] = rs.getString(6);
					model.addRow(row);
				}
			} catch (SQLException ex) {
				Logger.getLogger(HocPhanController.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("Loadata function ERROR");
			}
		}
	
	/**
	 * Kiểm tra có đúng là sinh viên đó không.
	 * @param rs Danh sách sinh viên đầu vào
	 * @param mssv Mã số sinh viên của sinh viên
	 * @return true nếu tìm thấy sinh viên or false nếu không tìm thấy sinh viên đó.
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public boolean checkMssv(ResultSet rs, String mssv) {
		Sinhvien a = new Sinhvien();
		a.setMssv(mssv);
		try {
			while(rs.next()) {
				if(a.getMssv().equals(rs.getString("MSSV")))
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
