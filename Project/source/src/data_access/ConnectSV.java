package data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * @author Dom
 *
 */
public class ConnectSV extends ConnectMysql {
	private String tableSV = "sis.sinhvien";

//update  pass thong tin nguoi su dung
	/**
	 * @param table
	 * @param mssv
	 * @param nPass
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public void UpdatePass(String table, String mssv, String nPass) {
		String sqlCommand = "update " + table + " set Password ='"+ nPass +"' where MSSV = " + mssv;
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(sqlCommand);
			pst.execute();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectSV.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/**
	 * @return Trả về danh sách dữ liệu của Sinh viên
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_Sinhvien(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableSV;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetDataUser Correct");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSV.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        
        return result;
    }
	/**
	 * @param mssv Mã số sinh viên
	 * @return Trả về dữ liệu của sinh viên có mã số sinh viên cần tìm
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public ResultSet getData_Sinhvien(String mssv){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableSV + " where MSSV ="+mssv;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetDataUser Correct");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSV.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        
        return result;
    }
	
}
