package com.acmeordersystem.domain;

public class Liquid extends Good {
    /** Radius of the liquid container */
    private double radius;

    public Liquid(String name, int modelNumber, double height, unitOfMeasureType unitOfMeasure, boolean flammable,
                  double weightPerUofM, double radius) {
        // Constructor chaining
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUofM);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public double volume() {
        return Math.PI * radius * radius * getHeight();
    }

    @Override
    public String toString() {
        return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
    }
}
