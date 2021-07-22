package data_access;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Statement;


/**
 * @author nguyendat 20154484
 *
 */
public class ConnectHocPhi extends ConnectMysql {
	/**
	 * Đưa ra ResultSet thời khóa biểu
	 * @return Trả về danh sách thời khóa biểu của cơ sở dữ liệu
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getDataTKB() {
		ResultSet rs = null ;
		String command = "SELECT * FROM sis.timeable";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(command);
			System.out.println("getDataTKB Correct");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * Đưa ra Result Thời khóa biểu của sinh viên có mã số sinh viên mssv
	 * @param mssv Mã số sinh viên
	 * @return Thông tin ThoiKhoaBieu của sinh viên có mã số sinh viên mssv
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getDataTKB_mssv(String mssv, String Hocky) {
		ResultSet rs = null ;
		String command = "SELECT sinhvien.MSSV, lop.MaLop, lop.Thoigian, lop.MaHP,hocphan.TenHP,hocphan.Sotinchi,hocphan.Tinchihocphi,lop.Ghichu FROM `bangdiem`, sinhvien, lop,hocphan WHERE sinhvien.MSSV = bangdiem.MSSV AND bangdiem.MaLop = lop.MaLop AND hocphan.MaHP = lop.MaHP AND lop.Hocky = "+Hocky+" AND sinhvien.MSSV =" + mssv;
		System.out.println(command);
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(command);
			System.out.println("getDataTKB_Mssv Correct");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
 }
