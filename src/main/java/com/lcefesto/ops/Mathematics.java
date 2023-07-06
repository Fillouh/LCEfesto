package com.lcefesto.ops;

import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class Mathematics {
    //MATHEMATICS METHOD
    //CLASSIC MATH

    public static double abs(double x) {
        return java.lang.Math.abs(x);
    }

    public static double arcCos(double x) {
        return java.lang.Math.acos(x);
    }

    public static double arcSin(double x) {
        return java.lang.Math.asin(x);
    }

    public static double arcTan(double x) {
        return java.lang.Math.atan(x);
    }

    public static double cubeRoot(double x) {
        return java.lang.Math.cbrt(x);
    }

    public static double cos(double x) {
        return java.lang.Math.cos(x);
    }

    public static double difference(double x, double y) {
        return x - y;
    }

    public static double division(double x, double y) {
        if (y == 0) {
            //da mettere la scritta sul TextField
            throw new IllegalArgumentException("Il divisore non può essere nullo!");
        }
        return x / y;
    }

    public static double exp(double x) {
        return java.lang.Math.exp(x);
    }

    public static double expm1(double x) {
        return java.lang.Math.expm1(x);
    }

    public static double ln(double x) {
        return java.lang.Math.log(x);
    }

    public static double log(double x) {
        return java.lang.Math.log10(x);
    }

    public static double hyperCos(double x) {
        return java.lang.Math.cosh(x);
    }

    public static double hyperSin(double x) {
        return java.lang.Math.sinh(x);
    }

    public static double hyperTan(double x) {
        return java.lang.Math.tanh(x);
    }

    public static double hypot(double x, double y) {
        return java.lang.Math.hypot(x, y);
    }

    public static double max(double x, double y) {
        return java.lang.Math.max(x, y);
    }

    public static double min(double x, double y) {
        return java.lang.Math.min(x, y);
    }

    public static double multiplication(double x, double y) {
        return x * y;
    }

    public static double negate(double x) {
        return 0.0 - x;
    }

    public static double pow(double x, double y) {
        return java.lang.Math.pow(x, y);
    }

    public static double round(double x) {
        return java.lang.Math.round(x);
    }

    public static double sin(double x) {
        return java.lang.Math.sin(x);
    }

    public static double sqrt(double x) {
        return java.lang.Math.sqrt(x);
    }

    public static double sum(double x, double y) {
        return x + y;
    }

    public static double tan(double x) {
        return java.lang.Math.tan(x);
    }
}
