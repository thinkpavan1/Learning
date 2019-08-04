package geeks.arrays;

public class KthSmallestElement {
    public static void main(String[] args) {

        int[] arr = {3,2,1,4,5};

        int size = arr.length;
        int k = 3;

        findKthSmallestElement(arr, 0, size-1, k);
    }

    private static int findKthSmallestElement(int[] arr, int firstPosition, int lastPosition, int k) {
        if (k > 0 && k <= lastPosition-firstPosition +1 ) {
            int pos = randomPartition(arr, firstPosition, lastPosition);

            if ( pos -1 == k-1 )
                return arr[pos];
            if( pos -1 > k-1 )
                return findKthSmallestElement(arr, l, pos-1, k);
        }
    }

    private static int randomPartition(int[] arr, int firstPosition, int lastPosition) {
    }

}
