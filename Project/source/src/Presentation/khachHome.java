package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import business_logic.SinhVienController;
import data_access.ConnectMysql;
import business_logic.Helper;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;

/**
 * @author Dom
 *
 */
public class khachHome {

	private JFrame frame;
	private JTextField tfTaiKhoan;
	private JPasswordField pfMatKhau;

	/**
	 * @throws SQLException
	 */
	public void Dologin() throws SQLException {
		SinhVienController Connectsql = new SinhVienController();
		ConnectMysql.Connect();
		String taikhoan = tfTaiKhoan.getText();
		String pword = new String(new String(pfMatKhau.getPassword()));
		String password = Helper.MD5encrypt(pword);
		if (tfTaiKhoan.getText().equals("") || pfMatKhau.getPassword().toString().equals("")) {
			JOptionPane.showMessageDialog(frame, "Bạn cần nhập đầy đủ thông tin cần thiết. Hãy nhập lại");
		}
		if (Connectsql.CheckSinhvien(Connectsql.sinhvien.getData_Sinhvien(), taikhoan, password)) {
			ResultSet rs = Connectsql.sinhvien.getData_Sinhvien(taikhoan);
			String name = null;
			if (rs.next()) {
				name = rs.getString(3);
			}
			new StudentHome(taikhoan, name);
			StudentHome.main(taikhoan, name);
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(frame, "Đăng nhập không thành công");
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHome window = new khachHome();
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
	public khachHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);

		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE))
						.addContainerGap(43, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)));
		panel_1.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 929, 21);
		panel_1.add(menuBar);

		JLabel lblTrangCh = new JLabel("Trang ch\u1EE7");
		lblTrangCh.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(lblTrangCh);

		JMenu mnDanhMcHc = new JMenu("Danh m\u1EE5c h\u1ECDc ph\u1EA7n");
		mnDanhMcHc.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnDanhMcHc);

		JMenu mnKHochHc = new JMenu("K\u1EBF ho\u1EA1ch h\u1ECDc t\u1EADp");
		mnKHochHc.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnKHochHc);
		
		JMenuItem mntmThiKhaBiu = new JMenuItem("Thời khóa biểu");
		mntmThiKhaBiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TKBKhach.main(null);
				frame.dispose();
			}
		});
		mnKHochHc.add(mntmThiKhaBiu);

		JMenu mnKQuHc = new JMenu("K\u1EBF qu\u1EA3 h\u1ECDc t\u1EADp");
		mnKQuHc.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnKQuHc);

		JMenu mnngKHc = new JMenu("\u0110\u0103ng k\u00ED h\u1ECDc t\u1EADp");
		mnngKHc.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnngKHc);

		JMenu mnTraCu = new JMenu("Tra c\u1EE9u");
		mnTraCu.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnTraCu);

		JMenu mnHngDn = new JMenu("H\u01B0\u1EDBng d\u1EABn");
		mnHngDn.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnHngDn);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/hust.png")));
		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setForeground(Color.WHITE);
		lblStudentInformationSystem.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel lblHanoiUniversityOf = new JLabel("Hanoi University of Science and Technology");
		lblHanoiUniversityOf.setFont(new Font("Arial", Font.BOLD, 18));
		lblHanoiUniversityOf.setForeground(Color.WHITE);

		JLabel lblTiKhon = new JLabel("T\u00E0i kho\u1EA3n:");
		lblTiKhon.setForeground(Color.WHITE);
		lblTiKhon.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 12));

		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setColumns(10);

		pfMatKhau = new JPasswordField();
		pfMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						Dologin();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Dologin();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));

		JLabel lblHcKtun = new JLabel(
				"H\u1ECDc k\u1EF3 20181,tu\u1EA7n th\u1EE9 10,ng\u00E0y 30 th\u00E1ng 10 n\u0103m 2018");
		lblHcKtun.setForeground(Color.WHITE);
		lblHcKtun.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addComponent(label).addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblStudentInformationSystem).addGap(199)
								.addComponent(lblTiKhon).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfTaiKhoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(15).addComponent(lblMtKhu).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pfMatKhau, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblHanoiUniversityOf)
								.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
								.addComponent(lblHcKtun)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addComponent(label)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblStudentInformationSystem).addComponent(lblTiKhon)
												.addComponent(tfTaiKhoan, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMtKhu)
												.addComponent(pfMatKhau, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblHanoiUniversityOf).addComponent(lblHcKtun))));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 1024, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
