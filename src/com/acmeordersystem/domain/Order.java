package com.acmeordersystem.domain;

import com.acmeordersystem.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;

	/** Discount offered as per the jobSize */
    private double discount = 0.00;

	/** Quantity of orders placed */
    private int quantity;
    private char jobSize;

	String customer;
	Product product;
	public static double taxRate = 0.05;

	private static Rushable rushable;

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) { this.orderDate = orderDate; }

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (orderAmount > 0) { this.orderAmount = orderAmount; }
		else {
			System.out.println("Attempting to set the orderAmount value to a value less than or equal to zero.");
		}
	}

	public String getCustomer() { return customer; }

	public void setCustomer(String customer) { this.customer = customer; }

	public Product getProduct() { return product; }

	public void setProduct(Product product) { this.product = product; }

	public int getQuantity() { return quantity; }

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			System.out.println("Attempting to set the quantity to a value less than or equal to zero.");
		}
	}

	public static double getTaxRate() { return taxRate; }

	public static void taxRate(double newRate) { taxRate = newRate; }

	public double getDiscount() { return discount; }

	public void setDiscount(double discount) { this.discount = discount; }

	public static Rushable getRushable() { return rushable; }

	public static void setRushable(Rushable rushable) { Order.rushable = rushable; }

	/** Computes tax on an amount */
	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	/** Computes tax for an order object */
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	public Order(MyDate d, double amt, String c, Product p, int q) {
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

	/** Sets new tax rate. */
	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public String toString() {
        return quantity + " ea. " + product + " for " + customer;
	}

	// returns jobSize depending on the quantity of order
	public char jobSize() {
		if (quantity <= 25)
			jobSize = 'S';				// Small
		else if (quantity <= 75)
			jobSize = 'M';				// Medium
		else if (quantity <= 150)
			jobSize = 'L';				// Large

		return 'X'; 					// Extra Large
	}

	/** Computes total billing amount */
	public double computeTotal() {
		double billingAmount;

		if (orderAmount > 1500) {
			// Tax is absorbed if orderAmount > $1500
			billingAmount = orderAmount - discount;
		} else {
			billingAmount = (orderAmount + computeTax()) - computeDiscount();
		}

        return billingAmount;
	}

	/** Computes discount based on the jobSize */
	double computeDiscount() {
		if (jobSize == 'S')
			discount = 0.00;
		else if (jobSize == 'M')
			discount = orderAmount * 0.01;	// discount of 1%
		else if (jobSize == 'L')
			discount = orderAmount * 0.02;	// discount of 2%
		else if (jobSize == 'X')
			discount = orderAmount * 0.03;	// discount of 3%

		return discount;
	}

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}

}
