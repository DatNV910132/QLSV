import javax.swing.JOptionPane;

public class HelloWorld{
        /**
         * @author TrongDuc
         */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		String day;
		String month;
		String year;
		int d,m,y;
		int i = 0;
		name = JOptionPane.showInputDialog("Your Name is:  ");
		DateUtil date = new DateUtil();
		do {
			if(i != 0) JOptionPane.showMessageDialog(null,"Nhap lai ngay thang nam");
			day = JOptionPane.showInputDialog("Ngay sinh:   ");
			month = JOptionPane.showInputDialog("Thang sinh:  ");
			year = JOptionPane.showInputDialog("Nam sinh:  ");
			d = Integer.parseInt(day);
			m = Integer.parseInt(month);
			y = Integer.parseInt(year);
			i++;
		}while (!date.checkDate(d, m, y));

		y = date.calculateAge(y);
		JOptionPane.showMessageDialog(null,"Hello "+name+", Your Age is: "+y);
	}
}