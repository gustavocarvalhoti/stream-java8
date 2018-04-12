package br.com.stream;

public class TestHackerRank02 {
    // Driver method to test the above function
    public synchronized static void main(String[] args) {
        int arr[] = new int[]{4, 4, 2, 1, 3};
        System.out.println("Minimum difference is " +
                findMinDiff(arr, arr.length));

    }

    // Returns minimum difference between any pair
    public static int findMinDiff(int[] arr, int n) {
        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing difference
        // of all possible pairs in given array
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (Math.abs((arr[i] - arr[j])) < diff)
                    diff = Math.abs((arr[i] - arr[j]));

        // Return min diff
        return diff;
    }


}
