package geeks.arrays;

import java.util.Scanner;

public class LeaderInArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfSamples = sc.nextInt();

        while (noOfSamples > 0) {
            final int noOfInputs = sc.nextInt();
            final int arr[] = new int[noOfInputs];

            for (int i = 0; i < noOfInputs; i++) {
                arr[i] = sc.nextInt();
            }
            findLeardersInArray(arr);
            noOfSamples--;
        }
    }

    private static void findLeardersInArray(int[] arr) {
        final int size = arr.length;
        final int[] leaderPosition = new int[size];
        int leadersCount = 0;
        int leader = arr[size-1];

        leaderPosition[leadersCount++] = leader;

        for (int i = size-2; i >=0  ; i--) {
            if( arr[i]>= leader ){
                leader = arr[i];
                leaderPosition[leadersCount++] = leader;
            }
        }
        StringBuffer sb = new StringBuffer();

        for (int i = leadersCount; i >=0 ; i--) {
            sb.append(leaderPosition[i]+" ");
        }
        System.out.println(sb.toString());
    }
}