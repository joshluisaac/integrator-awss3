package com.avantsystems.integrator.problems;

import java.util.Arrays;

public class MatrixRotation {

	static int[] rotateArray(int[] arr,final int d) {
		final int n = arr.length;
		int firstIndexVal = 0;
		for (int i = 0; i < d; i++) {
			firstIndexVal = arr[0];
			for (int j = 1; j < arr.length; j++) {
				arr[j - 1] = arr[j];
				//System.out.println(arr[j]);
			}
			arr[n - 1] = firstIndexVal;
			//System.out.println(Arrays.toString(arr));
		}
		
		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(MatrixRotation.rotateArray(arr, 4)));
	}

}
