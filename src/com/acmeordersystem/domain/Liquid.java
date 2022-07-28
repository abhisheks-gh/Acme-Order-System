package com.acmeordersystem.domain;

public class Liquid extends Good {
    /** Radius of the liquid’s container */
    private double radius;

    public Liquid(String name, int modelNumber, double height, unitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM, double radius) {
        // Constructor chaining
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUofM);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
