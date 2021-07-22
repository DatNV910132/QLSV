package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import data_access.Sinhvien;

/**
 * @author Dom
 *
 */
public class ConnectBangdiem extends ConnectMysql{

	private String tableBangdiem = "sis.bangdiem";
	
	/** 
	 * lấy tất cả dữ liệu từ bảng Bangdiem trong cơ sở dữ liệu
	 * @return ResultSet cho dữ liệu của Bangdiem
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getDataBangdiem() {
		ResultSet rs = null;
		String command = "SELECT * FROM sis.bangdiem";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(command);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * Lấy bảng điểm của một lớp với Mã Lớp
	 * @param Malop Mã lớp của lớp dưới dạng String
	 * @return ResultSet dữ liệu Bangdiem của lớp có mã lớp MaLop
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_DiemcuaLop(String Malop) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableBangdiem + " where MaLop = '" + Malop + "'";
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
	 * Lấy tất cả điểm của sinh viên ở các lớp với MSSV trong một Học kỳ
	 * @param mssv Mã số sinh viên
	 * @param Hocky Học kỳ
	 * @return ResultSet dữ liệu Bangdiem của sinh viên có mã số sinh viên mssv trong học kỳ Hocky
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_DiemcuaSVtheoHK(String mssv, String Hocky) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableBangdiem + " where MSSV = '" + mssv + "' && Hocky = '" + Hocky +"'";
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
	 * Lấy tất cả điểm của sinh viên ở các lớp với MSSV
	 * @param mssv Mã số sinh viên
	 * @return ResultSet dữ liệu Bangdiem của sinh viên có mã số sinh viên mssv
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_DiemLopcuaSinhvien(String mssv) {
		ResultSet result = null;
		String sqlCommand = "select * from " + tableBangdiem + " where MSSV = '" + mssv+"'";
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
				Logger.getLogger(ConnectHocPhan.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("Loadata function ERROR");
			}
		}
	/**
	 * Đếm số sinh viên trong một lớp
	 * @param maLop Mã lớp
	 * @return ResultSet danh sách lớp với số sinh viên tương ứng của lớp cần tìm
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public ResultSet countSV(String maLop) {
		ResultSet rs = null;
		String command = "SELECT bangdiem.MSSV,bangdiem.MaLop,COUNT(*),lop.MaxSV,lop.Hocky FROM bangdiem,lop WHERE bangdiem.MaLop=lop.MaLop GROUP BY bangdiem.MaLop";
		Statement st;
		try {
			st =(Statement) connection.createStatement();
			rs = st.executeQuery(command);
			System.out.println("1232435454");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * Insert dữ liệu vào trong CSDL
	 * @param mssv Mã số sinh viên
	 * @param maLop Mã lớp
	 * @param hocKi Học kì
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	public void dangKiMonHoc(String mssv,String maLop,String hocKi) {
		String command = "INSERT INTO `bangdiem` (`MaLop`, `MSSV`, `Hocky`, `DiemQT`, `Diemcuoiky`, `Diemheso4`) VALUES ('"+maLop+"', '"+mssv+"', '"+hocKi+"', NULL, NULL, NULL);";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) connection.prepareStatement(command);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
