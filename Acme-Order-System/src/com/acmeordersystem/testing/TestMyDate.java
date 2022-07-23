package com.acmeordersystem.testing;

import com.acmeordersystem.utils.MyDate;

public class TestMyDate{

	public static void main(String[] args) {
		MyDate date1 = new MyDate((byte)11, (byte)11,1918);

		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);

		MyDate date3 = new MyDate();
		date3.setDate((byte)4, (byte)21,1968);

		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		// tests the method leapYears()
		// MyDate.leapYears();
	}

}