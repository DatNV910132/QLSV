package data_access;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class DiemThiToeic {
	private String mssv;
	private String hocki;
	private String ngaythi;
	private int diemnghe;
	private int diemdoc;
	private int diemtong;
	private String ghichu;
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHocki() {
		return hocki;
	}
	public void setHocki(String hocki) {
		this.hocki = hocki;
	}
	
	public String getNgaythi() {
		return ngaythi;
	}
	public void setNgaythi(String ngaythi) {
		this.ngaythi = ngaythi;
	}
	public int getDiemnghe() {
		return diemnghe;
	}
	public void setDiemnghe(int diemnghe) {
		this.diemnghe = diemnghe;
	}
	public int getDiemdoc() {
		return diemdoc;
	}
	public void setDiemdoc(int diemdoc) {
		this.diemdoc = diemdoc;
	}
	public int getDiemtong() {
		return diemtong;
	}
	public void setDiemtong(int diemtong) {
		this.diemtong = diemtong;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sinh vien: mssv= " + mssv + ",hoc ki " + hocki + ",ngay thi " + ngaythi + ",diem nghe " + diemnghe + ",diem doc " + diemdoc + ",diem tong " + diemtong + ",ghi chu " + ghichu;
	}
}
