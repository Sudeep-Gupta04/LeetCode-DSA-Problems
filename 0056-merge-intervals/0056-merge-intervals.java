class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> v = new ArrayList<>();
            v.add(intervals[i][0]);
            v.add(intervals[i][1]);
            al.add(v);
        }

        int i = 0;
        while (i < al.size() - 1) {
            if (al.get(i).get(1) >= al.get(i + 1).get(0)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(al.get(i).get(0));
                temp.add(Math.max(al.get(i).get(1), al.get(i + 1).get(1)));
                al.remove(i);
                al.remove(i);
                al.add(i, temp);
            } else {
                i++;
            }
        }

        int[][] ans = new int[al.size()][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j][0] = al.get(j).get(0);
            ans[j][1] = al.get(j).get(1);
        }

        return ans;

    }
}