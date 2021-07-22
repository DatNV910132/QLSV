package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import data_access.ConnectLop;
import value_object.Lop;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class LopController {

	public ConnectLop lop = new ConnectLop();
	
	/**
	 * Kiểm tra có tồn tại lớp cần tìm trong danh sách {@link ResultSet} truyền vào không
	 * @param rs Danh sách các lớp cần tìm 
	 * @param text Mã lớp
	 * @return <code>true</code> nếu tìm được lớp cần tìm, <code>false</code> nếu không tìm được lớp cần tìm
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public boolean checkMaLop(ResultSet rs,JTextField text) {
		Lop a = new Lop();
		a.setMaLop(text.getText());
		try {
			while(rs.next()) {
				if(a.getMaLop().equals(rs.getString("MaLop")))
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
