package com.acmeordersystem.utils;

public class ConversionService {
    /**
     * weight conversion rates
     */
    // conversion rate for 1 kilogram to pounds
    public static double kilogramToPounds = 2.2046;
    // conversion rate for 1 kilogram to grams
    public static int kilogramToGrams = 1000;
    // conversion rate for 1 kilogram to weight ounces
    public static double kilogramToOunces = 35.274;
    /**
     * volume conversion rates
     */
    // conversion rate for 1 liter to fluid ounces
    public static float literToFluidOunce = 33.814f;
    // conversion rate for 1 liter to gallons
    public static float literToGallon = 0.2642f;
    // conversion rate for 1 liter to pints
    public static float literToPints = 2.1134f;
    // conversion rate for 1 liter to milliliters
    public static short litertoMilliliters = 1_000;

    public static double pounds(double kilograms) {
        return kilograms * kilogramToPounds;
    }

    public static int grams(int kilograms) {
        return kilograms * kilogramToGrams;
    }

    public static double ounces(double kilograms) {
        return kilograms * kilogramToOunces;
    }

    public static float fluidOunces(float liters) {
        return liters * literToFluidOunce;
    }

    public static float gallons(float liters) {
        return liters * literToGallon;
    }

    public static float pints(float liters) {
        return liters * literToPints;
    }

    public static int milliliters(int liters) {
        return liters * litertoMilliliters;
    }


    public static void main(String[] args) {

    }
}