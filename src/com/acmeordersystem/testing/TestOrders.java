package com.acmeordersystem.testing;

import com.acmeordersystem.domain.Good;
import com.acmeordersystem.domain.Order;
import com.acmeordersystem.utils.MyDate;
import com.acmeordersystem.domain.Solid;
import com.acmeordersystem.domain.Service;

import java.time.LocalDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// MyDate date3 = new MyDate(5, 20, 2008);
		// Order anotherAnvil = new Order(date3, 200, "Road Runner");
		// System.out.println(anotherAnvil);

		MyDate date1 = new MyDate((byte) 1, (byte) 20, (short) 2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER,
				false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate((byte) 4, (byte) 10, (short) 2008);
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

		MyDate date3 = new MyDate((byte) 4, (byte) 10, (short) 2008);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3, 20000, "Daffy Duck", s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());

		MyDate hammer = new MyDate((byte)9, (byte)20, (byte)2022);

		Order.setRushable(((orderDate, amount) -> amount > 1500));

		// If one month (or more) has placed since an order was created, it should be treated as a priority
		Order.setRushable((orderDate, amount) -> {
			// Create a LocalDate object for now
			LocalDate now = LocalDate.now();
			// Create a LocalDate object for orderDate
			LocalDate orderDatePlus30 = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay());
			// Add one month to the orderDate
			orderDatePlus30 = orderDatePlus30.plusMonths(1);
			// If the current date is after the oderDate + 1 month
			// Order is rushable
			return now.isAfter(orderDatePlus30);
		});

		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder()); // false
	}

}
