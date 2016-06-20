import java.util.Scanner;

public class DateApp {

	public static void main(String[] args) {
		int month, day, year, testYear;
		boolean leapYear;
		String yearStr;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the month (XX): ");
		month = scan.nextInt();

		System.out.print("Enter the day (XX): ");
		day = scan.nextInt();

		System.out.print("Enter the year (XXXX): ");
		year = scan.nextInt();

		// display the month calendar
		print(DateUtility.getMonthCal(month, 1, year));

		print("Last day of the month: " + DateUtility.getLastDayOfMonth(month, year));

		print("Formatted date: " + DateUtility.toString(month, day, year, "/"));

		print("Day of Week : " + DateUtility.getDayOfWeek(month, day, year));

		// display the 2nd date from the 1st date

		System.out.print("Enter another month (XX): ");
		int month2 = scan.nextInt();

		System.out.print("Enter another day (XX): ");
		int day2 = scan.nextInt();

		System.out.print("Enter another year (XXXX): ");
		int year2 = scan.nextInt();

		print("The 2nd date subtracted from the first date: "
				+ DateUtility.SubtractTwoDates(month, day, year, month2, day2, year2));

		// display the number of days between today and the entered date
		print("Number of days between today and the second date: "
				+ DateUtility.SubtractFromToday(month2, day2, year2));

		// check to see whether a given year is a leap year
		testYear = 2015;
		leapYear = DateUtility.isLeapYear(year);
		print("Is " + year + " a leap year? " + leapYear);
		testYear = 2016;
		leapYear = DateUtility.isLeapYear(year);
		print("Is " + year + " a leap year? " + leapYear);
		testYear = 1800;
		leapYear = DateUtility.isLeapYear(year);
		print("Is " + year + " a leap year? " + leapYear);

	}

	private static void print(String s) {
		System.out.println(s);
		System.out.println("");
	}

}
