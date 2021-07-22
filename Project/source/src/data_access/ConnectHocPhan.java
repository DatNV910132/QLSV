package data_access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


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




}
