package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.ConnectDangkyhocphan;
import value_object.Dangkyhocphan;

/**
 * @author Dom
 *
 */
public class DangkyhocphanController{
	public ConnectDangkyhocphan dkhp = new ConnectDangkyhocphan();
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
			Logger.getLogger(HocPhanController.class.getName()).log(Level.SEVERE, null, ex);
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
}
