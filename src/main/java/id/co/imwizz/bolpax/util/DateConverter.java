package id.co.imwizz.bolpax.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
	
	public static final String SIMPLE_DATE = "dd/MM/yyyy";
	public static final String COMPLETE_DATE = "MMMMM d, yyyy, KK:mm a";
	
	public static String parseDate(String pattern, Date originDate) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String formattedDate = format.format(originDate);
		
		return formattedDate;
	}
	
//	public static void main(String[] args) {
//		System.out.println(parseDate(SIMPLE_DATE, Calendar.getInstance().getTime()));
//		System.out.println(parseDate(COMPLETE_DATE, Calendar.getInstance().getTime()));
//	}

}
