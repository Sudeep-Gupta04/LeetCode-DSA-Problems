class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[grid.length * grid.length];
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                arr[k++] = grid[i][j];
            }
        }
        return findTwoElement(arr, grid.length * grid.length);
    }

    int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        int repeating = 0;

        // Find the repeating element
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                repeating = Math.abs(arr[i]);
                break;
            } else {
                arr[index] = -arr[index];
            }
        }
        ans[0] = repeating;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]);
        }
        long expectedSum = (long) n * (n + 1) / 2;
        ans[1] = (int) (expectedSum - (sum - repeating));
        return ans;
    }
}
