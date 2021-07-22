package value_object;

/**
 * @author Dom
 *
 */
public class Bangdiem {

	private String MaLop;
	private String MSSV;
	private String Hocky;
	private Float DiemQT;
	private Float Diemcuoiky;
	private String Diemheso4;

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	public String getHocky() {
		return Hocky;
	}

	public void setHocky(String hocky) {
		Hocky = hocky;
	}

	public Float getDiemQT() {
		return DiemQT;
	}

	public void setDiemQT(Float diemQT) {
		DiemQT = diemQT;
	}

	public Float getDiemcuoiky() {
		return Diemcuoiky;
	}

	public void setDiemcuoiky(Float diemcuoiky) {
		Diemcuoiky = diemcuoiky;
	}

	public String getDiemheso4() {
		return Diemheso4;
	}

	public void setDiemheso4(String diemheso4) {
		Diemheso4 = diemheso4;
	}

	@Override
	public String toString() {
		return "Bangdiem [MaLop=" + MaLop + ", MSSV=" + MSSV + ", Hocky=" + Hocky + ", DiemQT=" + DiemQT
				+ ", Diemcuoiky=" + Diemcuoiky + ", Diemheso4=" + Diemheso4 + "]";
	}

}
