package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import business_logic.SinhVienController;
import data_access.ConnectMysql;
import business_logic.Helper;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

/**
 * @author Dom
 *
 */
public class DoiMatKhau {

	private JFrame frame;
	private JTextField txtTaiKhoan;
	private JPasswordField pfpass;
	private JPasswordField pfnpass;
	private JPasswordField pfcnpass;

	/**
	 * Launch the application.
	 */
	public void DoiPass() {
		SinhVienController Connectsql = new SinhVienController();
		ConnectMysql.Connect();
		if(txtTaiKhoan.getText().equals("") || pfpass.getPassword().toString().equals("") 
				|| pfnpass.getPassword().toString().equals("") || pfcnpass.getPassword().toString().equals("")) {
			JOptionPane.showMessageDialog(frame, "Bạn cần nhập đầy đủ thông tin cần thiết. Hãy nhập lại.");
		}
		if(!String.valueOf(pfnpass.getPassword()).equals(String.valueOf(pfcnpass.getPassword()))) {
			JOptionPane.showMessageDialog(frame, "Nhập lại Password mới. Mật khẩu sai hoặc không hợp lệ");
		}
		char[] np = pfnpass.getPassword();
		String npassword = Helper.MD5encrypt(String.valueOf(np));
		char[] op = pfpass.getPassword();
		String opassword = Helper.MD5encrypt(String.valueOf(op));
		if(Connectsql.CheckSinhvien(Connectsql.sinhvien.getData_Sinhvien(), txtTaiKhoan.getText(), opassword)) {
			Connectsql.sinhvien.UpdatePass("sis.sinhvien",txtTaiKhoan.getText(), npassword );
			JOptionPane.showMessageDialog(frame, "Đổi mật khẩu thành công");
			frame.dispose();
		}else JOptionPane.showMessageDialog(frame, "Đổi mật khẩu không thành công");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau window = new DoiMatKhau();
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
	public DoiMatKhau() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 426);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lbliMtKhu = new JLabel("Đổi mật khẩu");
		lbliMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JButton btnThayi = new JButton("Thay đổi");
		btnThayi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiPass();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblThayiMt = new JLabel("Thay đổi mật khẩu. Mật khẩu mới phải có tối thiểu 8 ký tự");
		
		JLabel lblNewLabel = new JLabel("Student Information System");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblHanoiUniversityOf = new JLabel("Hanoi University of Science and Technology");
		lblHanoiUniversityOf.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(btnThayi)
					.addGap(99)
					.addComponent(btnCancel)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbliMtKhu, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblThayiMt)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(335, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
								.addGap(24)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(lblNewLabel)
					.addContainerGap(373, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblHanoiUniversityOf)
					.addContainerGap(311, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHanoiUniversityOf)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(lbliMtKhu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThayiMt))
					.addGap(15)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThayi)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		
		JLabel lblTiKhon = new JLabel("Tài khoản:");
		lblTiKhon.setBounds(29, 38, 61, 16);
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ:");
		lblMtKhuC.setBounds(29, 83, 74, 16);
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới:");
		lblMtKhuMi.setBounds(29, 126, 82, 16);
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblXcNhnMt = new JLabel("Xác nhận mật khẩu:");
		lblXcNhnMt.setBounds(29, 161, 115, 16);
		lblXcNhnMt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(163, 37, 132, 20);
		txtTaiKhoan.setColumns(10);
		
		pfpass = new JPasswordField();
		pfpass.setBounds(163, 79, 132, 20);
		
		pfnpass = new JPasswordField();
		pfnpass.setBounds(163, 122, 132, 20);
		
		pfcnpass = new JPasswordField();
		pfcnpass.setBounds(163, 157, 132, 20);
		panel.setLayout(null);
		panel.add(lblXcNhnMt);
		panel.add(pfcnpass);
		panel.add(lblTiKhon);
		panel.add(lblMtKhuC);
		panel.add(lblMtKhuMi);
		panel.add(pfnpass);
		panel.add(pfpass);
		panel.add(txtTaiKhoan);
		frame.getContentPane().setLayout(groupLayout);
	}
}
