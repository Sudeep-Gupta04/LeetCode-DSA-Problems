class Solution {

       public static int[][][] initializeArrayint(int dim1, int dim2, int dim3, int value) {
        int[][][] array = new int[dim1][dim2][dim3];
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                Arrays.fill(array[i][j], value);
            }
        }
        return array;
    }

    public int numTeams(int[] rating) {
        int[][][] dp = initializeArrayint(rating.length, rating.length, 3, -1);
        int ans = countPlayers(0, -1, rating, 0, dp);
        
        // Re-initialize dp array for the rotated array case
        dp = initializeArrayint(rating.length, rating.length, 3, -1);
        int[] reversedRating = reverseArray(rating);
        int rotatedAns = countPlayers(0, -1, reversedRating, 0, dp);

        return ans + rotatedAns;
    }

    private int countPlayers(int cur, int prv, int[] rating, int count, int[][][] dp) {
        if (count == 3) return 1;
        if (cur == rating.length) return 0;

        if (dp[cur][prv + 1][count] != -1) return dp[cur][prv + 1][count];

        int take = 0;
        if (prv == -1 || rating[prv] < rating[cur]) take = countPlayers(cur + 1, cur, rating, count + 1, dp);

        int notTake = countPlayers(cur + 1, prv, rating, count, dp);

        dp[cur][prv + 1][count] = take + notTake;

        return dp[cur][prv + 1][count];
    }

    private int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}