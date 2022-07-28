package com.acmeordersystem.domain;

import com.acmeordersystem.domain.Good;

public class Liquid extends Good {
    /** Radius of the liquid’s container */
    private double radius;

    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUofM, double radius) {
        super(name, modelNumber, height, uoM, flammable, wgtPerUofM);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}