package business_logic;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.math.RoundingMode;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.ConnectMysql;

/**
 * @author Dom
 *
 */
public class ControllBangdiem {
	
	/**
	 * Hàm này để làm tròn giá trị với các số sau dấu phẩu cho trước
	 * @param value là giá trị cần làm tròn
	 * @param places là số thập phân sau dấu phẩy
	 * @return số sau khi làm tròn
	 */
	public static BigDecimal lamtron(float value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(Float.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd;
	}

	/**
	 * Hàm chuyển đổi điểm chữ thành điểm số trên thanh số 4
	 * @param diem
	 * @return điểm hệ số 4 sau khi chuyển đổi
	 */
	public static float Diemchuto4(String diem) {
		float diem4 = 0;
		if(diem.equals("A+")) {
			diem4 = 4;
		}
		if(diem.equals("A")) {
			diem4 = 4;
		}
		if(diem.equals("B+")) {
			diem4 = 3.5f;
		}
		if(diem.equals("B")) {
			diem4 = 3;
		}
		if(diem.equals("C+")) {
			diem4 = 2.5f;
		}
		if(diem.equals("C")) {
			diem4 = 2;
		}
		if(diem.equals("D+")) {
			diem4 = 1.5f;
		}
		if(diem.equals("D")) {
			diem4 = 1;
		}
		if(diem.equals("F")) {
			diem4 = 0;
		}
//		switch (diem) {
//		case "A+":
//			diem4 = 4;
//			break;
//		case "A":
//			diem4 = 4;
//			break;
//		case "B+":
//			diem4 = (float) 3.5;
//			break;
//		case "B":
//			diem4 = 3;
//			break;
//		case "C+":
//			diem4 = (float) 2.5;
//			break;
//		case "C":
//			diem4 = 2;
//			break;
//		case "D+":
//			diem4 = (float) 1.5;
//			break;
//		case "D":
//			diem4 = 1;
//			break;
//		case "F":
//			diem4 = 0;
//			break;
//		}
		return diem4;
	}
	
	/**
	 * Hàm này để chuyển điểm số thành điểm chữ
	 * @param value là điểm số
	 * @return điểm chữ
	 */
	public static String SoToDiemChu(float value) {
		if (value < 0 || value > 10) throw new IllegalArgumentException();
		if (value < 4) return "F";
		
	    value = lamtron(value, 1).floatValue();
		if (value <= 4.9f) return "D";
		if (value <= 5.4f) return "D+";
		if (value <= 6.4f) return "C";
		if (value <= 6.9f) return "C+";
		if (value <= 7.9f) return "B";
		if (value <= 8.4f) return "B+";
		if (value <= 9.4f) return "A";
		return "A+";
	}

	/**
	 * Hàm điền học kỳ vào bảng trong view
	 * @param table
	 * @param mssv
	 */
	public void Dienhocky(JTable table, String mssv) {
		int nambd = (Integer.parseInt(mssv) / 10000);
		Calendar c = Calendar.getInstance();
		int namht = c.get(Calendar.YEAR);
		for (int i = nambd; i < namht; i++) {
			int nr = table.getRowCount();
			((DefaultTableModel) table.getModel()).setNumRows(nr);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object row1[] = new Object[14];
			row1[0] = i * 10 + 1;
			model.addRow(row1);
			Object row2[] = new Object[14];
			row2[0] = i * 10 + 2;
			model.addRow(row2);
		}
	}

	/**
	 * Hàm tính điểm CPA và in lên bảng trên view
	 * @param table
	 * @param mssv
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public void TinhDiem(JTable table, String mssv) {
		int nr = table.getRowCount();
		float TongdiemCPA = 0;
		int TongTCCPA = 0;
		BangDiemController cnbd = new BangDiemController();
		ConnectMysql.Connect();
		LopController cnl = new LopController();
		ConnectMysql.Connect();
		HocPhanController cnhp = new HocPhanController();
		ConnectMysql.Connect();
		for (int i = 0; i < nr; i++) {
			float TongdiemHK = 0;
			int TongTCHK = 0;
			int TCno = 0;
			String hk = table.getValueAt(i, 0).toString();
			ResultSet rs = cnbd.bangdiem.getData_DiemcuaSVtheoHK(mssv, hk);
			try {
				while (rs.next()) {
					String Malop = rs.getString(1).toString();
					String diemchu = rs.getString(6);
					float diem4 = Diemchuto4(diemchu);
					ResultSet rs1 = cnl.lop.getData_Lop(Malop);
					if (rs1.next()) {
						ResultSet rshp = cnhp.hocphan.getData_Hocphan(rs1.getString(2));
						if (rshp.next()) {
							int tc = rshp.getInt(3);
							if (diem4 == 0) {
								TCno += tc;
							}
							TongdiemHK += (diem4 * tc);
							TongdiemCPA += (diem4 * tc);
							TongTCHK += tc;
							TongTCCPA += tc;
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DecimalFormat df = new DecimalFormat("#.00");
			table.setValueAt(df.format(TongdiemHK / TongTCHK), i, 1);
			table.setValueAt(df.format(TongdiemCPA / TongTCCPA), i, 2);
			table.setValueAt(TongTCHK - TCno, i, 3);
			table.setValueAt(TCno, i, 5);
			table.setValueAt(TongTCHK, i, 6);
			table.setValueAt(TongTCCPA, i, 4);

		}
	}
	
	/**
	 * Tính trình độ của sinh viên
	 * @param table
	 * in vào bảng trong view
	 */
	public void TinhTrinhdo(JTable table) {
		
		int nr = table.getRowCount();
		for(int i = 0; i<nr;i++) {
			int TongTC = Integer.parseInt(table.getValueAt(i, 4).toString());
			if(TongTC < 32) {
				table.setValueAt("Năm thứ nhất", i, 7);
			}
			if(TongTC>=32 && TongTC < 64) {
				table.setValueAt("Năm thứ hai", i, 7);
			}
			if(TongTC>=64 && TongTC < 96) {
				table.setValueAt("Năm thứ ba", i, 7);
			}
			if(TongTC>=96 && TongTC < 128) {
				table.setValueAt("Năm thứ tư", i, 7);
			}
			if(TongTC>= 128) {
				table.setValueAt("Năm thứ năm", i, 7);
			}
		}
	}
}
