package geeks.arrays;

import java.util.Scanner;

public class Equilibrium {

    public static void main(String[] args) {
        int[] inputs ={1,3,5,2,2};
        System.out.println(findEquilibrium(inputs, inputs.length));
    }

    private static int findEquilibrium(int[] inputs, int inputSize) {
        int sum = 0, leftSum = 0;
        if( inputSize == 1){
            return inputs[inputSize-1];
        }

        for (int i = 0; i < inputSize; i++) {
            sum += inputs[i];
        }

        for (int i = 0; i < inputSize; i++) {
            sum -= inputs[i];

            if( sum == leftSum){
                return i + 1;
            }
            leftSum += inputs[i];
        }
        return -1;
    }
}
