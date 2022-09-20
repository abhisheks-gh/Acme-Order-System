package com.acmeordersystem.utils;

 /*
 Note: Java already have predefined classes for this purpose.
 import java.util.Date;
 import java.util.Calendar;
  */

public class MyDate {
    private byte day;
    private byte month;
    private short year;
    private boolean leapYear = true;

    private static MyDate[] holidays;

    static {
        holidays = new MyDate[6];

        // New Year's Date: January 1
        holidays[0] = new MyDate((byte)1, (byte)1, (short)2012);
        // Memorials Day: May 5
        holidays[1] = new MyDate((byte)5, (byte)30, (short)2012);
        // Independence day: July 4
        holidays[2] = new MyDate((byte)7, (byte)4, (short)2012);
        // Labor Day: September 5
        holidays[3] = new MyDate((byte)9, (byte)5, (short)2012);
        // Thanksgiving: November 24
        holidays[4] = new MyDate((byte)11, (byte)24, (short)2012);
        // Christmas: December 25
        holidays[5] = new MyDate((byte)12, (byte)25, (short)2012);
    }

    public int getDay() { return day; }

    /** Sets day and also check if day is ok. */
    public void setDay(int day) {
        if (valid(day, this.month, this.year)) {
            this.day = (byte)day;
        }
    }

    public int getMonth() {
        return month;
    }

    /** Sets month and also check if month is ok. */
    public void setMonth(int month) {
        if (valid(this.day, month, this.year)) {
            this.month = (byte)month;
        }
    }

    public int getYear() {
        return year;
    }

    /** Sets year and also check if year is ok. */
    public void setYear(short year) {
        if (valid(this.day, this.month, year)) {
            this.year = year;
        }
    }

    public boolean isLeapYear() {
        return leapYear;
    }

    /** Sets boolean value to 'leapYear'. */
    public void setLeapYear(boolean leapYear) {
        this.leapYear = leapYear;
    }

    public static MyDate[] getHolidays() { return holidays; }

    /** Lists all holidays */
    public static void listHolidays() {
        System.out.println("The holidays are: ");
        for (int i = 0; i < holidays.length; i++) {
            System.out.println(holidays[i]);
        }
    }

     /**
     * The default constructor, if used as it stands, could result in a date being
     * created with 0 as the day, month, or year.

     * No-args constructor so that the default constructor of the class can be used. */
    public MyDate() {
        this((byte)1, (byte)1, (short)1990); }  // Chained Constructors (sets date to a default date)

    /** MyDate constructor */
    public MyDate(byte m, byte d, short y) {
        setDate(m, d, y);
    }

    // Created object of MyDate class
    MyDate myDate;


    /** Checks whether a 'date' is valid or not. */
    private boolean valid(int day, int month, int year) {
        boolean isValid = true;
        if (day > 31 || day < 1 || month > 12 || month < 1) {
            System.out.println("Attempting to create a non-valid date: "  + month + "/" + day + "/" + year);
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
    public void setDate(byte m, byte d, short y) {
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

        for (int i = 1752; i <= 2020; i++) {
            // Leap years
            if (i % 4 == 0 && i % 100 != 0) {
                System.out.println("The year " + i + " is a leap year");

            } else if (i % 4 == 0 && i % 100 == 0 && i % 400 == 0) {
                System.out.println("The year " + i + " is a leap year");
            } else {
                boolean leapYearResult = !(leapYear.isLeapYear());
            }
        }
    }

    /** Sets day to 'day' to the next 'day' i.e. "tomorrow". */
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

    // @Override
    public boolean equals(Object o) {
        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;
            if ((d.day == day) && (d.month == month) && (d.year == year))
                return true;
        }
        return false;
    }

}
