package geeks.arrays;

import java.util.Scanner;

/**
 * Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
 *
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consist of two lines of input.
 * The first line of each test case consists of an integer N(size of array) and an integer K separated by a space.
 * The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each test case, print the modified array.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N, K ≤ 107
 * 1 ≤ A[i] ≤ 1018
 *
 * Example:
 * Input
 * 1
 * 5 3
 * 1 2 3 4 5
 *
 * Output
 * 3 2 1 5 4
 *
 * Explanation:
 * Testcase 1: Reversing groups in size 3, first group consists of elements 1, 2, 3. Reversing this group, we have elements in order as 3, 2, 1.
 */
public class ReverseSubArrayOfSizeN {

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
            reverseSubArray(arr, subArraySize);
            noOfSamples--;
        }
    }

    private static void reverseSubArray(int[] arr, int subArraySize) {
        final int size = arr.length;
        int[] reverseArray = new int[size];
        int revSize = 0;

        for (int i = 0; i < size; i++) {
            int nextIndex = i+ subArraySize -1;
            if(  nextIndex > size-1){
                nextIndex = size-1;
            }
            for (int j = nextIndex; j >= i; j--) {
                reverseArray[revSize++] = arr[j];
            }
            i+= subArraySize-1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(reverseArray[i] + " ");
        }
        System.out.println(sb.toString());
    }
}