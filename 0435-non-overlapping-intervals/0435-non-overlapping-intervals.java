class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int[] pick = intervals[0];
        int c = 0;
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]<pick[1]) c++;
            else pick = intervals[i];
        }
        return c;
    }
}