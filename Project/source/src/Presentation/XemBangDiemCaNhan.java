package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business_logic.BangDiemController;
import business_logic.HocPhanController;
import business_logic.LopController;
import business_logic.SinhVienController;
import data_access.ConnectMysql;
import business_logic.ControllBangdiem;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dom
 *
 */
public class XemBangDiemCaNhan {

	private JFrame frame;
	private static JTable tablebangdiem;
	private static JTable tablekqht;
	static JLabel lblmssv;
	static JLabel lblname;
	static JLabel labelbirth;
	static JLabel lbllop;
	static JLabel lblchuongtrinh;
	static JLabel lblHehoc;
	static JLabel lblTrangthai;

	/**
	 * Launch the application.
	 */
	public static void main(String mssv, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				BangDiemController cnbd = new BangDiemController();
				ConnectMysql.Connect();
				SinhVienController cnsv = new SinhVienController();
				ConnectMysql.Connect();
				HocPhanController cnhp = new HocPhanController();
				ConnectMysql.Connect();
				LopController cnl = new LopController();
				ConnectMysql.Connect();
				try {
					XemBangDiemCaNhan window = new XemBangDiemCaNhan(mssv, name);

					cnbd.LoaddataBDtotable(cnbd.bangdiem.getData_DiemLopcuaSinhvien(mssv), tablebangdiem);
					ResultSet rs = cnsv.sinhvien.getData_Sinhvien(mssv);
					if (rs.next()) {
						lblmssv.setText(rs.getString(1));
						lblname.setText(rs.getString(3));
						labelbirth.setText(rs.getString(5));
						lbllop.setText(rs.getString(11));
						lblchuongtrinh.setText(rs.getString(12));
						lblHehoc.setText(rs.getString(13));
						lblTrangthai.setText(rs.getString(14));
					}

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// lay MaHP TenHP TC tu bang diem

				int nr = tablebangdiem.getRowCount();
				for (int i = 0; i < nr; i++) {
					String malop = (String) tablebangdiem.getValueAt(i, 4);
					ResultSet rsl = cnl.lop.getData_Lop(malop);

					try {
						if (rsl.next()) {
							ResultSet rshp = cnhp.hocphan.getData_Hocphan(rsl.getString(2));

							if (rshp.next()) {
								tablebangdiem.setValueAt(rshp.getString(1), i, 1);
								tablebangdiem.setValueAt(rshp.getString(2), i, 2);
								tablebangdiem.setValueAt(rshp.getString(3), i, 3);
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// Xử lý và thêm dữ liệu vào bảng kết quả học tập

				ControllBangdiem bd = new ControllBangdiem();
				bd.Dienhocky(tablekqht, mssv);
				bd.TinhDiem(tablekqht, mssv);
				System.out.println("Tinhs trinhf do");
				bd.TinhTrinhdo(tablekqht);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public XemBangDiemCaNhan(String mssv, String name) {
		initialize(mssv, name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mssv, String name) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setFont(new Font("Arial", Font.BOLD, 14));
		lblStudentInformationSystem.setBounds(559, 11, 193, 17);
		frame.getContentPane().add(lblStudentInformationSystem);

		JLabel lblNewLabel = new JLabel("Hanoi University of Science and Technology");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(506, 28, 308, 23);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 64, 1264, 636);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblBngimC = new JLabel("Bảng điểm cá nhân");
		lblBngimC.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBngimC.setBounds(10, 11, 113, 14);
		panel.add(lblBngimC);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 27, 1244, 2);
		panel.add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 37, 1244, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblThngTinSinh = new JLabel("Thông tin sinh viên");
		lblThngTinSinh.setFont(new Font("Arial", Font.PLAIN, 12));
		lblThngTinSinh.setBounds(10, 11, 103, 14);
		panel_1.add(lblThngTinSinh);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 27, 1224, 2);
		panel_1.add(separator_1);

		JLabel lblMSinhVin = new JLabel("Mã Sinh viên:");
		lblMSinhVin.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMSinhVin.setBounds(10, 40, 64, 14);
		panel_1.add(lblMSinhVin);

		JLabel lblHTnSv = new JLabel("Họ Tên SV:");
		lblHTnSv.setFont(new Font("Arial", Font.PLAIN, 11));
		lblHTnSv.setBounds(163, 40, 58, 14);
		panel_1.add(lblHTnSv);

		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNgySinh.setBounds(395, 40, 64, 14);
		panel_1.add(lblNgySinh);

		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLp.setBounds(596, 40, 64, 14);
		panel_1.add(lblLp);

		JLabel lblChngTrnh = new JLabel("Chương trình:");
		lblChngTrnh.setFont(new Font("Arial", Font.PLAIN, 11));
		lblChngTrnh.setBounds(767, 40, 74, 14);
		panel_1.add(lblChngTrnh);

		JLabel lblHHc = new JLabel("Hệ học:");
		lblHHc.setFont(new Font("Arial", Font.PLAIN, 11));
		lblHHc.setBounds(994, 40, 46, 14);
		panel_1.add(lblHHc);

		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTrngThi.setBounds(1133, 40, 64, 14);
		panel_1.add(lblTrngThi);

		lblmssv = new JLabel("");
		lblmssv.setFont(new Font("Arial", Font.PLAIN, 12));
		lblmssv.setBounds(79, 40, 74, 14);
		panel_1.add(lblmssv);

		lblname = new JLabel("");
		lblname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblname.setBounds(220, 40, 165, 14);
		panel_1.add(lblname);

		labelbirth = new JLabel("");
		labelbirth.setFont(new Font("Arial", Font.PLAIN, 12));
		labelbirth.setBounds(450, 40, 88, 14);
		panel_1.add(labelbirth);

		lbllop = new JLabel("");
		lbllop.setFont(new Font("Arial", Font.PLAIN, 12));
		lbllop.setBounds(621, 40, 136, 14);
		panel_1.add(lbllop);

		lblchuongtrinh = new JLabel("");
		lblchuongtrinh.setFont(new Font("Arial", Font.PLAIN, 12));
		lblchuongtrinh.setBounds(834, 40, 150, 14);
		panel_1.add(lblchuongtrinh);

		lblHehoc = new JLabel("");
		lblHehoc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHehoc.setBounds(1037, 40, 86, 14);
		panel_1.add(lblHehoc);

		lblTrangthai = new JLabel("");
		lblTrangthai.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTrangthai.setBounds(1188, 40, 46, 14);
		panel_1.add(lblTrangthai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 1244, 191);
		panel.add(scrollPane);

		tablebangdiem = new JTable();
		tablebangdiem.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "H\u1ECDc k\u1EF3", "M\u00E3 HP", "T\u00EAn HP", "TC", "L\u1EDBp h\u1ECDc",
						"\u0110i\u1EC3m QT", "\u0110i\u1EC3m thi", "\u0110i\u1EC3m ch\u1EEF" }) {
			/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablebangdiem.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablebangdiem.getColumnModel().getColumn(1).setPreferredWidth(50);
		tablebangdiem.getColumnModel().getColumn(2).setPreferredWidth(240);
		tablebangdiem.getColumnModel().getColumn(3).setPreferredWidth(40);
		tablebangdiem.getColumnModel().getColumn(4).setPreferredWidth(60);
		tablebangdiem.getColumnModel().getColumn(5).setPreferredWidth(60);
		tablebangdiem.getColumnModel().getColumn(6).setPreferredWidth(60);
		tablebangdiem.getColumnModel().getColumn(7).setPreferredWidth(60);
		scrollPane.setViewportView(tablebangdiem);

		JLabel lblBngimSinh = new JLabel("Bảng điểm sinh viên");
		lblBngimSinh.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBngimSinh.setBounds(588, 140, 113, 14);
		panel.add(lblBngimSinh);

		JLabel lblKtQuHc = new JLabel("Kết quả học tập Sinh viên");
		lblKtQuHc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKtQuHc.setBounds(578, 360, 138, 14);
		panel.add(lblKtQuHc);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 379, 1244, 246);
		panel.add(scrollPane_1);

		tablekqht = new JTable();
		tablekqht.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECDc k\u1EF3", "GPA", "CPA", "TC qua", "TC t\u00EDch l\u0169y", "TC n\u1EE3 \u0110K", "TC \u0110K", "Tr\u00ECnh \u0111\u1ED9", "M\u1EE9c CC", "Thi\u1EBFu \u0111i\u1EC3m", "Kh\u00F4ng t\u00EDnh", "CT\u0110T", "D\u1EF1 ki\u1EBFn XLHT", "X\u1EED l\u00FD ch\u00EDnh th\u1EE9c"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablekqht.getColumnModel().getColumn(0).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(1).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(2).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(3).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(4).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(5).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(6).setPreferredWidth(35);
		tablekqht.getColumnModel().getColumn(7).setPreferredWidth(90);
		tablekqht.getColumnModel().getColumn(8).setPreferredWidth(80);
		tablekqht.getColumnModel().getColumn(9).setPreferredWidth(70);
		tablekqht.getColumnModel().getColumn(10).setPreferredWidth(70);
		tablekqht.getColumnModel().getColumn(11).setPreferredWidth(90);
		tablekqht.getColumnModel().getColumn(12).setPreferredWidth(80);
		tablekqht.getColumnModel().getColumn(13).setPreferredWidth(90);
		scrollPane_1.setViewportView(tablekqht);
	}
}
