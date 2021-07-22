package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import data_access.ConnectSV;
import value_object.Sinhvien;



/**
 * @author Dom
 *
 */
public class SinhVienController {
	
	public ConnectSV sinhvien = new ConnectSV();
	
	/**
	 * @param rs
	 * @param mssv
	 * @param pass
	 * @return <code>true</code> nếu tìm thấy Sinh viên, <code>false</code> nếu không tìm thấy sinh viên
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public boolean CheckSinhvien(ResultSet rs,String mssv, String pass) {
        Sinhvien user = new Sinhvien();
        user.setMssv(mssv);
        user.setPassword(pass);
        
    try {    
        while(rs.next()){
                if(user.getMssv().equals(rs.getString(1)) &&
                    user.getPassword().equals(rs.getString(2))){
                    System.out.println("User ok");
                    return true;
                }
        }
    } catch (SQLException ex) {
        Logger.getLogger(SinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu");
    }
    return false;
}
}
