package app.resources;

import java.sql.Date;

public class Util {
	public static Date SplitDate(String fecha) {
		String [] arrayFecha=fecha.split("-");
		return new Date(Integer.parseInt(arrayFecha[2]),Integer.parseInt(arrayFecha[1]),Integer.parseInt(arrayFecha[0]));
	}
	public static Date FormatDate(Date date) {
		date.setMonth(date.getMonth()-1);
		date.setYear(date.getYear()-1900);
		return date;
	}
}
