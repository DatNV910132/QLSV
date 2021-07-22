package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business_logic.BangDiemController;
import business_logic.DangkyhocphanController;
import business_logic.LopController;
import data_access.ConnectMysql;
import value_object.Lop;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class SinhVienDangKiMonHoc {

	private JFrame frame;
	DefaultTableModel model,model1;
	private JTextField textField;
	private JTable table;
	private JLabel label_2;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String mssv, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinhVienDangKiMonHoc window = new SinhVienDangKiMonHoc(mssv,name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	public SinhVienDangKiMonHoc(String mssv, String name) {
		initialize(mssv,name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mssv, String name) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1024, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(SystemColor.textHighlight);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new StudentHome(mssv, name);
				StudentHome.main(mssv, name);
				frame.dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/hust.png")));
		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setForeground(Color.WHITE);
		lblStudentInformationSystem.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Hanoi University of Science and Technology");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblMtKhu = new JLabel("Xin ch\u00E0o b\u1EA1n ");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JButton btnngNhp = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khachHome();
				khachHome.main(null);
				frame.dispose();
			}
		});
		btnngNhp.setBackground(new Color(50, 205, 50));
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECDc k\u1EF3 20181,tu\u1EA7n th\u1EE9 10,ng\u00E0y 30 th\u00E1ng 10 n\u0103m 2018");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel jbnameconnect = new JLabel("name");
		jbnameconnect.setForeground(Color.WHITE);
		jbnameconnect.setFont(new Font("Arial", Font.PLAIN, 13));
		jbnameconnect.setText(name);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStudentInformationSystem)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMtKhu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbnameconnect)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnngNhp))
						.addComponent(lblNewLabel_2))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnngNhp)
										.addComponent(lblMtKhu)
										.addComponent(jbnameconnect))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblStudentInformationSystem)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1))))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 940, 21);
		panel_1.add(menuBar);
		
		JLabel lblNewLabel_3 = new JLabel("Trang ch\u1EE7");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new StudentHome(mssv, name);
				StudentHome.main(mssv, name);
				frame.dispose();
			}
		});
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(lblNewLabel_3);
		
		JMenu mnNewMenu = new JMenu("Danh m\u1EE5c h\u1ECDc ph\u1EA7n");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDanhMcHc = new JMenuItem("Danh mục học phần");
		mnNewMenu.add(mntmDanhMcHc);
		
		JMenuItem mntmChngTrnho = new JMenuItem("Chương trình đào tạo sinh viên");
		mnNewMenu.add(mntmChngTrnho);
		
		JMenu mnNewMenu_1 = new JMenu("Th\u00F4ng tin c\u00E1 nh\u00E2n");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmiMtKhu = new JMenuItem("Đổi mật khẩu");
		mntmiMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DoiMatKhau();
				DoiMatKhau.main(null);
			}
		});
		mnNewMenu_1.add(mntmiMtKhu);
		
		JMenuItem mntmThngTinC = new JMenuItem("Thông tin cá nhân");
		mnNewMenu_1.add(mntmThngTinC);
		
		JMenuItem mntmCpNhtH = new JMenuItem("Cập nhật hồ sơ sinh viên");
		mnNewMenu_1.add(mntmCpNhtH);
		
		JMenu mnNewMenu_2 = new JMenu("K\u1EBF ho\u1EA1ch h\u1ECDc t\u1EADp");
		mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmBiu = new JMenuItem("Biểu đồ");
		mnNewMenu_2.add(mntmBiu);
		
		JMenuItem mntmThiKhaBiu = new JMenuItem("Thời khóa biểu");
		mntmThiKhaBiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TKBStudent.main(mssv, name);
				frame.dispose();
			}
			
			
		});
		mnNewMenu_2.add(mntmThiKhaBiu);
		
		JMenu mnNewMenu_3 = new JMenu("K\u1EBF qu\u1EA3 h\u1ECDc t\u1EADp");
		mnNewMenu_3.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmBngimC = new JMenuItem("Bảng điểm cá nhân");
		mntmBngimC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new XemBangDiemCaNhan(mssv,name);
				XemBangDiemCaNhan.main(mssv, name);
			}
		});
		mnNewMenu_3.add(mntmBngimC);
		
		JMenuItem mntmBngimHc = new JMenuItem("Bảng điểm học phần");
		mnNewMenu_3.add(mntmBngimHc);
		
		JMenuItem mntmTraCuim = new JMenuItem("Tra cứu điểm thi Toeic");
		mntmTraCuim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XemDiemToeic.main(mssv, name);
				frame.dispose();
			}
		});
		mnNewMenu_3.add(mntmTraCuim);
		
		JMenu mnNewMenu_4 = new JMenu("Đăng ký học tập");
		mnNewMenu_4.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmngKHc = new JMenuItem("Đăng ký học phần");
		mntmngKHc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DangKyHocPhan(mssv,name).main(mssv,name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_4.add(mntmngKHc);
		
		JMenuItem mntmngKHc_1 = new JMenuItem("Đăng ký học phần tự do");
		mnNewMenu_4.add(mntmngKHc_1);
		
		JMenuItem mntmngKPhn = new JMenuItem("Đăng ký phân ngành");
		mnNewMenu_4.add(mntmngKPhn);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng ký xét nhận đồ án tốt nghiệp");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmngKTt = new JMenuItem("Đăng ký tốt ghiệp");
		mnNewMenu_4.add(mntmngKTt);
		
		JMenu mnNewMenu_5 = new JMenu("Tra c\u1EE9u");
		mnNewMenu_5.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmDanhSchLp = new JMenuItem("Danh sách lớp sinh viên");
		mnNewMenu_5.add(mntmDanhSchLp);
		
		JMenuItem mntmSinhVinng = new JMenuItem("Sinh viên đăng ký học tập");
		mnNewMenu_5.add(mntmSinhVinng);
		
		JMenuItem mntmKtQuPhn = new JMenuItem("Kết quả phân khoa viện");
		mnNewMenu_5.add(mntmKtQuPhn);
		
		JMenuItem mntmTraCuHc = new JMenuItem("Tra cứu học phí SV");
		mntmTraCuHc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TraCuuHocPhi(mssv, name);
				TraCuuHocPhi.main(mssv, name);
			}
		});
		mnNewMenu_5.add(mntmTraCuHc);
		
		JMenu mnTrngCu = new JMenu("Tr\u01B0ng c\u1EA7u \u00FD ki\u1EBFn");
		mnTrngCu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnTrngCu);
		
		JMenuItem mntmGpTrang = new JMenuItem("Góp ý trang Web");
		mnTrngCu.add(mntmGpTrang);
		
		JMenu mnHngDn = new JMenu("H\u01B0\u1EDBng d\u1EABn");
		mnHngDn.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnHngDn);
		
		JMenuItem mntmHngDnng = new JMenuItem("Hướng dẫn đăng ký lớp");
		mnHngDn.add(mntmHngDnng);
		
		JMenu mnMcRing = new JMenu("M\u1EE5c ri\u00EAng");
		mnMcRing.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnMcRing);
		
		JLabel lblSinhVinng = new JLabel("SINH VIÊN ĐĂNG KÍ LỚP HỌC");
		lblSinhVinng.setBounds(261, 32, 210, 26);
		lblSinhVinng.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblSinhVinng);
		model = new DefaultTableModel(
				new Object[][] {
					{"M\u00E3 l\u1EDBp", "M\u00E3 HP", "Th\u1EDDi gian", "Tu\u1EA7n", "\u0110\u1ECBa \u0111i\u1EC3m ", "S\u1ED1 SV", "Max", "ghi ch\u00FA ", "H\u1ECDc k\u00EC"},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			);
		
		JLabel lblNhpMLp = new JLabel("Nhập mã lớp");
		lblNhpMLp.setBounds(30, 101, 89, 26);
		panel_1.add(lblNhpMLp);
		
		textField = new JTextField();
		textField.setBounds(129, 104, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Đăng kí");
		button.setBounds(226, 103, 89, 23);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dangKi(mssv,name);
			}
		});
		panel_1.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 744, 167);
		panel_1.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(
				new Object[][] {
					},
				new String[] {
					"Mã lớp", "Mã HP", "Thời gian", "Tuần học", "Địa điểm", "Số SV", "Max", "Trạng thái", "Học kì", "Ghi chú"
				}
			);
		table.setModel(model);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				label_2.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			}
		});
		scrollPane.setViewportView(table);;
		
		JLabel lblDanhSchLp = new JLabel("Danh sách lớp học");
		lblDanhSchLp.setBounds(30, 135, 140, 26);
		panel_1.add(lblDanhSchLp);
		
		JLabel lblSinhVin = new JLabel("Sinh viên");
		lblSinhVin.setBounds(30, 69, 75, 21);
		panel_1.add(lblSinhVin);
		
		JLabel lblMssv = new JLabel("MSSV :");
		lblMssv.setBounds(298, 69, 50, 21);
		panel_1.add(lblMssv);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBounds(129, 69, 159, 24);
		label.setText(name);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBounds(361, 70, 50, 21);
		label_1.setText(mssv);
		panel_1.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(348, 101, 123, 26);
		panel_1.add(label_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 364, 744, 118);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		model1 = new DefaultTableModel(
				new Object[][] {
					},
				new String[] {
					"Mã lớp", "Mã HP", "Thời gian", "Tuần học", "Địa điểm", "Số SV", "Max", "Trạng thái", "Học kì", "Ghi chú"
				}
			);
		table_1.setModel(model1);
		scrollPane_1.setViewportView(table_1);
		list(mssv);
		JLabel lblDanhSchLp_1 = new JLabel("Danh sách lớp đã đăng kí");
		lblDanhSchLp_1.setBounds(20, 336, 182, 21);
		panel_1.add(lblDanhSchLp_1);
		frame.getContentPane().setLayout(groupLayout);
		LopController lop = new LopController();
		ResultSet rs = lop.lop.getData_Lop();
		try {
			while(rs.next()) {
				Lop a = new Lop();
				a.setMaLop(rs.getString("MaLop"));
				a.setMaHP(rs.getString("MaHP"));
				a.setThoigian(rs.getString("Thoigian"));
				a.setDiadiem(rs.getString("Diadiem"));
				a.setSosv(rs.getInt("Sosv"));
				a.setTrangthai(rs.getString("trangthai"));
				a.setGhichu(rs.getString("Ghichu"));
				
				a.setHocky(rs.getString("Hocky"));
				a.setTuanhoc(rs.getString("Tuanhoc"));
				a.setMax(rs.getInt("MaxSV"));
				Object[] obj = {
					a.getMaLop(),a.getMaHP(),a.getThoigian(),a.getTuanhoc(),a.getDiadiem(),a.getSosv(),a.getMax(),a.getTrangthai(),a.getHocky(),""
				};
				model.addRow(obj);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Hàm đăng kí lớp học
	 * @param mssv Mã số sinh viên
	 * @param name Tên của sinh viên
	 * @throws SQLException nếu không truy vấn được dữ liệu
	 */
	private void dangKi(String mssv, String name) {
		
		LopController lop  = new LopController();
		ConnectMysql.Connect();
		ResultSet rs1 = lop.lop.getData_Lop();
		if(lop.checkMaLop(rs1, textField)== false)
			JOptionPane.showInternalMessageDialog(null, "mã lớp không chính xác");
		else {
			LopController lop1 = new LopController();
			ResultSet rs = lop1.lop.getData_Lop();
			try {
				while(rs.next()) {
					if(rs.getString("MaLop").equals(textField.getText()))
						label_2.setText(rs.getString("MaHP"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			DangkyhocphanController dkhp = new DangkyhocphanController();
			if(dkhp.checkDangKiHocPhan(dkhp.dkhp.getData_DangkyHocphan(mssv, "20182"), label_2.getText())==false) {
				System.out.println(label_2.getText());
				JOptionPane.showMessageDialog(null, "Sinh viên này chưa đăng kí học phần");
			}
			else {
			
			BangDiemController bangdiem = new BangDiemController();
			ConnectMysql.Connect();
			ResultSet rs2 = bangdiem.bangdiem.countSV(textField.getText());
			ResultSet rs3 = lop.lop.getData_Lop();
			Lop a = new Lop();
			a.setMaLop(textField.getText());	
			try {
				while(rs3.next()) {
					if(a.getMaLop().equals(rs3.getString("MaLop"))) {
						a.setHocky(rs3.getString("Hocky"));
						a.setSosv(rs3.getInt("Sosv"));
						a.setMax(rs3.getInt("MaxSV"));
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				while(rs2.next()) {
					
					if(lop.checkMaLop(rs2, textField)==false) {
						bangdiem.bangdiem.dangKiMonHoc(mssv, textField.getText(), a.getHocky());
						JOptionPane.showMessageDialog(null, "Sinh viên đăng kí lớp học thành công");
						break;
					} else if(bangdiem.checkMssv(rs2, mssv)==false&&a.getSosv()<a.getMax()) {
						bangdiem.bangdiem.dangKiMonHoc(mssv, textField.getText(), a.getHocky());
						JOptionPane.showMessageDialog(null, "Sinh viên đăng kí lớp học thành công 2");
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi: Sinh viên đã đăng kí lớp này hoặc lớp đã đầy hoặc không đúng kì học");
						break;
					}
						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			list(mssv);
		}
	}
	private void list(String mssv) {
		LopController lop = new LopController();
		ConnectMysql.Connect();
		model1.setRowCount(0);
		ResultSet rs = lop.lop.getData_LopMSSV(mssv);
		try {
			while(rs.next()) {
				Lop a = new Lop();
				a.setMaLop(rs.getString("MaLop"));
				a.setMaHP(rs.getString("MaHP"));
				a.setThoigian(rs.getString("Thoigian"));
				a.setDiadiem(rs.getString("Diadiem"));
				a.setSosv(rs.getInt("Sosv"));
				a.setTrangthai(rs.getString("trangthai"));
				a.setGhichu(rs.getString("Ghichu"));
				
				a.setHocky(rs.getString("Hocky"));
				a.setTuanhoc(rs.getString("Tuanhoc"));
				a.setMax(rs.getInt("MaxSV"));
				Object[] obj = {
					a.getMaLop(),a.getMaHP(),a.getThoigian(),a.getTuanhoc(),a.getDiadiem(),a.getSosv(),a.getMax(),a.getTrangthai(),a.getHocky(),""
				};
				model1.addRow(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
