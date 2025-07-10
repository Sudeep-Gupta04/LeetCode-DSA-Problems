class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] newTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            newTasks[i][0] = tasks[i][0]; 
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;         
        }

        Arrays.sort(newTasks, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return a[2] - b[2]; 
                return a[1] - b[1]; 
            }
        });

        int[] ans = new int[n];
        int time = 0, i = 0, k = 0;

        while (k < n) {
            while (i < n && newTasks[i][0] <= time) {
                pq.add(newTasks[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time += cur[1];
                ans[k++] = cur[2];
            } else {
                time = newTasks[i][0];
            }
        }
        return ans;
    }
}
