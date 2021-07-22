package data_access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class ConnectLop extends ConnectMysql{

	private String tableLop = "sis.lop";

	/**
	 * Phương thức này dùng để lấy dữ liệu của lớp với đầu vào là String
	 * @param Malop Mã lớp
	 * @return Trả về dữ liệu thông tin của lớp có mã lớp MaLop 
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_Lop(String Malop) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableLop + " where MaLop = '" + Malop + "'";
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
	 * Lấy ra danh sách thông tin của tất cả lớp
	 * @return {@link ResultSet} tất cả lớp
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_Lop() {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableLop;
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
	
	public ResultSet getData_LopMSSV(String mssv) {
		ResultSet result = null;
		String sqlCommand = "SELECT lop.* FROM lop,bangdiem WHERE lop.hocky = '20182' AND lop.MaLop = bangdiem.MaLop AND bangdiem.MSSV = '" + mssv + "'";
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
}
