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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import business_logic.ControllTracuuHocphi;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Dom
 *
 */
public class TraCuuHocPhi {

	private JFrame frame;
	private JTable table;
	private JComboBox<?> cBHocky;
	DefaultTableModel modelhp;
	private JLabel lbTongTC;
	private JLabel lbHocphi;

	/**
	 * Launch the application.
	 */
	public static void main(String mssv, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraCuuHocPhi window = new TraCuuHocPhi(mssv, name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TraCuuHocPhi(String mssv, String name) {
		initialize(mssv, name);
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(46)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 917, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(36, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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

		JLabel lblNewLabel_2 = new JLabel(
				"H\u1ECDc k\u1EF3 20181,tu\u1EA7n th\u1EE9 10,ng\u00E0y 30 th\u00E1ng 10 n\u0103m 2018");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel jbnameconnect = new JLabel("name");
		jbnameconnect.setForeground(Color.WHITE);
		jbnameconnect.setFont(new Font("Arial", Font.PLAIN, 13));
		jbnameconnect.setText(name);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudentInformationSystem).addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblMtKhu)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(jbnameconnect)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnngNhp))
								.addComponent(lblNewLabel_2))
						.addGap(20)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnngNhp)
										.addComponent(lblMtKhu).addComponent(jbnameconnect))
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_2))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblStudentInformationSystem)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1))))
						.addComponent(lblNewLabel))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
				new XemBangDiemCaNhan(mssv, name);
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
					new DangKyHocPhan(mssv, name).main(mssv, name);
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
		mntmSinhVinng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SinhVienDangKiMonHoc(mssv, name);
				// TODO Auto-generated method stub
				SinhVienDangKiMonHoc.main(mssv, name);
			}
		});
		mnNewMenu_5.add(mntmSinhVinng);

		JMenuItem mntmKtQuPhn = new JMenuItem("Kết quả phân khoa viện");
		mnNewMenu_5.add(mntmKtQuPhn);

		JMenuItem mntmTraCuHc = new JMenuItem("Tra cứu học phí SV");
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

		JLabel lblTraCuHc = new JLabel("Tra Cứu Học Phí Sinh Viên");
		lblTraCuHc.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTraCuHc.setBounds(37, 43, 231, 20);
		panel_1.add(lblTraCuHc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 158, 894, 181);
		panel_1.add(scrollPane);

		table = new JTable();

		modelhp = new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã lớp", "Thời gian ", "Tuần", "Phòng", "Mã HP", "Tên lớp", "Ghi chú" });
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 l\u1EDBp", "Th\u1EDDi gian ", "M\u00E3 HP", "T\u00EAn HP", "S\u1ED1 TC",
						"TC H\u1ECDc ph\u00ED", "Ghi ch\u00FA" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		scrollPane.setViewportView(table);

		JLabel label_2 = new JLabel("Học kỳ:");
		label_2.setBounds(37, 80, 70, 15);
		panel_1.add(label_2);

		cBHocky = new JComboBox();
		cBHocky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllTracuuHocphi cthp = new ControllTracuuHocphi();
				cthp.InsertTable(table, mssv, cBHocky.getSelectedItem().toString());
				cthp.TinhHP(table, lbTongTC, lbHocphi);
			}
		});
		cBHocky.setModel(new DefaultComboBoxModel(new String[] { "20181", "20173", "20172", "20171", "20163", "20162",
				"20161", "20153", "20152", "20151" }));
		cBHocky.setBounds(104, 75, 102, 24);
		panel_1.add(cBHocky);

		JLabel lblTngSTn = new JLabel("Tổng số tín chỉ:");
		lblTngSTn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTngSTn.setBounds(20, 362, 97, 21);
		panel_1.add(lblTngSTn);

		lbTongTC = new JLabel("");
		lbTongTC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbTongTC.setBounds(116, 362, 46, 14);
		panel_1.add(lbTongTC);

		JLabel lblHcPhTn = new JLabel("Học phí tín chỉ:");
		lblHcPhTn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHcPhTn.setBounds(20, 394, 86, 21);
		panel_1.add(lblHcPhTn);

		JLabel lblVn = new JLabel("440.000 VNĐ");
		lblVn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVn.setBounds(116, 398, 90, 17);
		panel_1.add(lblVn);

		JLabel lblTngHcPh = new JLabel("Tổng học phí sinh viên:");
		lblTngHcPh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTngHcPh.setBounds(22, 432, 140, 21);
		panel_1.add(lblTngHcPh);

		lbHocphi = new JLabel("");
		lbHocphi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbHocphi.setBounds(165, 426, 125, 27);
		panel_1.add(lbHocphi);

		JLabel lblVn_1 = new JLabel("VNĐ");
		lblVn_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVn_1.setBounds(279, 435, 46, 14);
		panel_1.add(lblVn_1);
		;
		frame.getContentPane().setLayout(groupLayout);
	}
}
