package geeks.arrays;

import java.util.Scanner;

public class MaxOfSubArray {
    private final static int subArraySize = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfSamples = sc.nextInt();

        while (noOfSamples > 0) {
            final int noOfInputs = sc.nextInt();
            final int subArraySize = sc.nextInt();
            final int arr[] = new int[noOfInputs];

            for (int i = 0; i < noOfInputs; i++) {
                arr[i] = sc.nextInt();
            }
            findMaxOfEachSubArray(arr, subArraySize);
            noOfSamples--;
        }

    }

    private static void findMaxOfEachSubArray(int[] arr, int subArraySize) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length - (subArraySize-1); i++) {
            int maxValue = arr[i];
            for (int j = i + 1; j < i + subArraySize; j++) {
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                }
            }
            sb.append(maxValue).append(" ");
        }
        System.out.println(sb.toString());
    }
}
