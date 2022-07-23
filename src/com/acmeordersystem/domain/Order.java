package com.acmeordersystem.domain;

import com.acmeordersystem.utils.MyDate;

public class Order {

	private MyDate orderDate;
	private double orderAmount = 0.00;
    private double discount = 0.00;	/** Discount offered as per the jobSize */
    private int quantity;	/** Quantity of orders placed */
    private char jobSize;
    private double billingAmount;	/** Small ('S') / Medium ('M') / Large ('L') / Extra large ('X') */
	String customer;
	String product;
	public static double taxRate = 0.05;


	// Getters
	public MyDate getOrderDate() {
		return orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public String getCustomer() { return customer; }

	public String getProduct() { return customer; }

	public int getQuantity() { return quantity; }

	// Setters
	public void setOrderDate(MyDate orderDate) { this.orderDate = orderDate; }

	public void setOrderAmount(double orderAmount) {
		if (orderAmount > 0) { this.orderAmount = orderAmount; }
		else {
			System.out.println("Attempting to set the orderAmount value to a value less than or equal to zero.");
		}
	}

	public void setCustomer(String customer) { this.customer = customer; }

	public void setProduct(String product) { this.product = product; }

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			System.out.println("Attempting to set the quantity to a value less than or equal to zero.");
		}
	}

	public static double getTaxRate() { return taxRate; }

	public static void taxRate(double newRate) { taxRate = newRate; }


	/** Computes tax on an amount */
	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	/** Computes tax for an order object */
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

	public Order(MyDate d, double amt, String c) {
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = "Anvil";
		quantity = 1;
	}

	// sets a new tax rate
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

}
