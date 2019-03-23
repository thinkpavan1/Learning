package geeks.arrays;

import java.util.Scanner;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of two lines.
 * The first line of each test case is N and S, where N is the size of array and S is the sum.
 * The second line of each test case contains N space separated integers denoting the array elements.
 * <p>
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 * <p>
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 */
import java.lang.*;

public class SubArraySum {

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        int noOfSamples = Integer.parseInt(sc.nextLine());

        while (noOfSamples > 0) {

            final int noOfElements = sc.nextInt();
            final int expectedSum = sc.nextInt();

            final int[] inputArray = new int[noOfElements];

            for (int j = 0; j < noOfElements; j++) {
                inputArray[j] = sc.nextInt();
            }
            if( !findSubArrayWithSum(inputArray, noOfElements, expectedSum) )
                System.out.println("-1");

            noOfSamples --;
        }
    }

    static boolean findSubArrayWithSum(final int[] inputs, final int noOfElements, final int expectedSum) {

        int firstIndex = 0;
        int secondIndex = 1;
        boolean flag = false;
        int actualSum = inputs[firstIndex];

        for (int index = 1; index <= noOfElements; index++) {

            while (actualSum > expectedSum && firstIndex < index - 1) {
                actualSum -= inputs[firstIndex++];
            }

            if (actualSum == expectedSum) {
                System.out.println(String.format("%s %s", firstIndex + 1, secondIndex));
                return true;
            }
            if (index < noOfElements)
                actualSum += inputs[secondIndex++];

        }
        return false;
    }
}