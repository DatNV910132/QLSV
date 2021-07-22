package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;
import data_access.DiemThiToeic;

/**
 * {@link ConnectDiemToeic} dùng để kết nối giữa {@link DiemThiToeic} với {@link XemDiemThiToeic}
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class ConnectDiemToeic extends ConnectMysql{
	public DiemThiToeic point = new DiemThiToeic();
	
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
	
	/**
	 * 
	 * @param rs Danh sách DiemThiToeic của tất cả sinh viên
	 * @param text Mã số sinh viên ccuar sinh viên
	 * @param box Kì học
	 * @return Trả về danh sách thông tin DiemThiToeic của sinh viên có mã số sinh viên và kì học
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public boolean check(ResultSet rs, JTextField text, JComboBox<?> box) {
		DiemThiToeic user = new DiemThiToeic();
		user.setMssv(text.getText());
		user.setHocki(box.getSelectedItem().toString());
		try {
			while(rs.next()) {
				if(user.getMssv().equals(rs.getString("MSSV")) && user.getHocki().equals(rs.getString("HocKy"))) {
					point.setMssv(rs.getString("MSSV"));
					point.setHocki(rs.getString("hocKy"));
					point.setNgaythi(rs.getString("Ngaythi"));
					point.setDiemnghe(rs.getInt("Diemnghe"));
					point.setDiemdoc(rs.getInt("Diemdoc"));
					point.setDiemtong(rs.getInt("Tongdiem"));
					point.setGhichu(rs.getString("Ghichu"));
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
