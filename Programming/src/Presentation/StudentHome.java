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
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author Dom
 *
 */
public class StudentHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String mssv, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome window = new StudentHome(mssv,name);
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
	public StudentHome(String mssv, String name) {
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE))
					.addContainerGap(45, Short.MAX_VALUE))
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
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Trang ch\u1EE7");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(lblNewLabel_3);
		
		JMenu mnNewMenu = new JMenu("Danh m\u1EE5c h\u1ECDc ph\u1EA7n");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDanhMcHc = new JMenuItem("Danh m???c h???c ph???n");
		mnNewMenu.add(mntmDanhMcHc);
		
		JMenuItem mntmChngTrnho = new JMenuItem("Ch????ng tr??nh ????o t???o sinh vi??n");
		mnNewMenu.add(mntmChngTrnho);
		
		JMenu mnNewMenu_1 = new JMenu("Th\u00F4ng tin c\u00E1 nh\u00E2n");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmiMtKhu = new JMenuItem("?????i m???t kh???u");
		mntmiMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DoiMatKhau();
				DoiMatKhau.main(null);
			}
		});
		mnNewMenu_1.add(mntmiMtKhu);
		
		JMenuItem mntmThngTinC = new JMenuItem("Th??ng tin c?? nh??n");
		mnNewMenu_1.add(mntmThngTinC);
		
		JMenuItem mntmCpNhtH = new JMenuItem("C???p nh???t h??? s?? sinh vi??n");
		mnNewMenu_1.add(mntmCpNhtH);
		
		JMenu mnNewMenu_2 = new JMenu("K\u1EBF ho\u1EA1ch h\u1ECDc t\u1EADp");
		mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmBiu = new JMenuItem("Bi???u ?????");
		mnNewMenu_2.add(mntmBiu);
		
		JMenuItem mntmThiKhaBiu = new JMenuItem("Th???i kh??a bi???u");
		mntmThiKhaBiu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TKBStudent.main(mssv, name);
				frame.dispose();
			}
		});
		mnNewMenu_2.add(mntmThiKhaBiu);
		
		JMenu mnNewMenu_3 = new JMenu("K\u1EBF qu\u1EA3 h\u1ECDc t\u1EADp");
		mnNewMenu_3.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmBngimC = new JMenuItem("B???ng ??i???m c?? nh??n");
		mntmBngimC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new XemBangDiemCaNhan(mssv,name);
				XemBangDiemCaNhan.main(mssv, name);
			}
		});
		mnNewMenu_3.add(mntmBngimC);
		
		JMenuItem mntmBngimHc = new JMenuItem("B???ng ??i???m h???c ph???n");
		mnNewMenu_3.add(mntmBngimHc);
		
		JMenuItem mntmTraCuim = new JMenuItem("Tra c???u ??i???m thi Toeic");
		mntmTraCuim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XemDiemToeic.main(mssv, name);
				frame.dispose();
			}
		});
		mnNewMenu_3.add(mntmTraCuim);
		
		JMenu mnNewMenu_4 = new JMenu("????ng k?? h???c t???p");
		mnNewMenu_4.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmngKHc = new JMenuItem("????ng k?? h???c ph???n");
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
		
		JMenuItem mntmngKHc_1 = new JMenuItem("????ng k?? h???c ph???n t??? do");
		mnNewMenu_4.add(mntmngKHc_1);
		
		JMenuItem mntmngKPhn = new JMenuItem("????ng k?? ph??n ng??nh");
		mnNewMenu_4.add(mntmngKPhn);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("????ng k?? x??t nh???n ????? ??n t???t nghi???p");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmngKTt = new JMenuItem("????ng k?? t???t ghi???p");
		mnNewMenu_4.add(mntmngKTt);
		
		JMenu mnNewMenu_5 = new JMenu("Tra c\u1EE9u");
		mnNewMenu_5.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmDanhSchLp = new JMenuItem("Danh s??ch l???p sinh vi??n");
		mnNewMenu_5.add(mntmDanhSchLp);
		
		JMenuItem mntmSinhVinng = new JMenuItem("Sinh vi??n ????ng k?? h???c t???p");
		mntmSinhVinng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SinhVienDangKiMonHoc(mssv, name);
				// TODO Auto-generated method stub
				SinhVienDangKiMonHoc.main(mssv, name);
				frame.dispose();
			}
		});
		mnNewMenu_5.add(mntmSinhVinng);
		
		JMenuItem mntmKtQuPhn = new JMenuItem("K???t qu??? ph??n khoa vi???n");
		mnNewMenu_5.add(mntmKtQuPhn);
		
		JMenuItem mntmTraCuHc = new JMenuItem("Tra c???u h???c ph?? SV");
		mntmTraCuHc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TraCuuHocPhi(mssv, name);
				TraCuuHocPhi.main(mssv, name);
				frame.dispose();
			}
		});
		mnNewMenu_5.add(mntmTraCuHc);
		
		JMenu mnTrngCu = new JMenu("Tr\u01B0ng c\u1EA7u \u00FD ki\u1EBFn");
		mnTrngCu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnTrngCu);
		
		JMenuItem mntmGpTrang = new JMenuItem("G??p ?? trang Web");
		mnTrngCu.add(mntmGpTrang);
		
		JMenu mnHngDn = new JMenu("H\u01B0\u1EDBng d\u1EABn");
		mnHngDn.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnHngDn);
		
		JMenuItem mntmHngDnng = new JMenuItem("H?????ng d???n ????ng k?? l???p");
		mnHngDn.add(mntmHngDnng);
		
		JMenu mnMcRing = new JMenu("M\u1EE5c ri\u00EAng");
		mnMcRing.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnMcRing);
		frame.getContentPane().setLayout(groupLayout);
	}
	
}
