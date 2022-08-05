package com.acmeordersystem.utils;

 /*
 Note: Java already have predefined classes for this purpose.
 import java.util.Date;
 import java.util.Calendar;
  */

public class MyDate {
    private byte day;
    private byte month;
    private static int year;
    private boolean leapYear = true;

    // getters
    public int getDay() { return day; }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeapYear() {
        return leapYear;
    }

    // setters
    /** Sets day and also check if day is ok. */
    public void setDay(int day) {
        if (valid(day, this.month, MyDate.year)) {
            this.day = (byte)day;
        }
    }

    /** Sets month and also check if month is ok. */
    public void setMonth(int month) {
        if (valid(this.day, month, MyDate.year)) {
            this.month = (byte)month;
        }
    }

    /** Sets year and also check if year is ok. */
    public void setYear(int year) {
        if (valid(this.day, this.month, year)) {
            MyDate.year = year;
        }
    }

    /** Sets boolean value to 'leapYear'. */
    public void setLeapYear(boolean leapYear) {
        this.leapYear = leapYear;
    }

     /**
     * The default constructor, if used as it stands, could result in a date being
     * created with 0 as the day, month, or year.

     * No-args constructor so that the default constructor of the class can be used. */
    public MyDate() {
        this((byte)1, (byte)1, 1990); }  // Chained Constructors (sets date to a default date)

    /** MyDate constructor */
    public MyDate(byte m, byte d, int y) {
        setDate(m, d, y);
    }

    // Created object of MyDate class
    MyDate myDate;


    /** Checks whether a 'date' is valid or not. */
    private boolean valid(int day, int month, int year) {
        boolean isValid = true;
        if (day > 31 || day < 1 || month > 12 || month < 1) {
            System.out.println("\"Attempting to create a non-valid date: "  + month + "/" + day + "/" + year);
            isValid = false;
        } else {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    isValid = (day <= 30); break;
                case 2:
                    isValid  = (day <= 28 || (day == 29 && year % 4 == 0));
            }
        }
        return isValid;
    }

    /** Displays 'date' */
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /** Resets 'date' */
    public void setDate(byte m, byte d, int y) {
        if (valid(m, d, y))
        month = m;
        day = d;
        year = y;
    }

    /** Checks which years are leap years */
    public static void leapYears() {
        /**
         Some simple calculators use a basic
         loop. Other more accurate calculators use a loop and modulus operator,
         shown in the formula below.
          Every year that is divisible by four is a leap year.
          Of those years, if it can be divided by 100, it is NOT a leap year,
         unless the year is divisible by 400. Then it is a leap year.
         */

        MyDate leapYear = new MyDate();

        for (year = 1752; year <= 2020; year++) {
            // Leap years
            if (year % 4 == 0 && year % 100 != 0) {
                System.out.println("The year " + year + " is a leap year");

            } else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
                System.out.println("The year " + year + " is a leap year");
            } else {
                boolean leapYearResult = !(leapYear.isLeapYear());
            }
        }
    }

    /** Sets 'day' to the next 'day' i.e. "tomorrow". */
    public void tomorrow() {
        if (valid(day + 1, month, year)) {
            day++;
        } else if (valid(day, month + 1, year)) {
            day = 1;
            month++;
        }
        else {
            day = 1;
            month = 1;
            year++;
        }
    }

}
