package com.avantsystems.integrator.problems;

import java.util.Arrays;

public class HourGlass {

    //int[][] input = new int[6][6];
    public static final int[][] rawArr  = {
            {-9, -9, -9,  1, 1, 1},
            { 0, -9,  0,  4, 3, 2},
            {-9, -9, -9,  1, 2, 3},
            {0,  0, 8,  6, 6, 0},
            {0,  0,  0, -2, 0, 0},
            {0,  0,  1,  2, 4, 0}
    };


    void process(){

        for (int i = 0; i < rawArr.length; i++){
            int[] row  = rawArr[i];
            //System.out.println(Arrays.toString(row));

            for (int j = 0; j < row.length; j++) {
                int element = rawArr[i][j];
                System.out.println(element);
            }
        }

    }

    public static void main(String[] args) {
        new HourGlass().process();
    }





}
