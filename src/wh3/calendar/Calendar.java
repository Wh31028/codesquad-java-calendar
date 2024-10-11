package wh3.calendar;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;


public class Calendar {
	private final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private HashMap <Date,PlanItem> planMap;
	public Calendar() {
		planMap = new HashMap<Date,PlanItem>();
	}
	
	/**
	 * 
	 * @param date ex: "2017-06-20"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p =new PlanItem(strDate,plan);
		planMap.put(p.getDate(), p);
	}
	public PlanItem searchPlan(String strDate) {
		Date date =PlanItem.getDatefromString(strDate);
		return planMap.get(date);
		
	}
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LEAP_MAX_DAYS[month];
		else
			return MAX_DAYS[month];

	}

	public void printCalendar(int year, int month) {

		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int weekday = getWeekday(year, month, 1);
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.printf("   ");
		}
		// print first line
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		// print from second line to last

		for (int i = count + 1; i <= getMaxDaysOfMonth(year, month); i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		int syear = 1970;

		final int STANDARD_WEEKDAY = 4; // 1970년 1월 1일 Thursday

		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;

	}

}
