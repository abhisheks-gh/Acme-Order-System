package com.acmeordersystem.testing;

import com.acmeordersystem.utils.MyDate;

public class PassByExperiment {

    public static void main(String[] args) {
        // Created MyDate object
        MyDate date = new MyDate((byte)1, (byte)20, 2008);

        System.out.println("Before passing an object " + date); // 1/20/2008
        passObject(date);
        System.out.println("After passing an object " + date);  // 1/20/2009

        System.out.println("Before passing a primitive " + date.getYear());    // 2009
        passPrimitive(date.getYear());
        System.out.println("After passing a primitive " + date.getYear()); // 2009

        String x = date.toString();
        System.out.println("Before passing a String " + x); // 1/20/2009
        passString(x);  // 1/20/2012
        System.out.println("After passing a String " + x);  // 1/20/2010
    }

    /**
     * Changes the year of the MyDate object
     */
    public static void passObject(MyDate d) { d.setYear(2009); }

    /**
     * Changes the int to some other year
     */
    public static void passPrimitive(int i) {
        i = 2010;
    }

    /**
     * passes a String that represents a month/day/year and replaces the year
     * portion of the string with a new year. For example, if “1/20/2001” is
     * passed in, “1/20/2012” is passed out.
     */
    public static void passString(String s) {
        int yearSlash = s.lastIndexOf('/');
        s = s.substring(0, yearSlash + 1);    // pass by reference value
        s += "2012";
        System.out.println("New date string: " + s);

        // This function below is an example of pass by value.
        // s.equals(String anotherString); // pass by value
    }

}