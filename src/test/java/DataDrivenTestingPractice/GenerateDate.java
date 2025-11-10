package DataDrivenTestingPractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenerateDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String requiredDate=sim.format(cal.getTime());
	}

}
