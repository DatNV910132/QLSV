package value_object;

/**
 * @author Dom
 *
 */
public class Hocphan {
	private String MaHP;
	private String TenHP;
	private int Sotinchi;
	private int Tinchihocphi;
	private String Thoiluong;
	private int Trongso;
	public String getMaHP() {
		return MaHP;
	}
	public void setMaHP(String maHP) {
		MaHP = maHP;
	}
	public String getTenHP() {
		return TenHP;
	}
	public void setTenHP(String tenHP) {
		TenHP = tenHP;
	}
	public int getSotinchi() {
		return Sotinchi;
	}
	public void setSotinchi(int sotinchi) {
		Sotinchi = sotinchi;
	}
	public int getTinchihocphi() {
		return Tinchihocphi;
	}
	public void setTinchihocphi(int tinchihocphi) {
		Tinchihocphi = tinchihocphi;
	}
	public String getThoiluong() {
		return Thoiluong;
	}
	public void setThoiluong(String thoiluong) {
		Thoiluong = thoiluong;
	}
	public int getTrongso() {
		return Trongso;
	}
	public void setTrongso(int trongso) {
		Trongso = trongso;
	}
	@Override
	public String toString() {
		return "Hocphan [MaHP=" + MaHP + ", TenHP=" + TenHP + ", Sotinchi=" + Sotinchi + ", Tinchihocphi="
				+ Tinchihocphi + ", Thoiluong=" + Thoiluong + ", Trongso=" + Trongso + "]";
	}
	
	
}
