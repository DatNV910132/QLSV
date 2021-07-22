package business_logic;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Statement;

import data_access.DiemThiToeic;

class ConnectDiemToeicTest {
	ResultSet rs;
	Statement st;
	@Test
	void getDataDiemToeic(){
		ConnectDiemToeic toeic = new ConnectDiemToeic();
		try {
			rs = st.executeQuery("SELECT * FROM sis.diemtoeic");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(rs, toeic.getDataDiemToeic());
	}
	
	@Test
	void add() {
		assertTrue(1==1);
		assertEquals(1, 1);
	}

}
