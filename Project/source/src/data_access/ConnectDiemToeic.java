package data_access;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Statement;

import value_object.DiemThiToeic;

/**
 * {@link ConnectDiemToeic} dùng để kết nối giữa {@link DiemThiToeic} với {@link XemDiemThiToeic}
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class ConnectDiemToeic extends ConnectMysql{
	
	/**
	 * Phương thức này trả về ResultSet dữ liệu của điểm thi Toeic
	 * @return Trả về danh sách thông tin đầy đủ DiemThiToeic của tất cả sinh viên
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getDataDiemToeic() {
		ResultSet rs = null;
		String command = "SELECT * FROM sis.diemtoeic";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(command);
			System.out.println("getDataDiemToeic ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
