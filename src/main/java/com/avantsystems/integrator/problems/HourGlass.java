package com.avantsystems.integrator.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HourGlass {

    private static final int[][] MATRIX  = {
            {-9, -9, -9,  1, 1, 1},
            { 0, -9,  0,  4, 3, 2},
            {-9, -9, -9,  1, 2, 3},
            {0,  0, 8,  6, 6, 0},
            {0,  0,  0, -2, 0, 0},
            {0,  0,  1,  2, 4, 0}
    };

    private List<Integer> sumList = new ArrayList<>();
    private int maxIntVal = Integer.MIN_VALUE;


    public void process(int[][] matrix ){

        int prevVal = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
               int sum =  matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j + 1] + matrix[i + 2][j]
                       + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

               if (sum > maxIntVal) {
                   maxIntVal = sum;
               }
               sumList.add(Integer.valueOf(sum));
            }
        }
        System.out.println(sumList.toString());
    }

    public static void main(String[] args) {
        HourGlass hourGlass = new HourGlass();
        hourGlass.process(HourGlass.MATRIX);
        System.out.println(hourGlass.maxIntVal);
        //Collections.max(hourGlass.sumList);
    }





}
