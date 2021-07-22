package data_access;

import java.sql.Date;

/**
 * @author Dom
 *
 */
public class Sinhvien {
	private String Mssv;
	private String Password;
	private String Name;
	private String Gioitinh;
	private Date ngaysinh;
	private String Cmnd;
	private String Dantoc;
	private String Diachi;
	private String Sdt;
	private String Email;
	private String Lopsv;
	private String Chuyennganhhoc;
	private String Hehoc;
	private String Tinhtrang;
	public String getMssv() {
		return Mssv;
	}

	public void setMssv(String mssv) {
		Mssv = mssv;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGioitinh() {
		return Gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getCmnd() {
		return Cmnd;
	}

	public void setCmnd(String cmnd) {
		Cmnd = cmnd;
	}

	public String getDantoc() {
		return Dantoc;
	}

	public void setDantoc(String dantoc) {
		Dantoc = dantoc;
	}

	

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getChuyennganhhoc() {
		return Chuyennganhhoc;
	}

	public void setChuyennganhhoc(String chuyennganhhoc) {
		Chuyennganhhoc = chuyennganhhoc;
	}

	public String getHehoc() {
		return Hehoc;
	}

	public void setHehoc(String hehoc) {
		Hehoc = hehoc;
	}

	public String getTinhtrang() {
		return Tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		Tinhtrang = tinhtrang;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLopsv() {
		return Lopsv;
	}

	public void setLopsv(String lopsv) {
		Lopsv = lopsv;
	}

	@Override
	public String toString() {
		return "Sinhvien [Mssv=" + Mssv + ", Password=" + Password + ", Name=" + Name + ", Gioitinh=" + Gioitinh
				+ ", ngaysinh=" + ngaysinh + ", Cmnd=" + Cmnd + ", Dantoc=" + Dantoc + ", Diachi=" + Diachi + ", Sdt="
				+ Sdt + ", Email=" + Email + ", Lopsv=" + Lopsv + ", Chuyennganhhoc=" + Chuyennganhhoc + ", Hehoc="
				+ Hehoc + ", Tinhtrang=" + Tinhtrang + "]";
	}

	

}
