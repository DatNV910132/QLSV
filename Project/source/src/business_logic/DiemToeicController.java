package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;


import data_access.ConnectDiemToeic;
import value_object.DiemThiToeic;

/**
 * {@link DiemToeicController} dùng để kết nối giữa {@link DiemThiToeic} với {@link XemDiemThiToeic}
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class DiemToeicController {
	public DiemThiToeic point = new DiemThiToeic();
	public ConnectDiemToeic toeic = new ConnectDiemToeic();
	
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
