package com.acmeordersystem.domain;

/** Contains descriptive fields of placed order and methods use to perform operations on them
 * Template for the subclasses Solid and Liquid
 * */
public abstract class Good implements Product {
    public enum UnitOfMeasureType { LITER, GALLON, CUBIC_METER, CUBIC_FEET }
    private String name;
    private int modelNumber;
    private double height;
    private UnitOfMeasureType unitOfMeasure;
    private boolean flammable = true;
    private double weightPerUofM;

    /** No-args Constructor */
    public Good() { }

    /** Constructor */
    public Good(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable,
                double weightPerUofM) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.height = height;
        this.unitOfMeasure = unitOfMeasure;
        this.flammable = flammable;
        this.weightPerUofM = weightPerUofM;
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

    public UnitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
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

    public String toString() {
        return name + "-" + modelNumber;
    }

    /** For Generic good: A consumer product having no brand name or registered trademark */
    public abstract double volume();

    /** weight = volume * weight per unit of measure */
    public double weight() {
        return volume() * weightPerUofM;
    }

    public final boolean canShipViaPostOffice() {
        if (!flammable && weight() < 200) {
            return true;
        } else {
            return false;
        }
    }

}
