package geeks.arrays;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumIncreasingSequence {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int totalTestCases = sc.nextInt();

        while (totalTestCases > 0) {
            final int noOfElements = sc.nextInt();
            final int[] inputs = new int[noOfElements];

            for (int index = 0; index < noOfElements; index++) {
                inputs[index] = sc.nextInt();
            }
            System.out.println(getMaxSumIncreasingSequence(inputs));
            totalTestCases--;
        }
    }

    private static int getMaxSumIncreasingSequence(int[] arr) {

        int[] sum = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            sum[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && sum[i] < sum[j] + arr[i]) {
                    sum[i] = sum[j] + arr[i];
                }
            }
        }
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(sum[i]>maxSum){
                maxSum=sum[i];
            }
        }
        return maxSum;
    }

    private static void printArray(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i] +" ");
        }
        System.out.println();
    }

}