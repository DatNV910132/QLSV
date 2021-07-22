package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author Dom
 *
 */
public class ConnectMysql {

	private static final String url = "jdbc:mysql://localhost:3306/sis";
	private static final String user = "root";
	private static final String password = "12345678";
	public static Connection connection;

	/**
	 * @throws ClassNotFoundException nếu không tìm thấy lớp
	 * @throws SQL nếu không truy vấn được dữ liệu
	 * 
	 */
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("CONNECT SUCCESS");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectMysql.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("CLASS NOT FOUND!");
		} catch (SQLException ex) {
			Logger.getLogger(ConnectMysql.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("CONNECT ERROR!");
		}
	}

}
