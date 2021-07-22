package business_logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.ConnectMysql;
import value_object.HocPhi;

public class ControllTracuuHocphi {
	public void InsertTable(JTable table,String mssv, String hocky) {
		HocPhiController connecthp = new HocPhiController();
		ConnectMysql.Connect();
		((DefaultTableModel) table.getModel()).setNumRows(0);
		DefaultTableModel modelhp = (DefaultTableModel) table.getModel();
		modelhp.setRowCount(0);

		ResultSet rs = connecthp.hocphi.getDataTKB_mssv(mssv, hocky);
		try {
			while (rs.next()) {
				HocPhi hp = new HocPhi();

				hp.setMaLop(rs.getString(2));
				hp.setThoigian(rs.getString(3));
				hp.setMaHP(rs.getString(4));
				hp.setTenHP(rs.getString(5));
				hp.setSotc(Integer.valueOf(rs.getString(6)));
				hp.setTCHP(Integer.valueOf(rs.getString(7)));
				hp.setGhichu(rs.getString(8));
				Object[] obj = { hp.getMaLop(), hp.getThoigian(), hp.getMaHP(), hp.getTenHP(), hp.getSotc(),
						hp.getTCHP(), hp.getGhichu() };
				modelhp.addRow(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (modelhp.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Sinh viên này không có học phí kỳ này ");

	}
	
	public void TinhHP(JTable table, JLabel Tongtc, JLabel Tongtien) {
		int r = table.getRowCount();
		int tongtc = 0;
		float tt;
		for(int i=0; i<r;i++) {
			tongtc += Integer.valueOf(table.getValueAt(i, 5).toString());
		}
		tt = 440000 * tongtc;
		
		Tongtc.setText(String.valueOf(tongtc));
		Tongtien.setText(String.valueOf(tt));
	}
}
