// public class Day {
	
// 	private int year;
// 	private int month;
// 	private int day;
	
// 	//Constructor

	
// 	// Return a string for the day like dd MMM yyyy


// 	// check if a given year is a leap year

	
// 	// check if y,m,d valid


// }

public class Day {
    private int day;
    private int month;
    private int year;

    public Day(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public String toString() {
        final String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                     "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return "You have entered " + day + ' ' + monthNames[month - 1] + ' ' + year;
    }

    static public boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    static public boolean valid(int year, int month, int day) {
        if (year < 0 || month < 1 || month > 12 || day < 1)
            return false;
        switch (month) {
           case 1: case 3: case 5: case 7: case 8: case 10: case 12:
              return day <= 31;
            case 4: case 6: case 9: case 11:
              return day <= 30;
            case 2:
                return isLeapYear(year) ? day <= 29 : day <= 28;
        }
        return true;
    }

    static public boolean endOfMonth(int year, int month, int day) {
        if (!valid(year, month, day))
            return false;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
              return day == 31;
            case 4: case 6: case 9: case 11:
              return day == 30;
            case 2:
              return isLeapYear(year) ? day == 29 : day == 28;
        }
        return false;
    }

    static public boolean endOfYear(int year, int month, int day) {
        return month == 12 && day == 31;
    }

    static public String nextDay(int year, int month, int day) {
        final String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                     "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (endOfYear(year, month, day))
            return "The next day is " + "1 Jan " + (year + 1);
        if (endOfMonth(year, month, day)) {
            if (month == 2) {
                return "The next day is " + "1 " + "Mar " + ' ' + year;
            }
            else {
                return "The next day is " + "1 " + monthNames[month] + ' ' + year;
            }
        }
            
        return "The next day is " + (day + 1) + " " + monthNames[month - 1] + ' ' + year;
    }

    static public String preDay(int year, int month, int day) {
        final String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                     "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (day == 1 && month == 1) {
            return "The previous day is " + "31 Dec " + (year - 1);
        }
        if (day == 1) {
            if (month == 3) {
                if (isLeapYear(year)) { // using isValid() and while to try out if the day is supposed to be 31,30,29,28
                    return "The previous day is " + "29 Feb " + year;
                }
                else {
                    return "The previous day is " + "28 Feb " + year;
                }
            }
            else if (month == 5 || month == 7 || month == 10 || month == 12) {
                return "The previous day is " + "30 " + monthNames[month - 2] + ' ' + year;
            }
            else {
                return "The previous day is " + "31 " + monthNames[month - 2] + ' ' + year;
            }
        }
        return "The previous day is " + (day - 1) + " " + monthNames[month - 1] + ' ' + year;
    }


}