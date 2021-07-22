package data_access;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class Lop {

	private String MaLop;
	private String MaHP;
	private String Thoigian;
	private String Diadiem;
	private int Sosv;
	private String Trangthai;
	private String Ghichu;
	private String Hocky;
	private String tuanhoc;
	private int max;
	public String getTuanhoc() {
		return tuanhoc;
	}
	public void setTuanhoc(String tuanhoc) {
		this.tuanhoc = tuanhoc;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public String getMaHP() {
		return MaHP;
	}
	public void setMaHP(String maHP) {
		MaHP = maHP;
	}
	public String getThoigian() {
		return Thoigian;
	}
	public void setThoigian(String thoigian) {
		Thoigian = thoigian;
	}
	public String getDiadiem() {
		return Diadiem;
	}
	public void setDiadiem(String diadiem) {
		Diadiem = diadiem;
	}
	public int getSosv() {
		return Sosv;
	}
	public void setSosv(int sosv) {
		Sosv = sosv;
	}
	public String getTrangthai() {
		return Trangthai;
	}
	public void setTrangthai(String trangthai) {
		Trangthai = trangthai;
	}
	public String getGhichu() {
		return Ghichu;
	}
	public void setGhichu(String ghichu) {
		Ghichu = ghichu;
	}
	public String getHocky() {
		return Hocky;
	}
	public void setHocky(String hocky) {
		Hocky = hocky;
	}
	@Override
	public String toString() {
		return "Lop [MaLop=" + MaLop + ", MaHP=" + MaHP + ", Thoigian=" + Thoigian + ", Diadiem=" + Diadiem + ", Sosv="
				+ Sosv + ", Trangthai=" + Trangthai + ", Ghichu=" + Ghichu + ", Hocky=" + Hocky + "]";
	}
	
	
}
