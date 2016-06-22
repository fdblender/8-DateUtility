package dateUtility;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtility {

	public static String getMonthCal(int month, int day, int year) {
		String monthStr = "";
		// create a new calendar and set it's date to the year, month, and first
		// day of month
		Calendar cal = new GregorianCalendar();
		// cal.clear();
		// first month of the year in the Gregorian and Julian calendars is
		// JANUARY which is 0
		cal.set(year, month - 1, 1);

		// monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG,
		// Locale.US).toUpperCase();

		int firstWeekDay = cal.get(Calendar.DAY_OF_WEEK);
		// System.out.println("First Week Day: "+firstWeekDay);

		int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// System.out.println("Last Day of Month: "+lastDayOfMonth);

		monthStr += "\n-----------------------------------" + "\n          "
				+ cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toUpperCase() + " " + year + "\n"
				+ "\n  Sun  Mon Tues  Wed Thur  Fri  Sat\n";

		// print blank spaces before the first day of the month
		for (int i = 1; i < firstWeekDay; i++) {
			monthStr += "     ";
		}

		int currWeekDay = firstWeekDay;
		for (int i = 1; i <= lastDayOfMonth; i++) {
			monthStr += String.format("   %2d", i);
			if (currWeekDay % 7 == 0) {
				monthStr += "\n";
			}
			currWeekDay++;
		}
		monthStr += "\n-----------------------------------";
		return monthStr;
	}

	public static int getLastDayOfMonth(int month, int year) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month - 1, 1);
		return (cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	public static String getDayOfWeek(int month, int day, int year) {
		String dayStr;
		Calendar cal = new GregorianCalendar();
		cal.set(year, month - 1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			dayStr = "Sunday";
			break;
		case 2:
			dayStr = "Monday";
			break;
		case 3:
			dayStr = "Tuesday";
			break;
		case 4:
			dayStr = "Wednesday";
			break;
		case 5:
			dayStr = "Thursday";
			break;
		case 6:
			dayStr = "Friday";
			break;
		case 7:
			dayStr = "Saturday";
			break;
		default:
			dayStr = "";
		}
		return dayStr;
	}

	// subtract the 2nd date from the first date and return ms
	public static long subtractTwoDates(int month1, int day1, int year1, int month2, int day2, int year2) {

		// get todays date in ms
		Calendar gc = new GregorianCalendar();
		gc.set(year1, month1 - 1, day1, 0, 0, 0);
		long firstDateMs = gc.getTimeInMillis();

		// get ms for the given date
		gc.set(year2, month2 - 1, day2, 0, 0, 0);
		long secondDateMs = gc.getTimeInMillis();

		// calculate the difference and convert to days
		long diff = firstDateMs - secondDateMs;
		long millisecondsPerDay = (24 * 60 * 60 * 1000);

		return diff / millisecondsPerDay;
	}

	// calculate the days between today and a given date in ms
	public static long subtractFromToday(int month, int day, int year) {
		// get todays date in ms
		Calendar gc = new GregorianCalendar();
		long todayInMS = gc.getTimeInMillis();

		// get ms for the given date
		gc.set(year, month - 1, day, 0, 0, 0);
		long dateInMS = gc.getTimeInMillis();

		// calculate the difference and convert to days
		long diff = todayInMS - dateInMS;
		long millisecondsPerDay = (24 * 60 * 60 * 1000);

		return diff / millisecondsPerDay;
	}

	// prints the date as mm/dd/yyyy using the delimiter in the class
	public static String toString(int month, int day, int year, String delimiter) {
		return String.format(month + delimiter + day + delimiter + year);
	}

	public static boolean isLeapYear(int year) {
		// returns t/f if the year is a leap year
		// leap years are all years divisible by 4 subtractTwoDatesbut not 100
		// years that are divisible by 400 are leap years, too
		// is it divisible by 4?

		// Note that the year is not passed as an argument. It could be but
		// I choose to use the class level private variable for my method.
		boolean bLeapYear = false;
		bLeapYear = (year % 4 == 0);

		// is it divisible by 4 and not 100
		bLeapYear = bLeapYear && (year % 100 != 0);

		// is it divisible by 4 and not 100 unless it's divisible by 400
		bLeapYear = bLeapYear || (year % 400 == 0);

		return bLeapYear;

	}

}
