package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;


import data_access.ConnectTKB;
import value_object.ThoiKhoaBieu;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class TKBController {

	public ConnectTKB tkb = new ConnectTKB();
	/**
	 * Phương thức này dùng để kiểm tra xem sinh viên với mã số sinh viên mssv có thời khóa biểu trong kì hiện tại không?
	 * @param rs Danh sách ThoiKhoaBieu của sinh viên
	 * @param mssv Mã số sinh viên của sinh viên
	 * @return Trả về ThoiKhoaBieu của sinh viên có mã số sinh viên mssv
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public boolean checkMssv(ResultSet rs, JTextField mssv) {
		ThoiKhoaBieu user = new ThoiKhoaBieu();
		user.setMssv(mssv.getText());
		try {
			while (rs.next()) {
				if(user.getMssv().equals(rs.getString("mssv"))) {
					return true;
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
