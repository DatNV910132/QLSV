package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business_logic.ConnectHocPhan;
import business_logic.ConnectMysql;
import business_logic.ConnectDangkyhocphan;
import business_logic.ConnectSV;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author Dom
 *
 */
public class DangKyHocPhan {

	private JFrame frame;
	private JTextField txtHP;
	private JTable tableHP;
	JLabel lblTongTC;
	int TongTC;
	JLabel lblhocky;
	/**
	 * Launch the application.
	 */
	public void main(String mssv, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKyHocPhan window = new DangKyHocPhan(mssv,name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public DangKyHocPhan(String mssv, String name) throws SQLException {
		initialize(mssv,name);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize(String mssv,String name) throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 580);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setFont(new Font("Arial", Font.BOLD, 14));
		lblStudentInformationSystem.setBounds(321, 28, 193, 17);
		frame.getContentPane().add(lblStudentInformationSystem);

		JLabel lblHanoiUniversityOf = new JLabel("Hanoi University of Science and Technology");
		lblHanoiUniversityOf.setFont(new Font("Arial", Font.BOLD, 14));
		lblHanoiUniversityOf.setBounds(254, 44, 308, 17);
		frame.getContentPane().add(lblHanoiUniversityOf);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 72, 799, 459);
		frame.getContentPane().add(panel);

		JLabel lblngKHc = new JLabel("Đăng ký học phần");
		lblngKHc.setBounds(10, 11, 111, 21);
		lblngKHc.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 32, 779, 2);

		JLabel lblHcK = new JLabel("Học kỳ:");
		lblHcK.setBounds(10, 48, 46, 14);
		lblHcK.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JComboBox<Object> cbhocky = new JComboBox<Object>();
		cbhocky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TongTC = 0;
				lblhocky.setText(cbhocky.getSelectedItem().toString());
				ConnectDangkyhocphan Connectsqldkhp = new ConnectDangkyhocphan();
				ConnectMysql.Connect();
				ConnectHocPhan Connectsql = new ConnectHocPhan();
				ConnectMysql.Connect();
				tableHP.removeAll();
				Connectsqldkhp.LoaddataDKHPtotable(
						Connectsqldkhp.getData_DangkyHocphan(mssv, cbhocky.getSelectedItem().toString()), tableHP);
				int rc = tableHP.getRowCount();
				for (int i = 0; i < rc; i++) {
					ResultSet rs2 = Connectsql.getData_Hocphan(tableHP.getValueAt(i, 0).toString());
					try {
						if (rs2.next()) {
							tableHP.setValueAt(rs2.getObject(2), i, 1);
							tableHP.setValueAt(rs2.getObject(3), i, 4);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TongTC += Integer.parseInt(tableHP.getValueAt(i, 4).toString());
					lblTongTC.setText(String.valueOf(TongTC));
				}
			}
		});
		cbhocky.setBounds(53, 45, 72, 21);
		cbhocky.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbhocky.setModel(new DefaultComboBoxModel<Object>(new String[] { "---", "20183", "20182", "20181", "20173", "20172",
				"20171", "20163", "20162", "20161", "20153", "20152", "20151" }));

		JLabel lblHc = new JLabel("Học chương trình:");
		lblHc.setBounds(149, 46, 100, 18);
		lblHc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblchuongtrinhhoc = new JLabel("");
		lblchuongtrinhhoc.setBounds(255, 46, 156, 18);
		lblchuongtrinhhoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ConnectSV sqlSV = new ConnectSV();
		ConnectMysql.Connect();
		ResultSet rs = sqlSV.getData_Sinhvien(mssv);
		String chuongtrinhhoc = null;
		if (rs.next()) {
			chuongtrinhhoc = rs.getString(12);
		}
		lblchuongtrinhhoc.setText(chuongtrinhhoc);
		JLabel lblMHcPhn = new JLabel("Mã HP đăng ký:");
		lblMHcPhn.setBounds(10, 86, 90, 21);
		lblMHcPhn.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtHP = new JTextField();
		txtHP.setBounds(100, 86, 124, 21);
		txtHP.setColumns(10);

		JButton btndangky = new JButton("Đăng ký");
		btndangky.setBounds(252, 86, 89, 23);
		btndangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectHocPhan Connectsql = new ConnectHocPhan();
				ConnectMysql.Connect();
				int numrow = tableHP.getRowCount();
				TongTC = 0;
				ResultSet rs1 = Connectsql.getData_Hocphan(txtHP.getText());
				String MaHP = null;
				try {
					if (rs1.next()) {
						MaHP = (String) rs1.getObject(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean flag = true;
				for (int i = 0; i < numrow; i++) {
					if (!tableHP.getValueAt(i, 0).toString().equals(MaHP)) {
						TongTC += Integer.parseInt(tableHP.getValueAt(i, 4).toString());
						lblTongTC.setText(String.valueOf(TongTC));
						flag = true;
					} else {
						flag = false;
						break;
					}

				}
				if (flag) {
					Connectsql.LoaddataHPtotable(Connectsql.getData_Hocphan(txtHP.getText()), tableHP, numrow);
					int nrn = tableHP.getRowCount();
					TongTC = 0;
					for (int i = 0; i < nrn; i++) {
						TongTC += Integer.parseInt(tableHP.getValueAt(i, 4).toString());
						lblTongTC.setText(String.valueOf(TongTC));
					}
					
				} else
					JOptionPane.showMessageDialog(frame, "Học phần này đã được đăng ký. Vui lòng kiểm tra lại");

			}
		});

		JLabel lblthongbao = new JLabel("");
		lblthongbao.setBounds(10, 118, 46, 14);
		lblthongbao.setForeground(Color.RED);

		JLabel lblBngngK = new JLabel("Bảng đăng ký học phần kỳ");
		lblBngngK.setBounds(210, 162, 145, 14);
		lblBngngK.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblhocky = new JLabel("");
		lblhocky.setBounds(357, 162, 54, 14);
		lblhocky.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblCaSinhVin = new JLabel("của sinh viên");
		lblCaSinhVin.setBounds(407, 162, 72, 14);
		lblCaSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblmssv = new JLabel("");
		lblmssv.setBounds(482, 162, 100, 15);
		lblmssv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmssv.setText(mssv);

		JLabel lblTngSTn = new JLabel("Tổng số TC đăng ký:");
		lblTngSTn.setBounds(591, 348, 124, 14);
		lblTngSTn.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTongTC = new JLabel("");
		lblTongTC.setBounds(711, 348, 46, 14);
		lblTongTC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JButton btnNewButton = new JButton("Xóa các HP đã chọn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numrow = tableHP.getRowCount();
				System.out.println(numrow);
				if (numrow == 0) {
					JOptionPane.showMessageDialog(frame, "Không có dữ liệu về Học phần đăng ký");
				} else {
					TongTC = 0;
					ConnectDangkyhocphan Connectsql = new ConnectDangkyhocphan();
					ConnectMysql.Connect();
					ConnectHocPhan Connectsqlhp = new ConnectHocPhan();
					ConnectMysql.Connect();
					Connectsql.deleteDKHP(tableHP, cbhocky.getSelectedItem().toString(), mssv);
					Connectsql.LoaddataDKHPtotable(
							Connectsql.getData_DangkyHocphan(mssv, cbhocky.getSelectedItem().toString()), tableHP);
					int rc = tableHP.getRowCount();
					for (int i = 0; i < rc; i++) {
						ResultSet rs2 = Connectsqlhp.getData_Hocphan(tableHP.getValueAt(i, 0).toString());
						try {
							if (rs2.next()) {
								tableHP.setValueAt(rs2.getObject(2), i, 1);
								tableHP.setValueAt(rs2.getObject(3), i, 4);
								TongTC += Integer.parseInt(tableHP.getValueAt(i, 4).toString());
								lblTongTC.setText(String.valueOf(TongTC));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			}
		});
		btnNewButton.setBounds(571, 373, 163, 23);

		JButton btnGingK = new JButton("Gửi đăng ký");
		btnGingK.setBounds(149, 412, 248, 23);
		btnGingK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rc = tableHP.getRowCount();
				ConnectDangkyhocphan Connectsql = new ConnectDangkyhocphan();
				ConnectMysql.Connect();
				ConnectHocPhan Connectsqlhp = new ConnectHocPhan();
				ConnectMysql.Connect();
				for (int i = 0; i < rc; i++) {
					if (tableHP.getValueAt(i, 3) == null) {
						Connectsql.insertDB_DangkyHP(
								Connectsql.ConverttoBook(tableHP, i, mssv, cbhocky.getSelectedItem().toString()));
					}
				}
				Connectsql.LoaddataDKHPtotable(
						Connectsql.getData_DangkyHocphan(mssv, cbhocky.getSelectedItem().toString()), tableHP);
				int rcn = tableHP.getRowCount();
				for (int j = 0; j < rcn; j++) {
					ResultSet rs2 = Connectsqlhp.getData_Hocphan(tableHP.getValueAt(j, 0).toString());
					try {
						if (rs2.next()) {
							tableHP.setValueAt(rs2.getObject(2), j, 1);
							tableHP.setValueAt(rs2.getObject(3), j, 4);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 196, 704, 139);

		tableHP = new JTable();
		tableHP.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 HP", "T\u00EAn h\u1ECDc ph\u1EA7n", "Ng\u00E0y \u0111\u0103ng k\u00FD",
						"TT \u0111\u0103ng k\u00FD", "S\u1ED1 t\u00EDn ch\u1EC9", "" }) {
			/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Boolean.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHP.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableHP.getColumnModel().getColumn(1).setMinWidth(200);
		tableHP.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableHP.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableHP.getColumnModel().getColumn(4).setPreferredWidth(80);
		tableHP.getColumnModel().getColumn(5).setPreferredWidth(40);
		scrollPane.setViewportView(tableHP);
		panel.setLayout(null);
		panel.add(lblngKHc);
		panel.add(separator);
		panel.add(lblMHcPhn);
		panel.add(txtHP);
		panel.add(btndangky);
		panel.add(lblthongbao);
		panel.add(scrollPane);
		panel.add(lblTngSTn);
		panel.add(lblTongTC);
		panel.add(btnGingK);
		panel.add(btnNewButton);
		panel.add(cbhocky);
		panel.add(lblHcK);
		panel.add(lblHc);
		panel.add(lblchuongtrinhhoc);
		panel.add(lblBngngK);
		panel.add(lblCaSinhVin);
		panel.add(lblhocky);
		panel.add(lblmssv);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(407, 412, 248, 23);
		panel.add(btnNewButton_1);
	}
}
