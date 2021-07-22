package data_access;

/**
 * @author Dom
 *
 */
public class Dangkyhocphan {

	private String MaHP;
	private String MSSV;
	private String Ngaydangky;
	private String Trangthai;
	private String Hocky;
	public String getMaHP() {
		return MaHP;
	}
	public void setMaHP(String maHP) {
		MaHP = maHP;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getNgaydangky() {
		return Ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		Ngaydangky = ngaydangky;
	}
	public String getTrangthai() {
		return Trangthai;
	}
	public void setTrangthai(String trangthai) {
		Trangthai = trangthai;
	}
	public String getHocky() {
		return Hocky;
	}
	public void setHocky(String hocky) {
		Hocky = hocky;
	}
	@Override
	public String toString() {
		return "Dangkyhocphan [MaHP=" + MaHP + ", MSSV=" + MSSV + ", Ngaydangky=" + Ngaydangky + ", Trangthai="
				+ Trangthai + ", Hocky=" + Hocky + "]";
	}
	
	
}
