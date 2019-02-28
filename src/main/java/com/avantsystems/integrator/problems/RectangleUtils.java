package com.avantsystems.integrator.problems;

public class RectangleUtils {

    private RectangleUtils(){}

    public static int max(final int p1, final int p2){
        return (p1 >= p2) ? p1 : p2;
    }

    public static int min(final int p1, final int p2){
        return (p1 >= p2) ? p2 : p1;
    }
}
