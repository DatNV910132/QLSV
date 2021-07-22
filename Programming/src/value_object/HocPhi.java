package value_object;

public class HocPhi {
	private String MaLop;
	private String Thoigian;
	private String MaHP;
	private String TenHP;
	private int Sotc;
	private int TCHP;
	private String Ghichu;

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getThoigian() {
		return Thoigian;
	}

	public void setThoigian(String thoigian) {
		Thoigian = thoigian;
	}

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

	public int getSotc() {
		return Sotc;
	}

	public void setSotc(int sotc) {
		Sotc = sotc;
	}

	public int getTCHP() {
		return TCHP;
	}

	public void setTCHP(int tCHP) {
		TCHP = tCHP;
	}

	public String getGhichu() {
		return Ghichu;
	}

	public void setGhichu(String ghichu) {
		Ghichu = ghichu;
	}

	@Override
	public String toString() {
		return "HocPhi [MaLop=" + MaLop + ", Thoigian=" + Thoigian + ", MaHP=" + MaHP + ", TenHP=" + TenHP
				+ ", Sotc=" + Sotc + ", TCHP=" + TCHP + ", Ghichu=" + Ghichu + "]";
	}

}
