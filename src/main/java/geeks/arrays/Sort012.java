package geeks.arrays;


import java.util.Scanner;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases.
 * Then T test cases follow. Each testcases contains two lines of input.
 * The first line denotes the size of the array N.
 * The second lines contains the elements of the array A separated by spaces.
 *
 * Output:
 * For each testcase, print the sorted array.
 *
 * Constraints:
 * 1 <= T <= 500
 * 1 <= N <= 106
 * 0 <= Ai <= 2
 *
 * Example:
 * Input :
 * 2
 * 5
 * 0 2 1 2 0
 * 3
 * 0 1 0
 *
 * Output:
 * 0 0 1 2 2
 * 0 0 1
 */
public class Sort012 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int totalTestCases = sc.nextInt();

        while (totalTestCases > 0) {
            final int noOfElements = sc.nextInt();
            final int[] inputs = new int[noOfElements];

            for (int index = 0; index < noOfElements; index++) {
                inputs[index] = sc.nextInt();
            }
            sort012(noOfElements, inputs);
            totalTestCases--;
        }
      }

    static void sort012(final int noOfElements, final int[] inputs) {
        int low = 0,mid = 0, high = noOfElements-1;

        while(mid <= high) {
            if ( inputs [mid] == 0 ){
                swap( inputs, low++, mid++);
            }else if ( inputs [mid] == 1 ){
                mid++;
            }else{
                swap( inputs, mid, high--);
            }
        }

        printArray(noOfElements, inputs);
    }

    private static void printArray(int noOfElements, int[] inputs) {
        StringBuffer br = new StringBuffer();
        for (int i = 0; i < noOfElements; i++) {
                br.append(inputs[i]).append(" ");
        }
        System.out.println(br.toString());
    }

    private static void swap(int[] inputs, int low, int index) {
        int firstValue = inputs[low];
        inputs[low] = inputs[index];
        inputs[index] = firstValue;
    }
}
