package com.acmeordersystem.testing;

import com.acmeordersystem.utils.MyDate;

public class TestMyDate{

	public static void main(String[] args) {
		MyDate date1 = new MyDate((byte)11, (byte)11, (short)1918);

		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear((short)1918);

		MyDate date3 = new MyDate();
		date3.setDate((byte)4, (byte)21, (short)1968);

		// Non-valid date detection test.
		date3.setDate((byte)13, (byte)40, (short)-1);

		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		// tests the method leapYears()
		// MyDate.leapYears();

		MyDate newYear = new MyDate((byte)1, (byte)1, (short)2009);
		MyDate fiscalStart = new MyDate((byte)1, (byte)1, (short)2009);

		if (newYear.equals(fiscalStart))
			System.out.println("These two dates are equal");
		else
			System.out.println("These two dates are not equal");

		// Lists all holidays
		MyDate.listHolidays();
	}

}
