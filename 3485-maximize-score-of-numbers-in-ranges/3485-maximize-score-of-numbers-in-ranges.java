class Solution {
    int[] arr;
    
    public int maxPossibleScore(int[] start, int d) {
        arr = new int[start.length];
        Arrays.sort(start);
        for (int i = 0; i < start.length; i++) {
            arr[i] = start[i];
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < start.length - 1; i++) {
            if (start[i + 1] - start[i] < min) min = start[i + 1] - start[i];
            if (start[i + 1] - start[i] > max) max = start[i + 1] - start[i];
        }
        
        max = max + d;
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isValid1(mid, start, d)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return max;
    }

    private boolean isValid1(int mid, int[] start, int d) {
        // Create a temporary array to work on
        int[] temp = Arrays.copyOf(start, start.length);
        
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] < mid) {
                int original = temp[i + 1];
                temp[i + 1] = temp[i] + mid;
                
                // Check if the difference exceeds the allowed limit
                if (temp[i + 1] - original > d) return false;
            }
            // Ensure no value exceeds the allowed difference from the original array
            if (temp[i + 1] > arr[i + 1] + d || temp[i] > arr[i] + d) return false;
        }
        
        return true;
    }
}
