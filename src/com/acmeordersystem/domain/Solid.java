package com.acmeordersystem.domain;

public class Solid extends Good {
    private double width;
    private double length;
    private double meltingPoint;

    public Solid(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable,
                 double weightPerUofM, double width, double length) {
        // Constructor chaining
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUofM);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(double meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    @Override
    public double volume() {
        return length * width * getHeight();
    }

    @Override
    public String toString() {
        return super.toString() + " that is " + volume() + " " + getUnitOfMeasure() + " in size";
    }

}