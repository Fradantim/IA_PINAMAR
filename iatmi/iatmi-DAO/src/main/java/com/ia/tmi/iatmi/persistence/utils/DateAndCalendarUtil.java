package com.ia.tmi.iatmi.persistence.utils;

import java.util.Calendar;
import java.util.Date;

public class DateAndCalendarUtil {

	// Convert Date to Calendar
	private static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	public static int mesDelAnio(Date in) {
		return dateToCalendar(in).get(Calendar.MONTH);
	}

	public static int restarHoras(Date in, Date out) {
		return dateToCalendar(out).get(Calendar.HOUR) - dateToCalendar(in).get(Calendar.HOUR);
	}
}
