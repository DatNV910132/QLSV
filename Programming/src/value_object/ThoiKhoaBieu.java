package value_object;

/**
 * 
 * @author Nguyễn Văn Đạt 20160952
 *
 */
public class ThoiKhoaBieu {
	private String mssv;
	private String time;
	private String week;
	private String room;
	private String maLop;
	private String group;
	private String maHP;
	private String nameClass;
	private String ghiChu;
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getMaHP() {
		return maHP;
	}
	public void setMaHP(String maHP) {
		this.maHP = maHP;
	}
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "ThoiKhoaBieu [mssv=" + mssv + ", time=" + time + ", week=" + week + ", room=" + room + ", maLop="
				+ maLop + ", group=" + group + ", maHP=" + maHP + ", nameClass=" + nameClass + ", ghiChu=" + ghiChu
				+ "]";
	}

	
}
