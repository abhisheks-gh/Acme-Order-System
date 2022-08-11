package com.acmeordersystem.testing;

import com.acmeordersystem.domain.Good;
import com.acmeordersystem.domain.Order;
import com.acmeordersystem.utils.MyDate;
import com.acmeordersystem.domain.Solid;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// MyDate date3 = new MyDate(5, 20, 2008);
		// Order anotherAnvil = new Order(date3, 200, "Road Runner");
		// System.out.println(anotherAnvil);

		MyDate date1 = new MyDate((byte)1, (byte)20, (short)2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER,
				false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate((byte)4, (byte)10, (short)2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, Good.UnitOfMeasureType.CUBIC_FEET,
				false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		balloons.setQuantity(-200);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		// Non valid quantity detection test
		balloons.setQuantity(-200);
	}

}
