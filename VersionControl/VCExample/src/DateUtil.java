import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author TrongDuc
	 */
	public boolean checkDate(int day, int month, int year) {
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day == 31)
				return false;
		}
		if (month == 2) {
			if (!((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
				if (day == 29)
					return false;
			}
		}
		return true;
	}
	public int calculateAge (int year) {
		int years = 0;
		long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(currentTime);
		years = now.get(Calendar.YEAR) - year;
		return years;
	}
}
