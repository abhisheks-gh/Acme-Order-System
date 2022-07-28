package com.acmeordersystem.domain;

public class Good {
    public enum unitOfMeasureType { LITER, GALLON, CUBIC_METER, CUBIC_FEET }
    private String name;
    private int modelNumber;
    private double height;
    private unitOfMeasureType unitOfMeasure;
    private boolean flammable;
    private double weightPerUofM;

    /** Constructor */
    public Good(String name, int modelNumber, double height, unitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.height = height;
        this.unitOfMeasure = unitOfMeasure;
        this.flammable = flammable;
        this.weightPerUofM = weightPerUofM;
    }

    /** No-args Constructor */
    public Good() {
        this();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public unitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(unitOfMeasureType unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public double getWeightPerUofM() {
        return weightPerUofM;
    }

    public void setWeightPerUofM(double weightPerUofM) {
        this.weightPerUofM = weightPerUofM;
    }

}