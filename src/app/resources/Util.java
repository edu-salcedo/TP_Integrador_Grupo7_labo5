package app.resources;

import java.sql.Date;
import java.time.LocalDate;

public class Util {
	public static Date SplitDate(String fecha) {
		String [] arrayFecha=fecha.split("-");
		return new Date(Integer.parseInt(arrayFecha[0]),Integer.parseInt(arrayFecha[1]),Integer.parseInt(arrayFecha[2]));
	}
	public static Date FormatDate(Date date) {
		date.setMonth(date.getMonth()-1);
		date.setYear(date.getYear()-1900);
		return date;
	}
	public static Date Now() {
		return new Date(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
	}
}
