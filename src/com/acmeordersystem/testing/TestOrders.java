package com.acmeordersystem.testing;

import com.acmeordersystem.domain.Good;
import com.acmeordersystem.domain.Good.UnitOfMeasureType;
import com.acmeordersystem.domain.Order;
import com.acmeordersystem.domain.Service;
import com.acmeordersystem.domain.Solid;
// import com.acmeordersystem.domain.Good;

import java.time.LocalDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//        MyDate date1 = new MyDate(1, 20, 2008);
//        Order anvil = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);
//
//        MyDate date2 = new MyDate(4, 10, 2008);
//        Order balloons = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);

		LocalDate date1 = LocalDate.of(2016, 1, 1);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		LocalDate date2 = LocalDate.of(2008, 4, 10);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, Good.UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.getTaxRate());
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.getTaxRate());
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		LocalDate date3 = LocalDate.of(2008, 5, 20);
		Good anvilOrder = new Solid("Anvil", 4, 3, Good.UnitOfMeasureType.CUBIC_FEET, false, 10, 3, 4);
		Order anotherAnvil = new Order(date3, 200, "Wile E", anvilOrder, 10);
		System.out.println(anotherAnvil);

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		balloons.setQuantity(-200);

		if (anvil.getProduct() instanceof Solid) {
			System.out.println("The volume of the anvil is:  " + ((Solid) anvil.getProduct()).volume());
		}
		if (anvil.getProduct() instanceof Solid) {
			System.out.println("The length of the anvil is:  " + ((Solid) anvil.getProduct()).getLength());
		}

		LocalDate date4 = LocalDate.of(2008, 4, 10);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date4, 20000, "Daffy Duck", s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());

		LocalDate hammerDate = LocalDate.of(2017, 3, 1);
		Solid hammerType = new Solid("Acme Hammer", 281, 0.3, UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3);
		Order hammer = new Order(hammerDate, 10.00, "Wile E Coyote", hammerType, 10);


		Order.setRushable((orderDate, orderAmount) -> {
			// Create a LocalDate object for now.
			LocalDate now = LocalDate.now();
			// Create a LocalDate object for the order date.
			LocalDate orderDatePlus30 = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDayOfMonth());
			// Add one month to the order date.
			orderDatePlus30 = orderDatePlus30.plusMonths(1);
			// If the current date is after the order date + one month,
			// it's rushable.
			return now.isAfter(orderDatePlus30);
		});


		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder()); // false
		System.out.println("Hammer isPriorityOrder: " + hammer.isPriorityOrder()); // False
	}

}
