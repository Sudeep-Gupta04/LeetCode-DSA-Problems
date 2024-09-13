class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        result[index++] = new int[] { rStart, cStart };

        int directionIndex = 0, length = 0;
        while (index < rows * cols) {
            if (directionIndex == 0 || directionIndex == 2) {
                length++;
            }

            for (int i = 0; i < length; i++) {
                rStart += directions[directionIndex][0];
                cStart += directions[directionIndex][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[index++] = new int[] { rStart, cStart };
                }
            }
            directionIndex = (directionIndex + 1) % 4;
        }
        return result;
    }
}
