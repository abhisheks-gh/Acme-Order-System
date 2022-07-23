package com.acmeordersystem.domain;

import com.acmeordersystem.utils.MyDate;

public class Order {

	MyDate orderDate;
	double orderAmount = 0.00;
    /** Discount offered as per the jobSize */
    double discount = 0.00;
    /** Quantity of orders placed */
    int quantity;
    /** Small ('S') / Medium ('M') / Large ('L') / Extra large ('X') */
    char jobSize;
    double billingAmount;

	String customer;
	String product;

	// static initialization block
	public static double taxRate = 0.05;

	// sets a new tax rate
	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	// compute tax on an amount
	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	// compute tax for an order object
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

	public String toString() {
        return quantity + " ea. " + product + " for " + customer;
	}

	// returns jobSize depending on the quantity of order
	public char jobSize() {
		if (quantity <= 25)
			jobSize = 'S';							// Small
		else if (quantity >= 26 && quantity <= 75)
			jobSize = 'M';							// Medium
		else if (quantity >= 76 && quantity <= 150)
			jobSize = 'L';							// Large
		else if (quantity > 150)
			jobSize = 'X';							// Extra Large

		return jobSize; // (S / M / L / X)
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