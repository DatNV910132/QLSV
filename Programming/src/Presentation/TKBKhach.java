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
import javax.swing.table.DefaultTableModel;

import business_logic.SinhVienController;
import business_logic.TKBController;
import data_access.ConnectMysql;
import business_logic.Helper;
import value_object.ThoiKhoaBieu;

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
public class TKBKhach {

	private JFrame frame;
	private JTextField tfTaiKhoan;
	private JPasswordField pfMatKhau;
	private JTextField text;
	private JTable table;
	private JComboBox<?> cBHocky;
	DefaultTableModel model;

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
					TKBKhach window = new TKBKhach();
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
	public TKBKhach() {
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
		lblTrangCh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new khachHome();
				khachHome.main(null);
				frame.dispose();
			}
		});
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

		JLabel label_1 = new JLabel("Xem Thời Khóa Biểu");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_1.setBounds(33, 33, 180, 20);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel();
		label_2.setText("Nhập mã số sinh viên");
		label_2.setBounds(47, 141, 180, 20);
		panel_1.add(label_2);

		text = new JTextField();
		text.setBounds(219, 141, 102, 20);
		panel_1.add(text);

		JButton button = new JButton("Tra cứu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		button.setBounds(336, 141, 90, 20);
		panel_1.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 173, 742, 181);
		panel_1.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã lớp", "Thời gian ", "Tuần", "Phòng", "Mã HP", "Tên lớp", "Ghi chú" });
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		scrollPane.setViewportView(table);

		JLabel lblHojc = new JLabel("Học kỳ:");
		lblHojc.setBounds(152, 102, 70, 15);
		panel_1.add(lblHojc);

		cBHocky = new JComboBox();
		cBHocky.setModel(new DefaultComboBoxModel(new String[] { "20181", "20173", "20172", "20171", "20163", "20162",
				"20161", "20153", "20152", "20151" }));
		cBHocky.setBounds(219, 97, 102, 24);
		panel_1.add(cBHocky);
		;

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new khachHome();
				khachHome.main(null);
				frame.dispose();
			}
		});
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

	private void process() {
		if (text.getText().equals(""))
			text.requestFocus();
		else {
			TKBController connecttkb = new TKBController();
			ConnectMysql.Connect();
			model.setRowCount(0);
			if(connecttkb.checkMssv(connecttkb.tkb.getDataTKB(),text)) {
				ResultSet rs = connecttkb.tkb.getDataTKB_mssv(text.getText(), cBHocky.getSelectedItem().toString());
				try {
					while (rs.next()) {
						ThoiKhoaBieu tkb = new ThoiKhoaBieu();

						tkb.setTime(rs.getString(3));
						tkb.setWeek(rs.getString(4));
						tkb.setRoom(rs.getString(5));
						tkb.setMaLop(rs.getString(2));
	
						tkb.setMaHP(rs.getString(6));
						tkb.setNameClass(rs.getString(7));
						tkb.setGhiChu(rs.getString(8));
						Object[] obj = { tkb.getMaLop(), tkb.getTime(), tkb.getWeek(), tkb.getRoom(), tkb.getMaHP(),
								tkb.getNameClass(), tkb.getGhiChu() };
						model.addRow(obj);
					}
				} catch (SQLException e) {
					e.printStackTrace();
	
				}
				if (model.getRowCount() == 0)
				JOptionPane.showMessageDialog(null, "Sinh viên này không có thời khóa biểu.");
			}
			else 
				JOptionPane.showMessageDialog(null, "Không có sinh viên này.");

		}
	}
}
